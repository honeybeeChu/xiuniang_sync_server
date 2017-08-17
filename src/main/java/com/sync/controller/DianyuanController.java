package com.sync.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sync.mybatis.mapper.DianyuanMapper;
import com.sync.mybatis.model.Dianyuan;
import com.sync.util.YouzanHttpUtil;
import com.sync.util.log.LogFactory;
import com.sync.util.spring.PropertyPlaceholder;
import com.sync.weixin.service.WeixinService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/dianyuan")
public class DianyuanController {
	private static Logger main = LogFactory.getLogger("main");
	
	@Autowired
	private DianyuanMapper dianyuanMapper;
	@Autowired
	private WeixinService weixinService;
	
	@RequestMapping(value = "/info",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model,
			@RequestParam(required=true,defaultValue="1") Integer pageIndex,String dymc) {
		try{
			request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            
			PageHelper.startPage(pageIndex, 10);
			List<Dianyuan> dianyuanList = null;
			if(null == dymc || "".equals(dymc.trim())){
				dianyuanList = dianyuanMapper.getAllDianyuan();
			}else{
				String dianyuan_name = new String(dymc.getBytes("iso8859-1"),"UTF-8");
				dianyuanList = dianyuanMapper.getDianYuanByName(dianyuan_name);
				model.addAttribute("searchDYMC", dianyuan_name);
			}
			 
			PageInfo<Dianyuan> page = new PageInfo<Dianyuan>(dianyuanList);
			model.addAttribute("page", page);
			model.addAttribute("dianyuanList", dianyuanList);
			
			return "dianyuan/dianyuan_info";
		}catch(Exception e){
			return "dianyuan/dianyuan_info";
		}
	}
	
