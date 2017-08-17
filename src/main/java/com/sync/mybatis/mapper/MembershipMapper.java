package com.sync.mybatis.mapper;

import java.util.List;

import com.sync.mybatis.model.Membership;

public interface MembershipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Membership record);

    int insertSelective(Membership record);

    Membership selectByPrimaryKey(Integer id);
    
	List<Membership> selectByMobile(String mobile);
	
	List<Membership> selectAllMemberships();

    int updateByPrimaryKeySelective(Membership record);

    int updateByPrimaryKey(Membership record);
}