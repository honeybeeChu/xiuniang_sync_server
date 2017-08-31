package com.sync.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.swetake.util.Qrcode;
import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.mapper.Points_ruleMapper;
import com.sync.mybatis.model.Membership;
import com.sync.util.spring.PropertyPlaceholder;
import com.sync.weixin.service.WeixinService;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;

@Controller
@RequestMapping(value = "/bonus_points")
public class BonusPointsController {
	
	@Autowired
	private MembershipMapper membershipMapper;
	@Autowired
	private Points_ruleMapper points_ruleMapper;
	
	@Autowired
	private WeixinService wxService;
	
	@RequestMapping(value = "/auth_url", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String auth_url(HttpServletRequest request, HttpServletResponse response) {
		String redirect_url = PropertyPlaceholder.getProperty("application_url").toString()+"bonus_points/init";
		return "redirect:"+wxService.oauth2buildAuthorizationUrl(redirect_url,WxConsts.OAUTH2_SCOPE_BASE, null);
	}
	
	@RequestMapping(value = "/init", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request, HttpServletResponse response,Model model) {
		try {
			wxService.oauth2buildAuthorizationUrl(null,WxConsts.OAUTH2_SCOPE_BASE, null);
			
			WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(request.getParameter("code").toString());
			String openId = wxMpOAuth2AccessToken.getOpenId();
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			Membership membership = membershipMapper.selectByOpenId(openId);
			if (membership != null) {
				model.addAttribute("membershipList", membership);
			} else {
				model.addAttribute("membershipList", new Membership());
			}
			return "bonus_points/bonus_points_info";
		} catch (Exception e) {
			return "bonus_points/bonus_points_info";
		}
	}

	@RequestMapping(value = "/toLookImage", method = RequestMethod.GET)
	public void lookImage(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam() String code) {
		int width = 140;
		int height = 140;
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M');
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(7);
		BufferedImage bufImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics2D gs = bufImg.createGraphics();
		gs.setBackground(Color.WHITE);
		gs.clearRect(0, 0, width, height);
		gs.setColor(Color.BLACK);
		try {
			byte[] contentBytes = code.getBytes("utf-8");
			int pixoff = 2;
			if (contentBytes.length > 0 && contentBytes.length < 120) {
				boolean[][] codeOut = qrcode.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			}
			gs.dispose();
			bufImg.flush();
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(bufImg, "png", outputStream);
			outputStream.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
