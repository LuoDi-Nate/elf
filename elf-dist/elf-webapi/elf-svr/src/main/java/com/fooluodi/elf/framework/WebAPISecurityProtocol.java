package com.fooluodi.elf.framework;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * @author di
 * 所有url 类的常量
 * */
public class WebAPISecurityProtocol {
	

	public static final String PING = "/ping";


	public static final String HTTP_ACCESS_TOKEN = "HTTP_ACCESS_TOKEN";

    public static final String COFFEE_TOKEN = "COFFEE_TOKEN";

	public static final String HTTP_TIMESTAMP = "HTTP_TIMESTAMP";

	public static final String HTTP_DEVICE_ID = "HTTP_DEVICE_ID";

	public static final String HTTP_SIGNATURE = "HTTP_SIGNATURE";

	public static final String HTTP_CONSUMER_KEY = "HTTP_CONSUMER_KEY";

	public static final String CUSTOM_HEADERS = "Content-Type,X-Requested-With,Accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers, HTTP_CONSUMER_KEY, HTTP_DEVICE_ID, HTTP_SIGNATURE, HTTP_ACCESS_TOKEN, HTTP_TIMESTAMP";

	/**
	 * 如有必要，可以对request进行验证
	 * @param request
	 * @return
	 */
	public boolean checkSign(HttpServletRequest request) {
		String uri = request.getRequestURI();

		String timestamp = request.getHeader(HTTP_TIMESTAMP);

		String access_token = request.getHeader(HTTP_ACCESS_TOKEN);

		String device_id = request.getHeader(HTTP_DEVICE_ID);

		String consumer_key = request.getHeader(HTTP_CONSUMER_KEY);

		String signature = request.getHeader(HTTP_SIGNATURE);

		Map<String, String[]> params = request.getParameterMap();

		return true;
	}

}
