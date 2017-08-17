package com.sync.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sync.util.log.LogFactory;

@Controller

public class LoginController {
	private static Logger main = LogFactory.getLogger("main");
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request,String username,String password) {
		
		if("admin".equals(username) && "admin".equals(password)){
			return "redirect:/dianyuan/info.do";
		}else{
			return "login";
		}
	}
	
	
}
