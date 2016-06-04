package com.fooluodi.elf.webapi;

import com.fooluodi.elf.framework.ResponseEntity;
import com.fooluodi.elf.user.dto.ElfUserInnerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * PingController
 * \ * @author di
 *
 * @date 15/7/23
 */
@Controller
@RequestMapping("/elf-webapi")
public class PingController {
    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> ping(HttpServletResponse response) throws IOException {
        logger.info("ping");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            stringBuilder.append(UUID.randomUUID().toString() + "\n");
        }

        //设置返回类型
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=" + "a.txt");

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(stringBuilder.toString().getBytes());

        return ResponseEntity.success("hi!");
    }

    @RequestMapping(value = "/user_test", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> testGetUserByToken(ElfUserInnerDto user) {
        logger.info("test get user by token, user:{}", user);

        return ResponseEntity.success(user);
    }
}
