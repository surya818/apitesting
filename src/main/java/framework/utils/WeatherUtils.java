package framework.utils;


public class WeatherUtils {
	private static WeatherUtils instance = null;

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
