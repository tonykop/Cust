package com.maoguang.factory;

import java.io.FileReader;
import java.util.Properties;


public class BasicFactory {
	private static BasicFactory factory=new BasicFactory();
	private static Properties prop=null;
	private BasicFactory(){
		
	}
	
	public static BasicFactory getFactory(){
		return factory;
	}
	
	static{
		try {
			prop=new Properties();
			prop.load(new FileReader(BasicFactory.class.getClassLoader().getResource("config.properties").getPath()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}

	public <T> T getInstance(Class<T> clazz){
		
		try {
			String cName=clazz.getSimpleName();
			String cImplName=prop.getProperty(cName);
			return (T) Class.forName(cImplName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
}
