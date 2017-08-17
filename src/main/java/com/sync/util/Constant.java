package com.sync.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chuliang
 * @description 存储全局变量
 *
 */
public class Constant {

	public static Date lastSyncTime = null;
	
	public static String getlastSyncTimeAsStr(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(Constant.lastSyncTime);
	}
	
}
