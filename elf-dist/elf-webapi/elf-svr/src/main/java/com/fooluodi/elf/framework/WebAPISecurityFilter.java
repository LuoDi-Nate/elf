package com.fooluodi.elf.framework;

import com.fooluodi.elf.common.exception.ElfServiceException;
import com.fooluodi.elf.common.util.JsonHelper;
import com.fooluodi.elf.session.service.ISessionService;
import com.fooluodi.elf.user.dto.ElfUserInnerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by di on 2015年11月17日16:02:37
 *
 * 拦截所有的http请求,
 * 放过白名单外的请求
 * 对剩下的请求做安全校验, 提取ACCESS-TOKEN, 包装出来ElfUser后添加到httpRequest中
 * 在controller中如果需要ElfUser, 直接在方法体中声明ElfUser, springMvcResolver会自动为其装配Bean
 */

public class WebAPISecurityFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(WebAPIBaseController.class);

    @Resource
    private ISessionService sessionService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        corsResponse(httpResponse);

        // 不验证ping 方法
        if (urlInWhiteList(httpRequest)){
            chain.doFilter(request, response);
            return;
        }
        ResponseEntity<?> error = null;
        try {
            error = securityCheck(httpRequest, httpResponse);
        } catch (Exception e) {
            logger.error("security check error", e);
            error =new ResponseEntity("300001", "没有检测到登陆", null);
        }
        if (error != null) {
            httpResponse.setContentType("application/json");
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.getWriter().write(JsonHelper.transObjToJsonString(error));
            httpResponse.getWriter().flush();
            return;
        }

        try{
            chain.doFilter(request, response);
        }catch (Throwable t){
            logger.error("some error!", t);
            handleException((HttpServletResponse)response, t);
        }


        return;
    }
    private void handleException(HttpServletResponse response, Throwable throwable){
        try {
        	ResponseEntity responseEntity  = null;
        	if(throwable.getCause() instanceof ElfServiceException){
                ElfServiceException midasServiceException = (ElfServiceException) throwable.getCause();
        		responseEntity = new ResponseEntity(midasServiceException.getErrorCode(), midasServiceException.getMessage(), null);
        	}else {
        		responseEntity = new ResponseEntity("20002", "UNKNOWN_ERROR", null);
			}
        	response.getWriter().write(JsonHelper.transObjToJsonString(responseEntity));
        	response.getWriter().flush();
        } catch (IOException e) {
            logger.error("handle error!", e);
        }
    }

    private ResponseEntity<?> securityCheck(HttpServletRequest request, HttpServletResponse response) throws ElfServiceException {
        //token存放在request的hearder里
		String access_token = request.getHeader(WebAPISecurityProtocol.ACCESS_TOKEN);
        logger.info("get a request ACCESS-TOKEN:{}", access_token);

        if (access_token == null || access_token.trim().equals("")) {
            logger.error("access_token is null , or access_token is empty ");
            return new ResponseEntity("300001", "没有检测到登陆", null);
        }

        // 获得ElfUserDto对象
        ElfUserInnerDto elfUser = new ElfUserInnerDto();

        try {
            elfUser = sessionService.getUserByToken(access_token);
        } catch (ElfServiceException e) {
            logger.error("security Check error : " + e.getMessage());
            return new ResponseEntity<String>(e.getErrorCode(), e.getMessage(), "");
        }
        // 将对象存入request中
        request.setAttribute(WebAPISecurityProtocol.ELF_USER, elfUser);

        return null;
    }

    /**
     * Cross-origin resource sharing (CORS)
     *
     * @param response
     */
    private void corsResponse(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", WebAPISecurityProtocol.CUSTOM_HEADERS);
    }

    @Override
    public void destroy() {
    }

    /**
     * 查看来访url是否是白名单
     * */
    private boolean urlInWhiteList(HttpServletRequest httpRequest){
        return httpRequest.getRequestURI().endsWith(WebAPISecurityProtocol.PING);
    }
}
