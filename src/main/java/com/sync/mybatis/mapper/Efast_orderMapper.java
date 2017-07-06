package com.sync.mybatis.mapper;

import com.sync.mybatis.model.Efast_order;

public interface Efast_orderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Efast_order record);

    int insertSelective(Efast_order record);

    Efast_order selectByPrimaryKey(Integer id);
    
    Efast_order selectBySellRecordCode(String sellRecordCode);

    int updateByPrimaryKeySelective(Efast_order record);

    int updateByPrimaryKey(Efast_order record);
    
    int getTotalConsumptionByYear(int year,String mobile);
}