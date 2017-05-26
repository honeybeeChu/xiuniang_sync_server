package com.sync.dao.interfaces;

import com.sync.model.EfastOrder;

/**
 * @author chuliang
 * 
 */
public interface EfastOrderDao {
	boolean addEfastOrder(EfastOrder efastOrder);
	
	int getTotalConsumptionByYear(int year);
}
