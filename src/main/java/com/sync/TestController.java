package com.sync;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sync.util.log.LogFactory;

@Controller
@RequestMapping("/testController")
public class TestController {
	
	private static Logger error = LogFactory.getLogger("error");
	private static Logger main = LogFactory.getLogger("main");
	
	   @RequestMapping(value="/getView")
	    @ResponseBody
	    public ModelAndView getTest(HttpServletRequest request){
		   main.info("fd==============================");
		   error.error("---------------------------");
	        ModelAndView modelAndView = new ModelAndView("test-jsp");
	        return modelAndView;
	    }
}
	