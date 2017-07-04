package com.sync.offline.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.sync.model.OfflineVipOrder;
import com.sync.offline.interfaces.OfflineVipOrderService;
import com.sync.util.Constant;
import com.sync.util.DateUtils;

import net.sf.json.JSONArray;
@Service
public class OfflineVipOrderServiceImpl implements OfflineVipOrderService {

	public static void main(String args[]){
		getEfastOrdersFromLastTimeByPage();
	}
	
//	@Override
	public static void getEfastOrdersFromLastTimeByPage() {

		try {
			// String offline_url =
			// PropertyPlaceholder.getProperty("offline_url").toString();
			Constant.lastSyncTime = DateUtils.getOneHoursAgoTime();

			System.out.println(Constant.lastSyncTime);
			List<OfflineVipOrder> offlineOrderList = new ArrayList<OfflineVipOrder>();

			String offlineHttpUrl = "http://58.210.143.138:6081/xiuniang-server-0.0.1-SNAPSHOT/servlet/getviporderbytime?start_time="
					+ URLEncoder.encode("2017-06-30 16:01:00", "UTF-8");
			
			List<OfflineVipOrder> list = null;
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
				list = (List) JSONArray.toCollection(array, OfflineVipOrder.class);
				System.out.println(list.get(0).getTrade_date());
			}
			EntityUtils.consume(entity1);
			response1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
