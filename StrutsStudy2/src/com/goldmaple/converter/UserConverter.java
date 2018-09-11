package com.goldmaple.converter;

import java.util.Map;
import java.util.StringTokenizer;

import org.apache.catalina.User;

import ognl.DefaultTypeConverter;

public class UserConverter extends DefaultTypeConverter {

	@Override
	public Object convertValue(Map context, Object value, Class toType) {
		if(User.class==toType){
			StringTokenizer stringTokennizer = new StringTokenizer("",";");
			
		}
		return toType;
		
	}
	
}
