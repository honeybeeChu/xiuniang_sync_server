package com.sync.mybatis.mapper;

import com.sync.mybatis.model.Offline_vip_order;

public interface Offline_vip_orderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Offline_vip_order record);

    int insertSelective(Offline_vip_order record);

    Offline_vip_order selectByPrimaryKey(Integer id);
    
    Offline_vip_order selectByVmbillId(String vmbillID);

    int updateByPrimaryKeySelective(Offline_vip_order record);

    int updateByPrimaryKey(Offline_vip_order record);
}