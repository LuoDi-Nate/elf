package com.fooluodi.elf.sms.common.http;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 
 * @author di
 * 该注解实际上就是一个@Component，因为在一个httpclient上标一个@Component不够直观，所以改了下注解名称
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface HttpUtil {

}
