package framework;

import framework.utils.LoggerUtils;
import framework.utils.PropertyUtils;

public class BaseTestCase {
	private static PropertyUtils properties;
	
	public static void init(){
		LoggerUtils.init();
		properties = PropertyUtils.getPropertiesInstance();
	}

}
