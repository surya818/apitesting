package framework.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertyUtils {
	private static String filename;
	public static String getFilename() {
		return filename;
	}
	public static void setPropertyFilename(String filename) {
		PropertyUtils.filename = filename;
	}

	private static Properties properties;
	private static PropertyUtils propertyutils;
	private PropertyUtils(){

	}
	public static PropertyUtils getPropertiesInstance(){
		if(properties == null){
			properties = new Properties();
			try {
				properties.load(new FileReader(filename));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return propertyutils;
		}
		else{
			return propertyutils;
		}

	}

	public static String getProperty(String propertyName){
		return PropertyUtils.properties.getProperty(propertyName);
	}
}
