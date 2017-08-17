package com.sync.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.sync.mybatis.model.Dianyuan;

public interface DianyuanMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Dianyuan record);

	int insertSelective(Dianyuan record);

	Dianyuan selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Dianyuan record);

	int updateByPrimaryKey(Dianyuan record);

	List<Dianyuan> getAllDianyuan();

	List<Dianyuan> getDianyuanByDYDM(String DYDM);
	
	List<Dianyuan> getDianYuanByName(String dymc);
	
	List<Map<String, Object>> getCountByKHDM();
	
}