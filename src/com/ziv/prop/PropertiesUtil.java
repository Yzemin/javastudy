package com.ziv.prop;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
/**
 * 
 * @author 作者 E-mail: ziv 八重齿   @2374619909.com
 * @version 创建时间：  2018年4月5日   上午11:46:23 
 * 类说明 :
 *
 */
public class PropertiesUtil {


    private static Properties props = null;

    static {
        String fileName = "jdbc.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
        	System.out.println("jdb.properties is error !");
			e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        String value = props.getProperty(key.trim());
        if(value == null){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){
        String value = props.getProperty(key.trim());
        if(value == null){
            value = defaultValue;
        }
        return value.trim();
    }
    
    public static void main(String[] args) {
    	System.out.println(props);
		System.out.println(PropertiesUtil.getProperty("jdbc.driver"));
	}

}
