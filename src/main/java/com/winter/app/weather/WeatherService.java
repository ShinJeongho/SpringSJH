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
	
	public WeatherDTO getDetail(WeatherDTO dto) {
		
		try {
			dto = dao.getDetail(dto);
		} catch (Exception e) {
			e.printStackTrace();
			dto = null;
		}
		return dto;
	}
	
	public void getAdd(WeatherDTO dto) {
		try {
			dao.getAdd(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getDelete(WeatherDTO dto) {
		
		try {
			dao.getDelete(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getUpdate(WeatherDTO dto) {
		
		try {
			dao.getUpdate(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
