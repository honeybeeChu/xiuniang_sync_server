package com.sync.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			return "redirect:/dianyuan/info.do";
		}else{
			return "login";
		}
	}
	
	
}
