package com.sync.controller;

import java.text.SimpleDateFormat;
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
import com.sync.mybatis.model.Efast_order;
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
			@RequestParam(required = true, defaultValue = "1") Integer pageIndex, EfastOrderConditionVO conditionvo
			) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			if(StringUtils.isNotEmpty(conditionvo.getTrade_date_from())  &&StringUtils.isNotEmpty(conditionvo.getTrade_date_to())) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				if(sdf.parse(conditionvo.getTrade_date_from()).compareTo(sdf.parse(conditionvo.getTrade_date_to())) >= 0) {
					model.addAttribute("errorMsg", "查询开始日期不能大于结束日期");
					return "customer/customer_index";
				}
			}
			PageHelper.startPage(pageIndex, 20);
			List<CustomerIndexDTO> customerInfoList = efast_orderMapper.selectCustomerIndex(conditionvo);
			
			model.addAttribute("conditionvo",conditionvo);
			PageInfo<CustomerIndexDTO> page = new PageInfo<CustomerIndexDTO>(customerInfoList);
			model.addAttribute("page", page);
			model.addAttribute("customerInfoList", customerInfoList);
			
			return "customer/customer_index";
		} catch (Exception e) {
			return "customer/customer_index";
		}
	}
	
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String detail(HttpServletRequest request, HttpServletResponse response, Model model,String nickname) {
		
		EfastOrderConditionVO conditionvo = new EfastOrderConditionVO();
		conditionvo.setBuyerName(nickname);
		 List<CustomerIndexDTO> dtolist = efast_orderMapper.selectCustomerIndex(conditionvo);
		 if(null != dtolist && dtolist.size() == 1) {
			 model.addAttribute("customer_info", dtolist.get(0));
		 }
		 return "customer/customer_detail";
	}
	
	
	@RequestMapping(value = "/customer_orderList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String orderList(HttpServletRequest request, HttpServletResponse response, Model model,String nickname) {
		 List<Efast_order> orderlist = efast_orderMapper.selectByBuyerName(nickname);
		 if(null != orderlist) {
			 model.addAttribute("orderlist", orderlist);
		 }
		 
		 return "customer/customer_order_list";
		 
	}
	
	@RequestMapping(value = "/offline_index", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String offline_index(HttpServletRequest request, HttpServletResponse response, Model model,String phone) {
		 List<Efast_order> orderlist = efast_orderMapper.selectByBuyerName(phone);
		 if(null != orderlist) {
			 model.addAttribute("orderlist", orderlist);
		 }
		 
		 return "customer/offline_index";
		 
	}
	
}
