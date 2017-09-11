package com.sync.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sync.util.log.LogFactory;
import com.sync.util.spring.PropertyPlaceholder;

/**
 * @author chuliang
 *
 */
public class SyncnoFileOperate {
	
	private static Logger error = LogFactory.getLogger("error");

	 private static String filePath =
	 SyncnoFileOperate.class.getClassLoader().getResource("lastSyncTime.txt").getFile();
//	private static String filePath = "D:/workspace/xiuniang_sync_server/src/main/resources/lastSyncTime.txt";

	/**
	 * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
	 * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
	 * 
	 * @param filePath
	 *  读取lastSyncTime上次同步的最后一个序列号的值
	 */
	public static Date getLastSyncOrderTime() {
		Date lastTime = null;
		try {
			String encoding = "UTF-8";
			File file = new File(filePath);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					return sdf.parse(lineTxt);
				}
				read.close();
			} else {
				error.error("can not find the synctxt file");
			}
		} catch (Exception e) {
			error.error("something is wrong when reading the synctxt file");
			error.error(e.toString());
		}
		return lastTime;

	}

	public static void setLastSyncOrderTime() {
		try {
			FileWriter fileWritter = new FileWriter(filePath, false);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(Constant.getlastSyncTimeAsStr());
			bufferWritter.close();
		} catch (IOException e) {
			error.error("there is exception when setLastSyncOrderTime");
			error.error(e.toString());
		}
		
	}

	public static void main(String args[]) {
		Constant.lastSyncTime = new Date();
//		setLastSyncOrderTime();
//		System.out.println(getLastSyncOrderTime());
		System.out.println(PropertyPlaceholder.getProperty("efast_url").toString());

	}

}
