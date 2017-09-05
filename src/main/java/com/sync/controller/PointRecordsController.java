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
import com.sync.mybatis.mapper.Points_recordMapper;
import com.sync.mybatis.model.Points_record;

@Controller
@RequestMapping(value = "/point_records")
public class PointRecordsController {
	
	@Autowired
	private Points_recordMapper pointsRecordMapper;
	
	@RequestMapping(value = "/init",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam(required=true,defaultValue="1") Integer pageIndex,String dymc) {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			PageHelper.startPage(pageIndex, 10);
			List<Points_record>  pointsRecordList = null;
			if (null == dymc || "".equals(dymc.trim())) {
				pointsRecordList = pointsRecordMapper.selectAllPointsRecord();
			} else {
				pointsRecordList = pointsRecordMapper.selectByMobile(dymc);
				model.addAttribute("searchDYMC", dymc);
			}

			PageInfo<Points_record> page = new PageInfo<Points_record>(pointsRecordList);
			model.addAttribute("page", page);
			model.addAttribute("pointsRecordList", pointsRecordList);

			return "point_records/point_records_info";
		} catch (Exception e) {
			return "point_records/point_records_info";
		}
	}
}
