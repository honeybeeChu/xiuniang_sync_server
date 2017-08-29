package com.sync.mybatis.mapper;

import java.util.List;

import com.sync.mybatis.model.Membership;

public interface MembershipMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Membership record);

    int insertSelective(Membership record);

    Membership selectByPrimaryKey(Integer id);
    
    Membership selectByMobile(String mobile);
	
	List<Membership> selectByName(String name);
	
	List<Membership> selectByOpenId(String openId);
	
	List<Membership> selectByDianyuanId(Integer dianyuanId);
	
	List<Membership> selectAllMemberships();

    int updateByPrimaryKeySelective(Membership record);

    int updateByPrimaryKey(Membership record);
}