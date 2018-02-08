package com.sync.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.StringUtil;
import com.sync.model.Wx_shop;
import com.sync.service.interfaces.WeNagativeService;
import com.sync.util.log.LogFactory;
import com.sync.util.log.LogObj;

/**
 * @ClassName: WechatManagerController
 * @Description: 公众号自动回复管理controller
 * @author chuliang@asiainfo-sec.com
 * @date 2017年6月22日 下午4:21:54
 *
 */
@Controller
@RequestMapping("/navigate")
public class NavigateController {
	private static Logger logger = LogFactory.getLogger("main");

	@Autowired
	private WeNagativeService weNagativeService;

	@RequestMapping("shopinfo")
	public String shopinfo(String account_id, String poi_id, String fromLongitude, String fromLatitude,
			String toLongitude, String toLatitude, Model model) {

		// 参数的日志打印
		LogObj logObj = new LogObj();
		logObj.putSysKey(LogObj.COLLECT, "y").putSysKey(LogObj.MODULE, "NavigateController.shopinfo")
				.putSysKey(LogObj.STEP, "request");
		logObj.putData("account_id", account_id);
		logObj.putData("poi_id", poi_id);
		logObj.putData("fromLongitude", fromLongitude);
		logObj.putData("fromLatitude", fromLatitude);
		logObj.putData("toLongitude", toLongitude);
		logObj.putData("toLatitude", toLatitude);
		logger.info(logObj);

		Wx_shop wx_shop = weNagativeService.getShopInfoByPoid(poi_id);
		model.addAttribute("fromLongitude", fromLongitude);
		model.addAttribute("fromLatitude", fromLatitude);
		model.addAttribute("toLongitude", toLongitude);
		model.addAttribute("toLatitude", toLatitude);
		model.addAttribute("account_id", account_id);
		model.addAttribute("wx_shop", wx_shop);

		return "navigate/index_shop";
	}

	@RequestMapping(value = "shopnavigate")
	public String shopnavigate(String poi_id, String fromLongitude, String fromLatitude, String toLongitude,
			String toLatitude, String shopid, Model model) {

		// 参数的日志打印
		LogObj logObj = new LogObj();
		logObj.putSysKey(LogObj.COLLECT, "y").putSysKey(LogObj.MODULE, "NavigateController.shopnavigate")
				.putSysKey(LogObj.STEP, "request");
		logObj.putData("shopid", shopid);
		logObj.putData("fromLongitude", fromLongitude);
		logObj.putData("fromLatitude", fromLatitude);
		logObj.putData("toLongitude", toLongitude);
		logObj.putData("toLatitude", toLatitude);
		logger.info(logObj);

		Wx_shop shop = weNagativeService.getShopInfoByShopId(Integer.parseInt(shopid));
		model.addAttribute("fromLongitude", fromLongitude);
		model.addAttribute("fromLatitude", fromLatitude);
		model.addAttribute("toLongitude", toLongitude);
		model.addAttribute("toLatitude", toLatitude);
		model.addAttribute("shopname",
				StringUtil.isEmpty(shop.getBranchName()) ? shop.getBusinessName() : shop.getBranchName());
		return "navigate/navigate_shop";
	}

	@RequestMapping(value = "sync_shops")
	public String sync_shops(String account_id) {
		// 参数的日志打印
		LogObj logObj = new LogObj();
		logObj.putSysKey(LogObj.COLLECT, "y").putSysKey(LogObj.MODULE, "NavigateController.sync_shops")
				.putSysKey(LogObj.STEP, "ajax");
		logObj.putData("account_id", account_id);
		logger.info(logObj);

		JSONObject node = new JSONObject();
		if (weNagativeService.syncWeShops()) {
			node.put("resultFlag", "ok");
		} else {
			node.put("resultFlag", "false");
		}
//		return node.toJSONString();
		
		return "navigate/sync_result";
	}

}
