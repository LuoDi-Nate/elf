package com.fooluodi.elf.webapi.sms;

import com.fooluodi.elf.framework.ResponseEntity;
import com.fooluodi.elf.user.dto.ElfUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by di on 18/11/15.
 */
@Controller
@RequestMapping("/elf-webapi")
public class PhoneController {
    private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<?> updateUserInfo(ElfUserDto userDto) {
        logger.info("get current_user, user:{}", userDto);


        return ResponseEntity.success("");
    }
}
