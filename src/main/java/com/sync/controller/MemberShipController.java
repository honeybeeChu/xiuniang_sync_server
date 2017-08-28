package com.sync.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sync.mybatis.mapper.DianyuanMapper;
import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.model.Dianyuan;
import com.sync.mybatis.model.Membership;
import com.sync.mybatis.model.MembershipEx;

@Controller
@RequestMapping(value = "/member_ship")
public class MemberShipController {
	@Autowired
	private MembershipMapper membershipMapper;

	@Autowired
	private DianyuanMapper dianyuanMapper;

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
				membershipList = membershipMapper.selectByName(dymc);
				model.addAttribute("searchDYMC", dymc);
			}

			List<MembershipEx> membershipExList = new ArrayList<MembershipEx>();
			if (membershipList != null && membershipList.size() > 0) {
				for (Membership membership : membershipList) {
					MembershipEx membershipEx = new MembershipEx();
					membershipExList.add(membershipEx);
					membershipEx.setName(membership.getName());
					membershipEx.setBonus(membership.getBonus() == null ? 0 : membership.getBonus());
					membershipEx.setTotalConsumption(
							membership.getTotalConsumption() == null ? 0 : membership.getTotalConsumption());
					membershipEx.setPhone(membership.getPhone());

					List<Dianyuan> list = dianyuanMapper.getDianyuanByDianyuanid(membership.getDianyuanId());
					if (list != null && list.size() > 0) {
						membershipEx.setDymc(list.get(0).getDymc());
					}
				}
			}
			PageInfo<Membership> page = new PageInfo<Membership>(membershipList);
			model.addAttribute("membershipList", membershipExList);
			model.addAttribute("page", page);
			return "membership/membership_info";
		} catch (Exception e) {
			return "membership/membership_info";
		}
	}
}
