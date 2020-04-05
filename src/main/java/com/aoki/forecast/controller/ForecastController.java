package com.aoki.forecast.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aoki.forecast.dto.SeasonDto;
import com.aoki.forecast.service.ForecastService;

@RestController
public class ForecastController {
	
	@Autowired
	ForecastService forecastService;
	
	@RequestMapping(value="/weather/{id}",method = RequestMethod.GET)
	public ResponseEntity<SeasonDto> weather(@PathVariable(value= "id") long id) {
		SeasonDto seasonDto = forecastService.verify(id);
		if(Objects.nonNull(seasonDto)) {
			return new ResponseEntity<SeasonDto>(seasonDto,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
