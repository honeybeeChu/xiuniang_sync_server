package com.sync.mybatis.mapper;

import java.util.List;

import com.sync.model.Wx_shop;

public interface Wx_shopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wx_shop record);

    int insertSelective(Wx_shop record);

    Wx_shop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wx_shop record);

    int updateByPrimaryKey(Wx_shop record);
    
    int findCountByPoid(String poid);
    
    List<Wx_shop> getAllShopsByAccountid(int account_id);
    
    List<Wx_shop> getShopInfoByPoid(String poi_id);
}