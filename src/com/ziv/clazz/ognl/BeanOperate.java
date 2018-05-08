package com.ziv.clazz.ognl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

import com.ziv.util.string.StringUtiles;

/** 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月6日   下午6:34:53 
 * 类说明 :
 * 
*/
public class BeanOperate {
	private Object obj;
	private String property;
	private Object value;	//	属性的值
	private Field field;	//	属性的对象
	private String fieldName;	//	属性的民称
	private Object currentObject;	//	属性对象
	public BeanOperate(Object obj, String property, Object value) {
		this.obj = obj;
		this.property = property;
		this.value = value;
		this.handleString();
		this.setFieldValue();
	}
	private void handleString() {
		String result[] = this.property.split("\\.");
		this.currentObject = this.obj;
		try {
			if(result.length == 2) {
				this.field = this.obj.getClass().getDeclaredField(result[1]);
				this.fieldName = result[1];
			}else {
				for (int x = 1; x < result.length; x++) {
					Method getMet = this.currentObject.getClass().getMethod(
							"get" + StringUtiles.initcap(result[x]));
					this.field = this.currentObject.getClass().getDeclaredField(result[x]);
					this.fieldName = result[x];
					if(x < result.length -1) {					
						this.currentObject = getMet.invoke(this.currentObject);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void setFieldValue() {
		try {
			Method setMet = this.currentObject.getClass().getMethod("set" + StringUtiles.initcap(this.fieldName), this.field.getType());
			String type = this.field.getType().getSimpleName();
			String valueType = this.value.getClass().getSimpleName();
			if("string".equalsIgnoreCase(valueType) || "String".equalsIgnoreCase(valueType)) {
				String val = this.value.toString();
				if("int".equalsIgnoreCase(type) || "Integer".equalsIgnoreCase(type)) {
					if(val.matches("\\d+")) {					
						setMet.invoke(this.currentObject, Integer.parseInt(val));
					}
				}else if("double".equalsIgnoreCase(type) || "Double".equalsIgnoreCase(type)) {
					if(val.matches("\\d+(\\.\\d+)?")){
						setMet.invoke(this.currentObject, Double.parseDouble(val));
					}
				}else if("String".equalsIgnoreCase(type) || "string".equalsIgnoreCase(type)) {
					setMet.invoke(this.currentObject, this.value);
				}else if("date".equalsIgnoreCase(type) || "Date".equalsIgnoreCase(type)) {
					if(val.matches("\\d{4}-\\d{2}-\\d{2}")) {
						setMet.invoke(this.currentObject, new SimpleDateFormat("yyyy-MM-dd").parse(val));
					}
				}
			} else {
				String val[] = (String[]) this.value;
				this.field.setAccessible(true);
				if("String[]".equalsIgnoreCase(type)) {
//					setMet.invoke(this.currentObject, val);
					this.field.set(this.currentObject, val);
				}else if("int[]".equalsIgnoreCase(type) || "Integer[]".equalsIgnoreCase(type)) {
					Integer data[] = new Integer[val.length];
					for (int x = 0; x < data.length; x++) {
						data[x] = Integer.parseInt(val[x]);
					}
//					setMet.invoke(this.currentObject, data);
					this.field.set(this.currentObject, data);
				}else if("double[]".equalsIgnoreCase(type) || "Double[]".equalsIgnoreCase(type)) {
					Double data[] = new Double[val.length];
					for (int x = 0; x < data.length; x++) {
						data[x] = Double.parseDouble(val[x]);
					}
//					setMet.invoke(this.currentObject, data);
					this.field.set(this.currentObject, data);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Object getCurrentObject() {
		return currentObject;
	}
	public Field getField() {
		return field;
	}
}
 