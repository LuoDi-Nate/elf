package com.fooluodi.elf.sms.common.http;

public class HttpResponseEntity {
	private String responseContent;

	private int responseCode;

	public String getResponseContent() {
		return responseContent;
	}

	public void setResponseContent(String responseContent) {
		this.responseContent = responseContent;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

}
