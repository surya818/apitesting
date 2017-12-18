package framework.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtils {
	public static Logger logger;
	public static void init(){
		logger = Logger.getLogger(LoggerUtils.class.getName());
	}
	public static void log(String msg){
		logger.log(Level.INFO, msg);
	}
	public static void err(String msg){
		logger.log(Level.SEVERE, msg);
	}
	public static void newLine(){
		logger.log(Level.INFO,"\n"
				+"################################################################################"
				+"\n");
	}
}
