package com.sync.job;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sync.service.interfaces.SyncEfastOrderServer;
import com.sync.service.interfaces.SyncOfflineVipOrderService;
import com.sync.util.Constant;
import com.sync.util.log.LogFactory;

@Service
public class SyncOrderTask {
	private static Logger error = LogFactory.getLogger("error");
	
	@Autowired
	private SyncEfastOrderServer syncEfastOrderServer;
	@Autowired
	private SyncOfflineVipOrderService syncOfflineVipOrderService;
	

	public void syncSpecialUserMethod() {
		try {
			Date current_time = new Date();
//			syncEfastOrderServer.syncEfastOrders(current_time);
			syncOfflineVipOrderService.syncOfflineVipOrders();
			
			Constant.lastSyncTime = current_time;
		} catch (Exception e) {
			error.error(e.getMessage());
		}
	}
	
}
