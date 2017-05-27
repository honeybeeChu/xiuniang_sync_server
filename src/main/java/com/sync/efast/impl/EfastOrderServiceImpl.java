package com.sync.efast.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.sync.efast.interfaces.EfastOrderService;
import com.sync.model.EfastOrder;
import com.sync.util.Constant;
import com.sync.util.DateUtils;
import com.sync.util.log.LogFactory;
import com.sync.util.md5.MD5;
import com.sync.util.spring.PropertyPlaceholder;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EfastOrderServiceImpl implements EfastOrderService {

	private static Logger error = LogFactory.getLogger("error");
	
	public static void main(String args[]) {
		try {
			Constant.lastSyncTime = DateUtils.getOneHoursAgoTime();
			System.out.println(Constant.getlastSyncTimeAsStr());
//			syncEfastOrdersT(1);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	/**
	 * @param pageIndex
	 */
	public void getEfastOrdersFromLastTimeByPage(int pageIndex,Date currentDate,List<EfastOrder> efastOrderList) {
		try {
			
			System.out.println("pageIndex :" + pageIndex);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String efastHttpUrl = getConditionParamsStr(pageIndex, sdf.format(currentDate));
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(efastHttpUrl);
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			HttpEntity entity1 = response1.getEntity();
			InputStream inputStream = entity1.getContent();
			InputStreamReader isr = new InputStreamReader(inputStream, "UTF8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				JSONObject jsonobj =  JSONObject.fromObject(line);
				if("1".equals(jsonobj.get("status").toString())){
					JSONObject  dataObj = JSONObject.fromObject(jsonobj.get("data").toString());
					JSONObject filterObj = JSONObject.fromObject(dataObj.get("filter").toString());
					JSONArray orderArray = JSONArray.fromObject(dataObj.get("data").toString());
					for(int i=0;i<orderArray.size();i++){
						JSONObject jsonObject=JSONObject.fromObject(orderArray.get(i));
						efastOrderList.add(new EfastOrder(jsonObject).createEfastOrder());
					}
					//是最后一页了
					if(pageIndex == Integer.parseInt(filterObj.get("page_count").toString())){
						Constant.lastSyncTime = currentDate;
					}
					//非最后一页
					else{
						getEfastOrdersFromLastTimeByPage(++pageIndex,currentDate,efastOrderList);
					}
				}
			}
			EntityUtils.consume(entity1);
			response1.close();
		} catch (Exception e) {
			e.printStackTrace();
			error.error(e.toString());
			error.error(e.getMessage());
		}
	}
	
	
	
	
	/**
	 * @param sign
	 * @param timestamp
	 *            查询条件，订单状态是已确认+shipping_status=4（已发货）+ 更新时间为最近30分钟以内
	 * @return
	 */
	private static String getConditionParamsStr(int pageIndex, String timestamp)  throws Exception{
		StringBuffer paramBuf = new StringBuffer();
//		String efast_url = "http://openapi.baotayun.com/openapi/webefast/web/?app_act=openapi/router";

		String efast_url = PropertyPlaceholder.getProperty("efast_url").toString();
		paramBuf.append(efast_url).append("&format=json&key=")
//				.append("f2889c8118cada8a52965d087da5d088")
				 .append(PropertyPlaceholder.getProperty("efast_key").toString())
				// 订单参数接口
				.append("&method=oms.order.search.get")
				//page参数，开始页设置
				.append("&page=").append(pageIndex)
				// .append("&page_size=").append("2")
				
				// 最后更新时间的开始范围是：Constant.lastSyncTime
				.append("&start_lastchanged=").append(URLEncoder.encode(Constant.getlastSyncTimeAsStr(), "UTF-8"))
				// 最后更新时间社则为现在
				.append("&end_lastchanged=").append(URLEncoder.encode(timestamp, "UTF-8"))
				// 已发货
				.append("&shipping_status=4")
				//sign参数
				.append("&sign=").append(getSign(pageIndex, timestamp))
				//sign_method加密方式
				.append("&sign_method=").append("md5")
				//order_status参数，订单状态为已确认
				.append("&order_status=").append("1")
				//timestamp参数
				.append("&timestamp=").append(URLEncoder.encode(timestamp, "UTF-8"))
				//版本参数
				.append("&v=2.0");
		return paramBuf.toString();
	}
	
	
	
	/**
	 * @param pageIndex
	 * @param timestamp
	 * @return
	 * @throws Exception
	 */
	private static String getSign(int pageIndex, String timestamp) throws Exception {
		StringBuffer signBuf = new StringBuffer();
		 signBuf.append(PropertyPlaceholder.getProperty("efast_secret").toString())
//		signBuf.append("1feb581b4302688911584998fd8e66d9")
		 		.append("end_lastchanged").append(timestamp)
				.append("formatjsonkeyf2889c8118cada8a52965d087da5d088methodoms.order.search.get")
				.append("order_status1").append("page").append(pageIndex)
				.append("shipping_status4sign_methodmd5start_lastchanged").append(Constant.getlastSyncTimeAsStr())
				.append("timestamp").append(timestamp).append("v2.0")
//				.append("1feb581b4302688911584998fd8e66d9");
		 .append(PropertyPlaceholder.getProperty("efast_secret").toString());

		return MD5.sign(signBuf.toString()).toUpperCase();

	}
}
