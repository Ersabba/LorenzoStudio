package com.ericsson.urm.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class JSONObjectFactory {
	public static <T> String objectToJSON(T obj) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(obj);
		
		return json;
	}
	
	public static <T> String objectToPrettyJSON(T obj) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		
		return json;
	}
	
	public static <T> T jsonToObject(File file, Class<T> clsRet) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		Object obj = mapper.readValue(file, clsRet);
		
		return clsRet.cast(obj);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(File file, TypeReference<T> typeReference) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		Object obj = mapper.readValue(file, typeReference);
		
		return (T)obj;
	}
	
	public static <T> T jsonToObject(String json, Class<T> clsRet) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		Object obj = mapper.readValue(json, clsRet);
		
		return clsRet.cast(obj);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObject(String json, TypeReference<T> typeReference) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		Object obj = mapper.readValue(json, typeReference);
		
		return (T)obj;
	}
}
