package pojos;

import java.util.List;
import java.util.Map;

public class Weather
{
    private String id;
    private String base;
    private String icon;
    private String visibility;
    private String dt;
    private String name;
    private String cod;
    private Map<String,String> main;
    private Map<String,String> coord;
    private Map<String,String> wind;
    private Map<String,String> clouds;
    private Map<String,String> sys;
    private List<Map<String,String>> weather;
    private Map<String,String> rain; 
    
    public Map<String, String> getRain() {
		return rain;
	}
	public void setRain(Map<String, String> rain) {
		this.rain = rain;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public Map<String, String> getMain() {
		return main;
	}
	public void setMain(Map<String, String> main) {
		this.main = main;
	}
	public Map<String, String> getCoord() {
		return coord;
	}
	public void setCoord(Map<String, String> coord) {
		this.coord = coord;
	}
	public Map<String, String> getWind() {
		return wind;
	}
	public void setWind(Map<String, String> wind) {
		this.wind = wind;
	}
	public Map<String, String> getClouds() {
		return clouds;
	}
	public void setClouds(Map<String, String> clouds) {
		this.clouds = clouds;
	}
	public Map<String, String> getSys() {
		return sys;
	}
	public void setSys(Map<String, String> sys) {
		this.sys = sys;
	}
	public List<Map<String, String>> getWeather() {
		return weather;
	}
	public void setWeather(List<Map<String, String>> weather) {
		this.weather = weather;
	}
	
	
    

    
}