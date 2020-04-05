package com.aoki.forecast.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeasonDto {

	private Long id;
	private String name;
	private String city;
	private Date dateCity;
	
}
