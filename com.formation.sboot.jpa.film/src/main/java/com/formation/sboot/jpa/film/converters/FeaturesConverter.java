package com.formation.sboot.jpa.film.converters;

import java.util.Arrays;
import java.util.List;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FeaturesConverter implements AttributeConverter<List<String>,String> {

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {	
		return String.join(",", attribute);
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {	
//		List<String> r = new ArrayList<String>();
//		String[] feat = dbData.split(",");
//		for(String s : feat) {
//			r.add(s);
//		}

		return Arrays.asList(dbData.split(","));
	}
}
