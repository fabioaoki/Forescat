package com.aoki.forecast.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.aoki.forecast.dto.SeasonDto;

@Service
public class ForecastService {

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
}
