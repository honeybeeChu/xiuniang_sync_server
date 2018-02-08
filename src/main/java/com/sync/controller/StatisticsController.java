package com.sync.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sync.mybatis.mapper.Wx_userMapper;
import com.sync.util.log.LogFactory;
import com.sync.weixin.service.WeixinService;

/**
 * 〈一句话功能简述〉<br>
 * 〈统计模块〉
 *
 * @author Max Chu
 *
 */
@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController {
	private static Logger main = LogFactory.getLogger("main");
	
	@Autowired
	private Wx_userMapper wx_userMapper;
	@Autowired
	private WeixinService weixinService;
	
	
	
	/**
	 * @param request
	 * @param response
	 * @param model
	 * @param pageIndex
	 * @param dymc
	 * @return
	 */
	@RequestMapping(value = "/rmf",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam(required=true,defaultValue="1") Integer pageIndex,String dymc) {
		return "statistics/rmf";
	}
	
	
	public static void main(String args[]){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String subtime = sdf.format(new Date(Long.parseLong("1421982538")*1000L));
		
		
	}
	
	
	
	
}
