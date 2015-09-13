package me.ele.minos.webapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.ele.minos.framework.ResponseEntity;

/**
 * PingController
 *
 * @author di
 * @date 2015年09月12日02:23:32
 */
@Controller
@RequestMapping("/elf-webapi")
public class PingController {
	private static final Logger logger = LoggerFactory.getLogger(PingController.class);

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity<?> ping(){
		logger.debug("ping");
		return ResponseEntity.success("hi, diwa!");
	}
}