	@RequestMapping(value = "/getQrcode",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
	public String  qrcode(HttpServletRequest request,HttpServletResponse response,String dydm) {
		try{
			String resultStr = weixinService.post("https://api.weixin.qq.com/card/qrcode/create", getQrcodeParamStr(dydm));
			JSONObject obj = JSONObject.fromObject(resultStr);
			return "redirect:"+obj.getString("show_qrcode_url");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "dianyuan/dianyuan_info";
	}
	
	
	@RequestMapping(value = "/sync_dianyuans")
	@ResponseBody
	public String sync_dianyuans(HttpServletRequest request) {
		try{
			String dianyuan_url = PropertyPlaceholder.getProperty("dianyuan_url");
			String dianyuans =YouzanHttpUtil.httpGet(dianyuan_url);
			JSONArray jsonArray = JSONArray.fromObject(dianyuans);
			
			for (int i = 0; i < jsonArray.size(); i++) {
			    JSONObject obj = (JSONObject) jsonArray.get(i);
			    List<Dianyuan> dianyuanList = dianyuanMapper.getDianyuanByDYDM(obj.get("DYDM").toString());
			    Dianyuan dianyuan = getDianyuan(obj);
			    if(null != dianyuanList && dianyuanList.size() > 0){
			    	Dianyuan original_dianyuan = dianyuanList.get(0);
			    	if(original_dianyuan.getIsout()==null && dianyuan.getIsout() != null){
			    		original_dianyuan.setIsout(dianyuan.getIsout());
			    		dianyuanMapper.updateByPrimaryKeySelective(original_dianyuan);
			    	}
			    }else{
			    	dianyuanMapper.insertSelective(dianyuan);
			    }
			}
			return "success";
		}catch(Exception e){
			System.out.println(e.toString());
			return "false";
		}
		
	}
	
	
	//店员观察
	@RequestMapping(value = "/discovery")
	public String discovery(HttpServletRequest request,Model model) {
		
		List<Map<String, Object>> khdm_map = dianyuanMapper.getCountByKHDM();
		System.out.println(khdm_map.size());
		
		for(Map<String, Object> item :khdm_map ){
			System.out.println(item.get("count"));
		}
		
		
		
		model.addAttribute("dianyuanList", "dianyuanList");
		return "dianyuan/dianyuan_discovery";
	}
	
	
	
	
	
	
	
	private String getQrcodeParamStr(String dydm){
		//获取会员卡的id
		String card_id = PropertyPlaceholder.getProperty("wx_membership_card_id");
		
		JSONObject paramsObj = new JSONObject();
		paramsObj.put("action_name", "QR_CARD");
		
		JSONObject action_infoObj = new JSONObject();
		
		JSONObject cardObj = new JSONObject();
		cardObj.put("card_id", card_id);
		cardObj.put("is_unique_code", true);
		cardObj.put("outer_str", dydm);
		cardObj.put("outer_id", dydm);
		action_infoObj.put("card", cardObj);
		paramsObj.put("action_info", action_infoObj);
		
		
		System.out.println(paramsObj.toString());
		return paramsObj.toString();
		
		
//		StringBuffer parambf = new StringBuffer();
//		parambf.append("{action_name:QR_CARD,action_info:{card:{card_id:")
//		.append(card_id)
//		.append(",is_unique_code:true,outer_str:")
//		.append(dydm)
//		.append(",outer_id:")
//		.append(dydm)
//		.append("}}}");
//		
//		System.out.println(parambf.toString());
//		return parambf.toString();
	}
	
	
	
	public static void main(String args[]){
		
		
//		System.out.println(getQrcodeParamStr("dydm"));
	}
	
	
	private Dianyuan getDianyuan(JSONObject obj){
		Dianyuan dianyuan = new Dianyuan();
		
		if(!"null".equals(obj.getString("ADDRESS"))){
			dianyuan.setAddress(obj.getString("ADDRESS"));
		}
		
//		dianyuan.setBirthday(obj.getString("BIRTHDAY"));
		
		if(!"null".equals(obj.getString("BYZD1"))){
			dianyuan.setByzd1(obj.getString("BYZD1"));
		}
		if(!"null".equals(obj.getString("BYZD2"))){
			dianyuan.setByzd2(obj.getString("BYZD2"));
		}
		if(!"null".equals(obj.getString("BYZD3"))){
			dianyuan.setByzd3(obj.getString("BYZD3"));
		}
		if(!"null".equals(obj.getString("BYZD4"))){
			dianyuan.setByzd4(obj.getString("BYZD4"));
		}
		
		if(!"null".equals(obj.getString("BYZD5"))){
			dianyuan.setByzd5(obj.getString("BYZD5"));
		}
		if(!"null".equals(obj.getString("BYZD6"))){
			dianyuan.setByzd6(obj.getString("BYZD6"));
		}
		if(!"null".equals(obj.getString("BYZD7"))){
			dianyuan.setByzd7(obj.getString("BYZD7"));
		}
		if(!"null".equals(obj.getString("BYZD8"))){
			dianyuan.setByzd8(obj.getString("BYZD8"));
		}
		if(!"null".equals(obj.getString("BYZD9"))){
			dianyuan.setByzd9(obj.getString("BYZD9"));
		}
		if(!"null".equals(obj.getString("BZ"))){
			dianyuan.setBz(obj.getString("BZ"));
		}
		if(!"null".equals(obj.getString("DYDM"))){
			dianyuan.setDydm(obj.getString("DYDM"));
		}
		if(!"null".equals(obj.getString("DYMC"))){
			dianyuan.setDymc(obj.getString("DYMC"));
		}
		if(!"null".equals(obj.getString("DYXB"))){
			dianyuan.setDyxb(obj.getString("DYXB"));
		}
		if(!"null".equals(obj.getString("EDUCATION"))){
			dianyuan.setEducation(obj.getString("EDUCATION"));
		}
		
		
		if(!"null".equals(obj.getString("EMAIL"))){
			dianyuan.setEmail(obj.getString("EMAIL"));
		}
		
		
//		dianyuan.setGwddrq(obj.getString("GWDDRQ"));
//		dianyuan.setGwddrq(obj.getString("IDENTNO"));
		
		if(!"null".equals(obj.getString("OUT"))){
			dianyuan.setIsout(obj.getString("OUT"));
		}
		
		
		if(!"null".equals(obj.getString("KHDM"))){
			dianyuan.setKhdm(obj.getString("KHDM"));
		}
		
		if(!"null".equals(obj.getString("KWDM"))){
			dianyuan.setKwdm(obj.getString("KWDM"));
		}
		if(!"null".equals(obj.getString("MOBILE"))){
			dianyuan.setMobile(obj.getString("MOBILE"));
		}
		
		if(!"null".equals(obj.getString("ORIGIN"))){
			dianyuan.setOrigin(obj.getString("ORIGIN"));
		}
		
		if(!"null".equals(obj.getString("PHONE"))){
			dianyuan.setPhone(obj.getString("PHONE"));
		}
		
		if(!"null".equals(obj.getString("QDBZ"))){
			dianyuan.setQdbz(obj.getString("QDBZ"));
		}
		if(!"null".equals(obj.getString("QDDM"))){
			dianyuan.setQddm(obj.getString("QDDM"));
		}
		if(!"null".equals(obj.getString("QMM"))){
			dianyuan.setQmm(obj.getString("QMM"));
		}
		if(!"null".equals(obj.getString("XZDM"))){
			dianyuan.setXzdm(obj.getString("XZDM"));
		}
		if(!"null".equals(obj.getString("ZDZK"))){
			dianyuan.setZdzk(obj.getString("ZDZK"));
		}
		if(!"null".equals(obj.getString("ZJF"))){
			dianyuan.setZjf(obj.getString("ZJF"));
		}
		return dianyuan;
	}
	
	
}
