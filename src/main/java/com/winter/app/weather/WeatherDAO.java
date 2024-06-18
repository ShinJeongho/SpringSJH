package com.winter.app.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
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
	
	public WeatherDTO getDetail(WeatherDTO dto)throws Exception {
		List<WeatherDTO> dtos = this.getList();
		WeatherDTO result = null;

		for (int i = 0; i < dtos.size(); i++) {
			if (dtos.get(i).getNum() == dto.getNum()) {
				result = dtos.get(i);
				break;
			}
		}
		return result;
		
	}
	
	public void getAdd(WeatherDTO dto) throws Exception{
		List<WeatherDTO> ar = this.getList();

		File file = new File("C:\\Study", "weather.txt");

		FileWriter fw = new FileWriter(file, true);

		Calendar ca = Calendar.getInstance();

		String s = "";
		fw.write("\n");
		fw.write(s.valueOf(ca.getTimeInMillis()));
		fw.write("-");
		fw.write(dto.getCity());
		fw.write("-");
		fw.write(s.valueOf(dto.getTemperature()));
		fw.write("-");
		fw.write(dto.getStatus());
		fw.write("-");
		fw.write(s.valueOf(dto.getHumidity()));

		fw.close();
	}
	
	public void getDelete(WeatherDTO dto)throws Exception {
		
		List<WeatherDTO> ar = this.getList();

		for (int i = 0; i < ar.size(); i++) {
			if (dto.getNum() == ar.get(i).getNum()) {
				ar.remove(i);
				break;
			}
		}

		File file = new File("C:\\Study", "weather.txt");

		FileWriter fw = new FileWriter(file, false);

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < ar.size(); i++) {
			sb.append(ar.get(i).getNum());
			sb.append("-");
			sb.append(ar.get(i).getCity());
			sb.append("-");
			sb.append(ar.get(i).getTemperature());
			sb.append("-");
			sb.append(ar.get(i).getStatus());
			sb.append("-");
			sb.append(ar.get(i).getHumidity());
			sb.append("\r\n");
		}

		fw.write(sb.toString());

		fw.flush();
		fw.close();
	}
	
	public void getUpdate(WeatherDTO dto)throws Exception {
		
		List<WeatherDTO> ar = this.getList();

		for (int i = 0; i < ar.size(); i++) {
			if (dto.getNum() == ar.get(i).getNum()) {
				ar.get(i).setCity(dto.getCity());
				ar.get(i).setTemperature(dto.getTemperature());
				ar.get(i).setStatus(dto.getStatus());
				ar.get(i).setHumidity(dto.getHumidity());
				break;
			}
		}
		
		File file = new File("C:\\Study", "weather.txt");

		FileWriter fw = new FileWriter(file, false);

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < ar.size(); i++) {
			sb.append(ar.get(i).getNum());
			sb.append("-");
			sb.append(ar.get(i).getCity());
			sb.append("-");
			sb.append(ar.get(i).getTemperature());
			sb.append("-");
			sb.append(ar.get(i).getStatus());
			sb.append("-");
			sb.append(ar.get(i).getHumidity());
			sb.append("\r\n");
		}

		fw.write(sb.toString());

		fw.flush();
		fw.close();
		
	}

}
