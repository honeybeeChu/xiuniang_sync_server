package com.sync.youzan.impl;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sync.util.YouzanHttpUtil;
import com.sync.util.log.LogFactory;
import com.sync.util.md5.MD5;
import com.sync.util.spring.PropertyPlaceholder;
import com.sync.youzan.interfaces.YouzanPointsService;

import net.sf.json.JSONObject;
@Service
public class YouzanPointsServiceImpl implements YouzanPointsService{
	
	private static Logger error = LogFactory.getLogger("error");
	
//	public static void main(String args[]){
//		System.out.println(importPointsByMobile1(100,"15150500169", "this is a test"));
//	}
	
//	@Override
//	public boolean importPointsByMobile(int points,String mobile, String reason) {
//		return true;
//	}
	
	@Override
	public boolean importPointsByMobile(int points,String mobile, String reason) {
		try {
//			String point_increase_url = PropertyPlaceholder.getProperty("youzan_increase_point_url").toString();
			String point_increase_url = "https://open.youzan.com/api/entry/youzan.crm.customer.points/3.0.0/increase?";
			
			String youzanPointIncreaceHttpUrl = getIncreasePointsConditionParamsStr(point_increase_url,points,mobile,reason,"youzan.crm.customer.points.increase");
			boolean result = false;
			String resultStr = YouzanHttpUtil.httpGet(youzanPointIncreaceHttpUrl);
			
			JSONObject jsonobj =  JSONObject.fromObject(resultStr);
			if(null != jsonobj.get("response")){
				JSONObject isSuccess =  JSONObject.fromObject(jsonobj.get("response").toString());
				if(null != isSuccess.get("is_success"))
					result =  "true".equals(isSuccess.get("is_success").toString());
			}
			return result;
		} catch (Exception e) {
			error.error(e.toString());
			error.error(e.getMessage());
			return false;
		}
	}
	
	
	@Override
	public boolean decreasePointsByMobile(int decreasePoints,String mobile,String reason){
		try {
			String point_increase_url = PropertyPlaceholder.getProperty("youzan_decrease_point_url").toString();
			String youzanPointIncreaceHttpUrl = getIncreasePointsConditionParamsStr(point_increase_url,decreasePoints,mobile,reason,"youzan.crm.customer.points.decrease");
			boolean result = false;
			String resultStr = YouzanHttpUtil.httpGet(youzanPointIncreaceHttpUrl);
			JSONObject jsonobj =  JSONObject.fromObject(resultStr);
			if(null != jsonobj.get("response")){
				JSONObject isSuccess =  JSONObject.fromObject(jsonobj.get("response").toString());
				if(null != isSuccess.get("is_success"))
					result =  "true".equals(isSuccess.get("is_success").toString());
			}
			return result;
		} catch (Exception e) {
			error.error(e.toString());
			error.error(e.getMessage());
			return false;
		}
	}
	
	
	private static String getIncreasePointsConditionParamsStr(String point_increase_url,int points, String mobile,String reason,String method) throws Exception{
//		String appid = PropertyPlaceholder.getProperty("youzan_appid").toString();
		String appid = "31fd6f63e6a4a9d527";
		
		//产生时间戳
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timestamp = sdf.format(new Date());
		
		StringBuffer paramBuf = new StringBuffer();
		paramBuf.append(point_increase_url)
		.append("app_id=")
		.append(appid)
		.append("&fans_type=1&format=json&method=")
		.append(method)
		.append("&mobile=").append(mobile)
		.append("&points=").append(points)
		.append("&sign_method=md5")
		.append("&reason=").append(URLEncoder.encode(reason, "UTF8"))
		.append("&sign=").append(getSign(points, mobile,reason,timestamp,method))
		.append("&timestamp=")
		.append(URLEncoder.encode(timestamp, "UTF-8"))
		//版本参数
		.append("&v=3.0");
		
		return paramBuf.toString();
		
	}
	
	
	
	
	
	/**
	 * @param points
	 * @param mobile
	 * @param reason
	 * @param timestamp
	 * @return
	 */
	private static String getSign(int points, String mobile,String reason,String timestamp,String method)  throws Exception{
		
//		String appid = PropertyPlaceholder.getProperty("youzan_appid").toString();
//		String secret = PropertyPlaceholder.getProperty("youzan_secret").toString();
		
		String appid = "31fd6f63e6a4a9d527";
		String secret = "3c1259fff6ac558929c01a2800613013";
		
		StringBuffer sign = new StringBuffer();
		sign.append(secret)
		.append("app_id")
		.append(appid)
		.append("fans_type1")
		.append("formatjson")
		.append("method")
		.append(method)
		.append("mobile")
		.append(mobile)
		.append("points")
		.append(points)
		
		.append("reason")
		.append(reason)
		.append("sign_methodmd5")
		
		.append("timestamp")
		.append(timestamp)
		//版本参数
		.append("v3.0")
		.append(secret);
		
		return MD5.sign(sign.toString());
	}

}
