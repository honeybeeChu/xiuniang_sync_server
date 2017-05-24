package com.sync.job;

import org.apache.log4j.Logger;

import com.sync.service.interfaces.SyncEfastOrderServer;
import com.sync.util.log.LogFactory;

public class SyncOrderTask {
	private static Logger error = LogFactory.getLogger("error");

	private SyncEfastOrderServer syncEfastOrderServer;

	public void syncSpecialUserMethod() {
		try {
			syncEfastOrderServer.syncEfastOrders();
		} catch (Exception e) {
			error.error(e.getMessage());
		}
	}

	public SyncEfastOrderServer getSyncEfastOrderServer() {
		return syncEfastOrderServer;
	}

	public void setSyncEfastOrderServer(SyncEfastOrderServer syncEfastOrderServer) {
		this.syncEfastOrderServer = syncEfastOrderServer;
	}

	
}
