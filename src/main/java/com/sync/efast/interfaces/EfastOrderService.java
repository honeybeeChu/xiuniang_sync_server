package com.sync.efast.interfaces;

import java.util.Date;
import java.util.List;

import com.sync.model.EfastOrder;

public interface EfastOrderService {
	
	void getEfastOrdersFromLastTimeByPage(int pageIndex,Date currentDate,List<EfastOrder> efastOrderList);

}
