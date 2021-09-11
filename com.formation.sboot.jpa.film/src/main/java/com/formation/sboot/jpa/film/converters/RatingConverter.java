package com.formation.sboot.jpa.film.converters;

import com.formation.sboot.jpa.film.entities.Rating;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class RatingConverter implements AttributeConverter<Rating,String> {

//	private static Logger log = LogManager.getLogger(RatingConverter.class);
	
	@Override
	public String convertToDatabaseColumn(Rating attribute) {
		return attribute.name().replaceAll("_", "-");
	}

	@Override
	public Rating convertToEntityAttribute(String dbData) {
		return Rating.valueOf(dbData.replaceAll("-", "_"));
	}
}
