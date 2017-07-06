package com.sync.offline.interfaces;

import java.util.List;

import com.sync.mybatis.model.Offline_vip_order;

public interface OfflineVipOrderService {
	List<Offline_vip_order> getOfflineVipOrderFromLastTime();
}
