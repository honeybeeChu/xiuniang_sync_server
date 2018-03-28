package com.sync.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sync.mybatis.mapper.DianyuanMapper;
import com.sync.mybatis.mapper.Efast_orderMapper;
import com.sync.mybatis.mapper.MembershipMapper;
import com.sync.mybatis.model.dto.CustomerIndexDTO;
import com.sync.mybatis.vo.EfastOrderConditionVO;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	@Autowired
	private MembershipMapper membershipMapper;

	@Autowired
	private DianyuanMapper dianyuanMapper;
	
	@Autowired
	private Efast_orderMapper efast_orderMapper;

	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(required = true, defaultValue = "1") Integer pageIndex, String nickname,
			String is_membership,String trade_amount_from,String trade_amount_to,
			String trade_number_from,String trade_number_to,
			String trade_date_from,String trade_date_to
			) {
		try {
			System.out.println(is_membership);
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			EfastOrderConditionVO conditionvo = new EfastOrderConditionVO();
			conditionvo.setBuyerName(StringUtils.isEmpty(nickname) ? null : nickname);
			conditionvo.setTrade_amount_from(StringUtils.isEmpty(trade_amount_from) ? null : trade_amount_from);
			conditionvo.setTrade_amount_to(StringUtils.isEmpty(trade_amount_to) ? null : trade_amount_to);
			conditionvo.setTrade_number_from(StringUtils.isEmpty(trade_number_from) ? null : trade_number_from);
			conditionvo.setTrade_number_to(StringUtils.isEmpty(trade_number_to) ? null : trade_number_to);
			conditionvo.setTrade_date_from(StringUtils.isEmpty(trade_date_from) ? null : trade_date_from);
			conditionvo.setTrade_date_to(StringUtils.isEmpty(trade_date_to) ? null : trade_date_to);
			
			
			PageHelper.startPage(pageIndex, 20);
			List<CustomerIndexDTO> customerInfoList = efast_orderMapper.selectCustomerIndex(conditionvo);
			
			PageInfo<CustomerIndexDTO> page = new PageInfo<CustomerIndexDTO>(customerInfoList);
			model.addAttribute("page", page);
			model.addAttribute("customerInfoList", customerInfoList);
			
			model.addAttribute("nickname", nickname);
			model.addAttribute("is_membership", is_membership);
			model.addAttribute("trade_amount_from", trade_amount_from);	
			model.addAttribute("trade_amount_to", trade_amount_to);	
			model.addAttribute("trade_number_from", trade_number_from);	
			model.addAttribute("trade_number_to", trade_number_to);	
			model.addAttribute("trade_date_from", trade_date_from);	
			model.addAttribute("trade_date_to", trade_date_to);	
			
			return "customer/customer_index";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return "customer/customer_index";
		}
	}
	
	
	
	
	
	
	@RequestMapping(value = "/analyse", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String analyse(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(required = true, defaultValue = "1") Integer pageIndex, String dymc) {
		return "customer/analyse";
	}
	
	
	
	
	
	
	
	
	

}
