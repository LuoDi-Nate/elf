package com.fooluodi.elf.webapi.user;

import com.fooluodi.elf.framework.ResponseEntity;
import com.fooluodi.elf.framework.WebAPIBaseController;
import com.fooluodi.elf.user.dto.ElfUserDto;
import com.fooluodi.elf.user.service.IUserAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by di on 17/11/15.
 */

@Controller
@RequestMapping("/elf-webapi")
public class UserController extends WebAPIBaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserAccountService userAccountService;

    @RequestMapping(value = "/current_user", method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity<ElfUserDto> getCurrentUser(ElfUserDto userDto) {
        logger.info("get current_user, user:{}", userDto);
        return ResponseEntity.success(userDto);
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<ElfUserDto> updateUserInfo(ElfUserDto userDto) {
        logger.info("get current_user, user:{}", userDto);

        ElfUserDto elfUserDto = userAccountService.updateUserProfile(userDto);

        return ResponseEntity.success(elfUserDto);
    }




}
