package com.aoki.forecast.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.aoki.forecast.dto.SeasonDto;


@Service
public class ForecastService {
	
	private static long contador = 1;
	
	public void insertCityCreateId() {
		SeasonDto.builder().id(+contador);
		contador++;
	}
	
	public SeasonDto verify(long id) {

		
		if(id == 1) {
			Date localData = formatDate("10-01-2020");
			return SeasonDto.builder().id(id).name("sun").city("São Paulo").
					dateCity(localData).build();
		}else {
			if(id == 2) {
				Date localData = formatDate("11-11-2020");
				return SeasonDto.builder().id(id).name("autumn").city("Rio de Janeiro").
						dateCity(localData).build();
			}
		}
		return null;
	}

	private Date formatDate(String data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
		Date localData = null;
		try {
			localData = formatador.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return localData;
	}

	public SeasonDto insertCity(String name, String city) {
		try {
			insertCityCreateId();
			Date localData = formatDate("10-01-2020");
			
			//ainda nai sendo utilizado
//			ArrayList<SeasonDto> cityInformation = new ArrayList<SeasonDto>();
//			extracted(name, city, localData, cityInformation);
//			
			
			return SeasonDto.builder().id(contador).name(name).city(city).
					dateCity(localData).build();
		} catch (IllegalArgumentException e) {
			System.out.println("Campo invalido");
		}
		return null;
	}

	private boolean extracted(String name, String city, Date localData, ArrayList<SeasonDto> cityInformation) {
		return cityInformation.add(SeasonDto.builder().id(contador).name(name).city(city).
				dateCity(localData).build());
	}

}
