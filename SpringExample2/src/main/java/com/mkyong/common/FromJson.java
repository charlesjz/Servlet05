package com.mkyong.common;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FromJson {
	
	public static String toUrl(String jsonStr) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		jsonStr=jsonStr.replace("@", "");
		ListItem e = objectMapper.readValue(jsonStr, ListItem.class);
		
//		System.out.println(e);
//		System.out.println("Type    : " + e.getType());
//		System.out.println("Position: " + e.getPosition());
//		System.out.println("Url     : " + e.getUrl());
		
		return e.getUrl();
	}
	
	public static String toType(String jsonStr) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		jsonStr=jsonStr.replace("@", "");
		ListItem e = objectMapper.readValue(jsonStr, ListItem.class);
		
//		System.out.println(e);
//		System.out.println("Type    : " + e.getType());
//		System.out.println("Position: " + e.getPosition());
//		System.out.println("Url     : " + e.getUrl());
		
		return e.getType();
	}
	
	public static int toPosition(String jsonStr) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		jsonStr=jsonStr.replace("@", "");
		ListItem e = objectMapper.readValue(jsonStr, ListItem.class);
		
//		System.out.println(e);
//		System.out.println("Type    : " + e.getType());
//		System.out.println("Position: " + e.getPosition());
//		System.out.println("Url     : " + e.getUrl());
		
		return e.getPosition();
	}
	
	
}
