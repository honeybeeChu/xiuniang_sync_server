package com.sync.controller;

import java.net.URLEncoder;
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
import com.sync.mybatis.model.Wx_user;
import com.sync.util.log.LogFactory;
import com.sync.weixin.service.WeixinService;

import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;

@Controller
@RequestMapping(value = "/wxuser")
public class WxUserController {
	private static Logger main = LogFactory.getLogger("main");
	
	@Autowired
	private Wx_userMapper wx_userMapper;
	@Autowired
	private WeixinService weixinService;
	
	@RequestMapping(value = "/wxuserInfo",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam(required=true,defaultValue="1") Integer pageIndex,String dymc) {
		try{
			
			WxMpUserList wxMpUserList = weixinService.getUserService().userList(null);
			
			for(String openid:wxMpUserList.getOpenids()){
				
				Wx_user user = wx_userMapper.findByOpenId(openid);
				if(null == user) {
					WxMpUser wxMpUser = weixinService.getUserService().userInfo(openid);
					
					Wx_user wx_user = new Wx_user();
					wx_user.setCity(wxMpUser.getCity());
					wx_user.setCountry(wxMpUser.getCountry());
					wx_user.setGroupid(wxMpUser.getGroupId());;
					wx_user.setHeadimgurl(wxMpUser.getHeadImgUrl());
					wx_user.setIsMember(false);
					wx_user.setLanguage(wxMpUser.getLanguage());
					wx_user.setNickname(URLEncoder.encode(wxMpUser.getNickname(), "utf-8"));
					wx_user.setOpenid(wxMpUser.getOpenId());
//					wx_user.setPhone(null);
					wx_user.setProvince(wxMpUser.getProvince());
					wx_user.setRemark(wxMpUser.getRemark());
					wx_user.setSex("女".equals(wxMpUser.getSex()) ? 2 : 1);
					wx_user.setSubscribe(1);
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String subtime = sdf.format(new Date(wxMpUser.getSubscribeTime()*1000L));
					
					wx_user.setSubscribeTime(subtime);
					wx_user.setUnionid(wxMpUser.getUnionId());
					wx_userMapper.insertSelective(wx_user);
				}
			}
			
//			List<WxMpUser> list = weixinService.getUserService().userInfoList(wxMpUserList.getOpenids());
			
//			WxMpUserQuery userQuery = new WxMpUserQuery();
//			userQuery.add(wxMpUserList.getOpenids());
//			weixinService.getUserService().userInfoList(userQuery);
			
//			PageInfo<Dianyuan> page = new PageInfo<Dianyuan>(dianyuanList);
//			model.addAttribute("page", page);
//			model.addAttribute("dianyuanList", dianyuanList);
			
			return "wxuser/wxuser_info";
		}catch(Exception e){
			System.out.println(e.toString());
			main.error("Exception occured,"+e.toString());
			return null;
		}
	}
	
	
	
	@RequestMapping(value = "/distribution")
	public String distribution(HttpServletRequest request) {


		return "success";
	}
	
	
	
	
	
	public static void main(String args[]){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String subtime = sdf.format(new Date(Long.parseLong("1421982538")*1000L));
		
		
	}
	
	
	
	
}
