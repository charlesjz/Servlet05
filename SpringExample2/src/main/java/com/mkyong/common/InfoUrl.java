package com.mkyong.common;

import org.springframework.stereotype.Component;

@Component("infoUrl")
public class InfoUrl {

	private String url;
	private String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
