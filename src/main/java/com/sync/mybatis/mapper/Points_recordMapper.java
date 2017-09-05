package com.sync.mybatis.mapper;

import java.util.List;

import com.sync.mybatis.model.Points_record;

public interface Points_recordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Points_record record);

    int insertSelective(Points_record record);

    Points_record selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Points_record record);

    int updateByPrimaryKey(Points_record record);
    
    List<Points_record> selectAllPointsRecord();
    
    List<Points_record> selectByMobile(String mobile);
}