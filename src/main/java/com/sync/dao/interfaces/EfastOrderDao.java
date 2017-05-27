package com.sync.dao.interfaces;

import com.sync.model.EfastOrder;

/**
 * @author chuliang
 * 
 */
public interface EfastOrderDao {
	boolean addEfastOrder(EfastOrder efastOrder);
	
	boolean isExistBySellRecordCode(String sell_record_code);
	
	int getTotalConsumptionByYear(int year,String receiver_mobile);
}
