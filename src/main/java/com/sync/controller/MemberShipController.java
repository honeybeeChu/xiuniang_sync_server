package com.sync.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.model.Membership;

@Controller
@RequestMapping(value = "/member_ship")
public class MemberShipController {
	@Autowired
	private MembershipMapper membershipMapper;

	@RequestMapping(value = "/init", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(required = true, defaultValue = "1") Integer pageIndex, String dymc) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PageHelper.startPage(pageIndex, 10);
			List<Membership> membershipList = null;
			if (null == dymc || "".equals(dymc.trim())) {
				membershipList = membershipMapper.selectAllMemberships();
			} else {
				String name = new String(dymc.getBytes("iso8859-1"), "UTF-8");
				membershipList = membershipMapper.selectByName(name);
				model.addAttribute("searchDYMC", name);
			}
			PageInfo<Membership> page = new PageInfo<Membership>(membershipList);
			model.addAttribute("membershipList", membershipList);
			model.addAttribute("page", page);
			return "membership/membership_info";
		} catch (Exception e) {
			return "membership/membership_info";
		}
	}
}
