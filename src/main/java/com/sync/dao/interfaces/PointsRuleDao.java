package com.sync.dao.interfaces;

import java.util.List;
import java.util.Map;

public interface PointsRuleDao {
	
	List<Map<Integer,String[]>> getPointsRules();
	
	float queryRateByLevel(int level);
	
	int queryConsumptionByLevel(int level);
	
	
	
}
