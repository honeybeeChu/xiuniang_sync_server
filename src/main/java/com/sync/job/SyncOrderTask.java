package com.sync.job;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sync.service.interfaces.SyncEfastOrderServer;
import com.sync.service.interfaces.SyncOfflineVipOrderService;
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
			syncEfastOrderServer.syncEfastOrders();
			syncOfflineVipOrderService.syncOfflineVipOrders();
		} catch (Exception e) {
			error.error(e.getMessage());
		}
	}

//	public SyncEfastOrderServer getSyncEfastOrderServer() {
//		return syncEfastOrderServer;
//	}
//
//	public void setSyncEfastOrderServer(SyncEfastOrderServer syncEfastOrderServer) {
//		this.syncEfastOrderServer = syncEfastOrderServer;
//	}

	
}
