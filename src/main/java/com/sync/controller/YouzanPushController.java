package com.sync.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sync.model.YouzanMsgPushEntity;
import com.sync.mybatis.mapper.Points_recordMapper;
import com.sync.mybatis.model.Points_record;
import com.sync.util.log.LogFactory;
import com.sync.util.md5.MD5;
import com.sync.util.spring.PropertyPlaceholder;

import net.sf.json.JSONObject;

@Controller
public class YouzanPushController {
	
	private static Logger main = LogFactory.getLogger("main");
	private static Logger error = LogFactory.getLogger("error");
	
	@Autowired
	private Points_recordMapper points_recordMapper;
	
	private final int mode = 1; // 服务商

	@RequestMapping(value = "/pointpush", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	public Object test(@RequestBody YouzanMsgPushEntity entity) {
		 String clientId = PropertyPlaceholder.getProperty("youzan_appid").toString(); // 服务商的秘钥证书
		 String clientSecret = PropertyPlaceholder.getProperty("youzan_secret").toString();// 服务商的秘钥证书
		 
		 main.info("get in pointpush controller....");
		 main.info("isTest " + entity.isTest());
		 main.info("entity " + entity);
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
			 main.info("mode " + entity.getMode());
			 main.info("type " + entity.getType());
			 main.info("client_id " + entity.getClient_id());
			 main.info("getKdt_name " + entity.getKdt_name());

			/**
			 * 判断消息是否合法 解析sign MD5 工具类开发者可以自行引入
			 */
			String sign;

			sign = MD5.sign(clientId + entity.getMsg() + clientSecret);
			if (!sign.equals(entity.getSign())) {
				main.info("!sign.equals(entity.getSign()");
				return res;
			}

			/**
			 * 对于msg 先进行URI解码
			 */
			String msg = "";
			JSONObject json_msg = null;
			try {
				msg = URLDecoder.decode(entity.getMsg(), "utf-8");
				json_msg = JSONObject.fromObject(msg);
				
				main.info("对于msg 先进行URI解码后为：" + msg);
			} catch (UnsupportedEncodingException e) {
				error.error("对于msg 先进行URI解码 ,报错："+e.toString());
			}

			/**
			 * .......... 积分表更记录
			 *
			 */
			if ("POINTS".equals(entity.getType())) {
				Points_record record = new Points_record();
				record.setAmount(Integer.parseInt(json_msg.get("amount").toString()));
				record.setTotal(Integer.parseInt(json_msg.get("total").toString()));
				record.setMobile(json_msg.get("mobile").toString());
				record.setFansId(Integer.parseInt(json_msg.get("fans_id").toString()));
				record.setDescription(json_msg.get("description").toString());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				record.setCreatedTime(format.parse(json_msg.get("created_time").toString()));
				
				points_recordMapper.insertSelective(record);
			}
			
			/**
			 * 返回结果
			 */
			main.info("返回结果 ：" + res);
			return res;
		} catch (NoSuchAlgorithmException e1) {
			error.error("NoSuchAlgorithmException e1,报错："+e1.toString());
		} catch (Exception e1) {
			error.error("Exception e1,报错："+e1.toString());
		}
		return res;
	}

}
