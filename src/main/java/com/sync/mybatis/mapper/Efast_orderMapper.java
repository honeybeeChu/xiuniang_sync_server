package com.sync.mybatis.mapper;

import java.util.List;

import com.sync.mybatis.model.Efast_order;
import com.sync.mybatis.model.dto.CustomerIndexDTO;
import com.sync.mybatis.vo.EfastOrderConditionVO;

public interface Efast_orderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Efast_order record);

    int insertSelective(Efast_order record);

    Efast_order selectByPrimaryKey(Integer id);
    
    int selectAcountBySellRecordCode(String sellRecordCode);

    int updateByPrimaryKeySelective(Efast_order record);

    int updateByPrimaryKey(Efast_order record);
    
    int getTotalConsumptionByYear(int year,String mobile);
    
    List getCountByUserAndTime(String startDate,String endDate);
    
    List<Efast_order> selectByBuyerName(String buyer_name);
    
    List<CustomerIndexDTO> selectCustomerIndex(EfastOrderConditionVO condition);
}