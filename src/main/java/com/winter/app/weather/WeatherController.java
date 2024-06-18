package com.winter.app.weather;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {
	
	
	@RequestMapping("/weather/list")
	public String getList() {
		System.out.println("list 가져오기");
		
		return "weather/list";
	}

}
