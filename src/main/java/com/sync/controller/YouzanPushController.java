package com.sync.controller;
//import com.youzan.platform.util.security.MD5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sync.model.YouzanMsgPushEntity;
import com.sync.util.log.LogFactory;
import com.sync.util.md5.MD5;
import com.sync.util.spring.PropertyPlaceholder;

import net.sf.json.JSONObject;

@Controller
public class YouzanPushController {
	
	private static Logger main = LogFactory.getLogger("main");
	
	private final int mode = 1; // 服务商

	@RequestMapping(value = "/pointpush", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object test(@RequestBody YouzanMsgPushEntity entity) {
		 String clientId = PropertyPlaceholder.getProperty("youzan_appid").toString(); // 服务商的秘钥证书
		 String clientSecret = PropertyPlaceholder.getProperty("youzan_secret").toString();// 服务商的秘钥证书

		 
		 main.info("get in pointpush controller....");
		 main.info("isTest " + entity.isTest());
		JSONObject res = new JSONObject();
		res.put("code", 0);
		res.put("msg", "success");
		
		try {
			/**
			 * 判断是否为心跳检查消息 1.是则直接返回
			 */
			if (entity.isTest()) {
				return res;
			}

			/**
			 * 解析消息推送的模式 这步判断可以省略 0-商家自由消息推送 1-服务商消息推送 以服务商 举例 判断是否为服务商类型的消息
			 * 否则直接返回
			 */
			if (entity.getMode() != mode) {
				return res;
			}

			/**
			 * 判断消息是否合法 解析sign MD5 工具类开发者可以自行引入
			 */
			String sign;

			sign = MD5.sign(clientId + entity.getMsg() + clientSecret);
			if (!sign.equals(entity.getSign())) {
				return res;
			}

			/**
			 * 对于msg 先进行URI解码
			 */
			String msg = "";
			try {
				msg = URLDecoder.decode(entity.getMsg(), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			/**
			 * .......... 接下来是一些业务处理 判断当前消息的类型 比如交易
			 *
			 */
			if ("TRADE".equals(entity.getType())) {
				// TODO: 参考文档对应的交易对象 进行JSON解码 业务处理等

			}

			/**
			 * 返回结果
			 */
			return res;
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}

}
