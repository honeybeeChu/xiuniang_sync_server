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
import com.sync.mybatis.mapper.Points_ruleMapper;
import com.sync.mybatis.model.Points_rule;

@Controller
@RequestMapping(value = "/point_rules")
public class PointRulesController {
	
	@Autowired
	private Points_ruleMapper pointsRuleMapper;
	
	@RequestMapping(value = "/init",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam(required=true,defaultValue="1") Integer pageIndex,String dymc) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			PageHelper.startPage(pageIndex, 10);
			List<Points_rule>  pointsRuleList = null;
			if (null == dymc || "".equals(dymc.trim())) {
				pointsRuleList = pointsRuleMapper.selectAllRules();
			} else {
				Integer level;
				try {
					level = Integer.parseInt(dymc);
				} catch (Exception e) {
					level = null;
				}
				pointsRuleList = pointsRuleMapper.selectPointsRuleByLevel(level);
				model.addAttribute("searchDYMC", dymc);
			}

			PageInfo<Points_rule> page = new PageInfo<Points_rule>(pointsRuleList);
			model.addAttribute("page", page);
			model.addAttribute("pointsRuleList", pointsRuleList);

			return "point_rules/point_rules_info";
		} catch (Exception e) {
			return "point_rules/point_rules_info";
		}
	}
	
	@RequestMapping(value = "/editInit",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String editInit(HttpServletRequest request,HttpServletResponse response,Model model, String id) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			Points_rule pointsRule = pointsRuleMapper.selectByPrimaryKey(Integer.parseInt(id));
			model.addAttribute("pointsRule", pointsRule);
			return "point_rules/point_rules_edit";
		} catch (Exception e) {
			return "point_rules/point_rules_edit";
		}
	}
	
	@RequestMapping(value = "/edit",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String edit(HttpServletRequest request,HttpServletResponse response,Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String rate = request.getParameter("rate");
			String discount = request.getParameter("discount");
			String onceConsumption = request.getParameter("onceConsumption");
			String consumption = request.getParameter("consumption");
			String tradeNum = request.getParameter("tradeNum");
			String conditions = request.getParameter("conditions");
			
			Points_rule rule = new Points_rule();
			rule.setId(Integer.parseInt(id));
			rule.setName(name);
			rule.setRate(Float.valueOf(rate));
			rule.setDiscount(Float.parseFloat(discount));
			rule.setOnceConsumption(Integer.parseInt(onceConsumption));
			rule.setTradeNum(Integer.parseInt(tradeNum));
			rule.setConditions(Integer.parseInt(conditions));
			rule.setConsumption(Integer.parseInt(consumption));
			pointsRuleMapper.updateByPrimaryKeyEx(rule);
			return "point_rules/success";
		} catch (Exception e) {
			return "redirect:/point_rules/init.do";
		}
	}
}
