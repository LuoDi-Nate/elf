package com.fooluodi.elf.framework;

import com.fooluodi.elf.user.dto.ElfUserDto;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author di
 * mvcResolver
 *
 * 如果controller里面声明需要提供ElfUserDto, 则将Dto传入controller
 *
 * */
public class ContextWebArgumentResolver implements WebArgumentResolver {

	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
		if (methodParameter.getParameterType().equals(ElfUserDto.class)) {
			Object request = webRequest.getNativeRequest();
			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				return httpRequest.getAttribute(WebAPISecurityProtocol.ELF_USER);
			}
		}
		return UNRESOLVED;
	}
}
