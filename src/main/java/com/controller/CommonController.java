package com.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

public class CommonController implements Serializable {

	private static final long serialVersionUID = -8689087516560483976L;
	private static ObjectMapper mapper;

	protected ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			//mapper.registerModule(new JodaModule());
			//mapper.registerModule(JstModule());
			mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
			mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

			// Borramos los campos que están a null
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		}
		return mapper;
	}
}
