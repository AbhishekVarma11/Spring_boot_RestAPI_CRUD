package com.springBoot.RestProject.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${text}")
	private String msg;
	//@RequestMapping(value="/",method=RequestMethod.GET)
	@GetMapping("/")
	public String HelloWorld()
	{
		return msg;
	}
	

}
