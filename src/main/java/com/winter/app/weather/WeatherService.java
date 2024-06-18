package com.winter.app.weather;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherDAO dao;
	
	
	public void getList() {
		System.out.println("service list");
		
	}

}
