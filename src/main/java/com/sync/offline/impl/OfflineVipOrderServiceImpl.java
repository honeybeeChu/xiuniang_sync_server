package com.sync.offline.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.sync.mybatis.model.Offline_vip_order;
import com.sync.offline.interfaces.OfflineVipOrderService;
import com.sync.util.Constant;
import com.sync.util.log.LogFactory;

import net.sf.json.JSONArray;
@Service
public class OfflineVipOrderServiceImpl implements OfflineVipOrderService {
	
	private static Logger error = LogFactory.getLogger("error");
	private static Logger main = LogFactory.getLogger("main");

//	public static void main(String args[]){
//		getOfflineVipOrderFromLastTime();
//	}
	
	@Override
	public List<Offline_vip_order> getOfflineVipOrderFromLastTime() {

		try {
			// String offline_url =
			// PropertyPlaceholder.getProperty("offline_url").toString();
//			Constant.lastSyncTime = DateUtils.getOneHoursAgoTime();

//			String offlineHttpUrl = "http://58.210.143.138:6081/xiuniang-server-0.0.1-SNAPSHOT/servlet/getviporderbytime?start_time="
//					+ URLEncoder.encode("2017-07-06 14:01:00", "UTF-8");
			
			String offlineHttpUrl = "http://58.210.143.138:6081/xiuniang-server-0.0.1-SNAPSHOT/servlet/getviporderbytime?start_time="
					+ URLEncoder.encode(Constant.getlastSyncTimeAsStr(), "UTF-8");
			
			List<Offline_vip_order> list = null;
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(offlineHttpUrl);
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			HttpEntity entity1 = response1.getEntity();
			InputStream inputStream = entity1.getContent();
			InputStreamReader isr = new InputStreamReader(inputStream, "UTF8");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				JSONArray array = JSONArray.fromObject(line);
				list = (List) JSONArray.toCollection(array, Offline_vip_order.class);
				main.info(Constant.getlastSyncTimeAsStr() + "get OfflineVipOrder size " + list.size());
			}
			EntityUtils.consume(entity1);
			response1.close();
			
			return list;
		} catch (Exception e) {
			error.error("OfflineVipOrderServiceImpl Exception : " + e.toString());
			return null;
		}
	}

}
