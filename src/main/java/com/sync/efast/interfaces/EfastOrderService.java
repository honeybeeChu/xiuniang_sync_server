package com.sync.efast.interfaces;

import java.util.Date;
import java.util.List;

import com.sync.mybatis.model.Efast_order;

public interface EfastOrderService {
	
	void getEfastOrdersFromLastTimeByPage(int pageIndex,Date currentDate,List<Efast_order> efastOrderList);
	
	void getEfastOrdersFromTimeToTime(int pageIndex, String startTime, String endTime,
			List<Efast_order> efastOrderList);
	
	
}
