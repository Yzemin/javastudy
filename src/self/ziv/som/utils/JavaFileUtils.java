package self.ziv.som.utils; 
/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月15日   上午9:50:55 
 * 类说明 :
 * 		java文件操作
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import self.ziv.som.bean.ColumnInfo;
import self.ziv.som.bean.JavaFieldGetSet;
import self.ziv.som.bean.TableInfo;
import self.ziv.som.core.DBManager;
import self.ziv.som.core.MysqlTypeConvertor;
import self.ziv.som.core.TableContext;
import self.ziv.som.core.TypeConvertor;

public class JavaFileUtils {
	/**
	 * 根據字段生成java字段，set,get
	 * @param colum 字段信息
	 * @param convertor 類型轉換
	 * @return java屬性和set/get
	 */
	private static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();
		String javaFieldType = convertor.databaseType2JavaType(column.getDataType());
		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName()+";\n");
		jfgs.setGetInfo("\tpublic "+ javaFieldType + 
				" get"+StringUtils.firstChar2UpperCase(column.getName()) + "(){\n" +
				"\t\treturn "+column.getName()+";\n\t}\n");
		jfgs.setSetInfo("\tpublic void set" + StringUtils.firstChar2UpperCase(column.getName()) +
				"(" + javaFieldType + " " + column.getName() + "){\n" +
				"\t\tthis." + column.getName() + " = "+ column.getName() + ";\n\t}\n");
		return jfgs;
	}
	
	/**
	 * 根據表信息生成java的源文件
	 * @param tableInfo 表信息
	 * @param convertor 數據類型轉化器
	 * @return
	 */
	private static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {
		Map<String, ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();
		for (ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c,convertor));
		}
		StringBuilder src = new StringBuilder();
		src.append("package " + DBManager.getConf().getPoPackage() +";\n\n")
//			.append("import java.util.*;\n")
//			.append("import java.sql.*;\n\n")
			.append("public class " + StringUtils.firstChar2UpperCase(tableInfo.getTname()) + " {\n");
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n");
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo()).append(f.getSetInfo());
		}
		src.append("}\n");
		return src.toString();
	}
	
	/**
	 * 創建表對象
	 * @param tableInfo
	 * @param convertor
	 */
	public static void createJavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {
		String src = createJavaSrc(tableInfo,convertor);
		BufferedWriter bw = null;
		String srcPath = DBManager.getConf().getSrcPath() +"\\";
		String packagePath = DBManager.getConf().getPoPackage().replaceAll("\\.","\\\\");
		File f = new File(srcPath + packagePath );
		if(!f.exists()) {
			f.mkdirs();
		}
		System.out.println(f.getAbsoluteFile() + "\\" +
						StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java");
		try {
			bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile() + "\\" +
						StringUtils.firstChar2UpperCase(tableInfo.getTname()) + ".java"));
			bw.write(src);
			bw.flush();
		} catch (Exception e) {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
/*	public static void main(String[] args) {
		ColumnInfo ci = new ColumnInfo("username","date",0);
		JavaFieldGetSet src = createFieldGetSetSRC(ci, new MysqlTypeConvertor());
		src.toStringSelf();
		
		Map<String, TableInfo> tables = TableContext.tables;
		TableInfo t = tables.get("provinces");
		System.out.println(createJavaSrc(t,new MysqlTypeConvertor()));
		
		Map<String, TableInfo> tables = TableContext.getTableInfos();
		for (TableInfo t : tables.values()) {			
			createJavaPOFile(t, new MysqlTypeConvertor());
		}
		
	}*/
}
 