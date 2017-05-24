package com.sync.efast.interfaces;

import java.util.List;

import com.sync.model.EfastOrder;

public interface EfastOrderService {
	
	
	void getEfastOrdersFromLastTimeByPage(int pageIndex,List<EfastOrder> efastOrderList);

}
