package com.winter.app.weather;

public class WeatherDTO {
	
	private String city;
	private Double temperature;
	private Integer humidity;
	private String status;
	private long num;
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Integer getHumidity() {
		return humidity;
	}
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}

}
