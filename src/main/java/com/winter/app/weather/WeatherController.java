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
	public String getDetail(HttpServletRequest request) {
		
		String num = request.getParameter("num");
		WeatherDTO dto = new WeatherDTO();
		dto.setNum(Long.parseLong(num));
		dto = service.getDetail(dto);
		
		if (dto != null) {
			request.setAttribute("dto", dto);
			return "weather/detail";
		} else {
			request.setAttribute("message", "정보가 없습니다.");
			return "commons/message";
		}
		
	}
	
	@RequestMapping(value = "/weather/add", method=RequestMethod.GET)
	public String add() {
		
		return "weather/add";
	}
	
	@RequestMapping(value = "/weather/add", method=RequestMethod.POST)
	public String add2(HttpServletRequest request) {
		
		String city = request.getParameter("city");
		double temperature = Double.parseDouble(request.getParameter("temperature"));
		String status = request.getParameter("status");
		Integer humidity = Integer.parseInt(request.getParameter("humidity"));

		WeatherDTO dto = new WeatherDTO();
		dto.setCity(city);
		dto.setTemperature(temperature);
		dto.setStatus(status);
		dto.setHumidity(humidity);
		service.getAdd(dto);
		
		return "redirect:weather/list";
	}
	
	@RequestMapping("/weather/delete")
	public String getDelete(HttpServletRequest request) {
		
		String num = request.getParameter("num");
		WeatherDTO dto = new WeatherDTO();
		dto.setNum(Long.parseLong(num));
		service.getDelete(dto);

		return "redirect:weather/list";
	}
	
	@RequestMapping(value = "/weather/update", method=RequestMethod.GET)
	public String getUpdate(HttpServletRequest request) {
		
		WeatherDTO dto = new WeatherDTO();
		dto.setNum(Long.parseLong(request.getParameter("num")));
		dto = service.getDetail(dto);
		request.setAttribute("dto", dto);
		
		return "weather/update";
	}
	
	@RequestMapping(value = "/weather/update", method=RequestMethod.POST)
	public String getUpdate2(HttpServletRequest request) {
		
		WeatherDTO dto = new WeatherDTO();
		dto.setNum(Long.parseLong(request.getParameter("num")));
		dto.setCity(request.getParameter("city"));
		dto.setTemperature(Double.parseDouble(request.getParameter("temperature")));
		dto.setStatus(request.getParameter("status"));
		dto.setHumidity(Integer.parseInt(request.getParameter("humidity")));
		
		service.getUpdate(dto);
		
		return "redirect:weather/list";
	}

}
