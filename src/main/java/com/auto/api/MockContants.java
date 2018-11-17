package com.auto.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


public class MockContants {
	@Value("${origin.url}")
	private String originUrl;
	
	@Value("${mock.config.mode}")
	private int mode;

	public String getOriginUrl() {
		return originUrl;
	}

	public void setOriginUrl(String originUrl) {
		this.originUrl = originUrl;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
	
}
