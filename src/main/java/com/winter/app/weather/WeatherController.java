package com.winter.app.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherService service;
	
	
	@RequestMapping("/weather/list")
	public String getList(HttpServletRequest request) {
	
		List<WeatherDTO> dtos = service.getList();
		
		request.setAttribute("dtos", dtos);
		
		return "weather/list";
	}
	
	@RequestMapping("/weather/detail")
	public String getDetail() {
		
		service.getDetail();
		
		return "weather/detail";
		
	}
	
	@RequestMapping(value = "/weather/add", method=RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value = "/weather/add", method=RequestMethod.POST)
	public void add2() {
		
	}

}
