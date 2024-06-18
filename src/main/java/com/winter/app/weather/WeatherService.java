package com.winter.app.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	
	@Autowired
	private WeatherDAO dao;
	
	
	public List<WeatherDTO> getList() {
		List<WeatherDTO> dtos = null;
		try {
			dtos = dao.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dtos;
		
	}
	
	public void getDetail() {
		
		dao.getDetail();
		
	}

}
