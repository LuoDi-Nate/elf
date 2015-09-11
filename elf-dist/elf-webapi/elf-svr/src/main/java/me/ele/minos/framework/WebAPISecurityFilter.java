package me.ele.minos.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by di on 21/8/15.
 * 对于白名单外的请求 验证登陆, 并且将通过验证的请求内加入User参数
 */
import com.fooluodi.elf.register.common.util.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.WebUtils;


public class WebAPISecurityFilter implements Filter {
    final static Logger logger = LoggerFactory.getLogger(WebAPISecurityFilter.class);

    private WebAPISecurityProtocol securityProtocol = new WebAPISecurityProtocol();

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
            error = new ResponseEntity<String>("SECURITY_CHECK_ERROR", "安全检查失败", "请重新登录");
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
            handleException((HttpServletResponse)response);
        }


        return;
    }
    private void handleException(HttpServletResponse response){
        try {
            ResponseEntity responseEntity = new ResponseEntity("20002", "UNKNOWN_ERROR", null);
            response.getWriter().write(JsonHelper.transObjToJsonString(responseEntity));
            response.getWriter().flush();
        } catch (IOException e) {
            logger.error("handle error!", e);
        }
    }

    private ResponseEntity<?> securityCheck(HttpServletRequest request, HttpServletResponse response) {
        //token存放在request的hearder里
//		String access_token = request.getHeader(WebAPISecurityProtocol.HTTP_ACCESS_TOKEN);
        String access_token = "f4a9fd0b-7aaf-44c1-8982-18338bcefcfe";
        logger.debug("准备检查token");
        //get cookie
        Cookie cookie = WebUtils.getCookie(request, WebAPISecurityProtocol.COFFEE_TOKEN);
        logger.debug("查看cook" + cookie);
//        没拿到抛错
        if (cookie == null) {
            logger.error("access_token is null , or access_token is empty ");
            return new ResponseEntity("20001", "没有检测到登陆", null);
        }
        access_token = cookie.getValue();

        if (access_token == null || access_token.trim().equals("")) {
            logger.error("access_token is null , or access_token is empty ");
            return new ResponseEntity("20001", "没有检测到登陆", null);
        }

        // 1,通过token，查询coffee-hr系统，验证token的有效性
//        MinosUser minosUser = new MinosUser();
//        try {
//        	MinosUserService minosUserService = ClientUtil.getContext().getClient(MinosUserService.class);
//            minosUser = minosUserService.getMinosUserByToken(access_token);
//        } catch (MinosServiceException e) {
//            logger.error("security Check error : " + e.getMessage());
//            return new ResponseEntity<String>(e.getErrorCode(), e.getMessage(), "");
//        }
//        // 将对象存入request中
//        request.setAttribute(WebAPISecurityProtocol.MINOS_USER, minosUser);
//
//        if (!securityProtocol.checkSign(request)) {
//            MinosSystemException se = new MinosSystemException(WebAPIExceptions.ERR_BAD_REQUEST);
//            return new ResponseEntity<String>(se.getErrorCode(), se.getErrorMessage(), "");
//        }
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
