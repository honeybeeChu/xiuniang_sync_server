package com.sync.mybatis.mapper;

import java.util.List;

import com.sync.mybatis.model.Points_rule;

public interface Points_ruleMapper {
	   int deleteByPrimaryKey(Integer id);

	    int insert(Points_rule record);

	    int insertSelective(Points_rule record);

	    Points_rule selectByPrimaryKey(Integer id);
	    
	    List<Points_rule> selectByLevel(int level);
	    
	    List<Points_rule> selectAllRules();
	    
	    int getPointsRuleCount();

	    int updateByPrimaryKeySelective(Points_rule record);

	    int updateByPrimaryKey(Points_rule record);
}