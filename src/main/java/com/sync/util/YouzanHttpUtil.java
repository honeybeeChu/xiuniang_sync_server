package com.sync.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class YouzanHttpUtil {
	
	public static String httpGet(String url){
		String line = null;
		StringBuffer result = new StringBuffer();
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response1 = httpclient.execute(httpGet);
			HttpEntity entity1 = response1.getEntity();
			InputStream inputStream = entity1.getContent();
			InputStreamReader isr = new InputStreamReader(inputStream, "UTF8");
			BufferedReader br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				result.append(line);
//				JSONObject jsonobj =  JSONObject.fromObject(line);
//				if(null != jsonobj.get("response")){
//					JSONObject isSuccess =  JSONObject.fromObject(jsonobj.get("response").toString());
//					if(null != isSuccess.get("is_success"))
//						result =  "true".equals(isSuccess.get("is_success").toString());
//				}
				
			}
			EntityUtils.consume(entity1);
			response1.close();
			return result.toString();
		} catch (Exception e) {
			return result.toString();
		}
	}
}
