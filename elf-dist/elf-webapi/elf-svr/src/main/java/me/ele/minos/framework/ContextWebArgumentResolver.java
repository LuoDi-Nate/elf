package me.ele.minos.framework;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class ContextWebArgumentResolver implements WebArgumentResolver {


	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
//		if (methodParameter.getParameterType().equals(MinosUser.class)) {
//			Object request = webRequest.getNativeRequest();
//			if (request instanceof HttpServletRequest) {
//				HttpServletRequest httpRequest = (HttpServletRequest) request;
//				return httpRequest.getAttribute(WebAPISecurityProtocol.MINOS_USER);
//			}
//		}
		return UNRESOLVED;
	}
}
