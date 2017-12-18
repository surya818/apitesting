package framework.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WeatherUtils {
	private static WeatherUtils instance = null;
	public static void main(String[] args) {
		WeatherUtils utils = WeatherUtils.getWeatherUtilsInstance();
		String url = utils.createWeatherAPIURL("http://api.openweathermap.org/data/2.5/weather", "q=Dublin", "deab6b3d8ab8aee1edbaa4c753b2a165");
		String url1 = utils.createWeatherAPIURL("http://api.openweathermap.org/data/2.5/weather", "q=São Tomé", "deab6b3d8ab8aee1edbaa4c753b2a165");
		System.out.println(url1);
	}
	private WeatherUtils(){
		
	}
	public static WeatherUtils getWeatherUtilsInstance(){
		if(instance == null){
			return new WeatherUtils();
		}
		else{
			return instance;
		}
	}
	public String createWeatherAPIURL(String base_url,String query,String app_id){
		StringBuilder builder = new StringBuilder();
		builder.append(base_url+"?");
		builder.append(query+"&");
		builder.append("appid="+app_id);
		String url = builder.toString();
		url = url.replaceAll(" ", "%20");
		return url;
	}

}
