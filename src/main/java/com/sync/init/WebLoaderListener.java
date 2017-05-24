package com.sync.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sync.util.Constant;
import com.sync.util.SyncnoFileOperate;


/**
 * @author chuliang
 * @description 系统初始化后，立即读入lastSyncTime
 *
 */
public class WebLoaderListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
		// 读取lastSyncTime上次同步的最后一个订单时间
		Constant.lastSyncTime = SyncnoFileOperate.getLastSyncOrderTime();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
