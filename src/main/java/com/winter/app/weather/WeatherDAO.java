package com.winter.app.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.stereotype.Repository;

@Repository
public class WeatherDAO {
	
	public List<WeatherDTO> getList() throws Exception {
		ArrayList<WeatherDTO> dtos = new ArrayList<WeatherDTO>();
		
		File file = new File("C:\\Study", "weather.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			WeatherDTO dto = new WeatherDTO();
			
			String s = br.readLine();
			if(s == null) {
				break;
			}
			s = s.replace(",", "-");
			
			StringTokenizer st = new StringTokenizer(s, "-");
			
			while(st.hasMoreTokens()) {
				dto.setNum(Long.parseLong(st.nextToken().trim()));
				dto.setCity(st.nextToken().trim());
				dto.setTemperature(Double.parseDouble(st.nextToken().trim()));
				dto.setStatus(st.nextToken().trim());
				dto.setHumidity(Integer.parseInt(st.nextToken().trim()));
				
				dtos.add(dto);
			}
		}
		
		br.close();
		fr.close();
		
		return dtos;
		
	}
	
	public void getDetail() {
		
	}

}
