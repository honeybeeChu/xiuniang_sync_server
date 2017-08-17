package com.sync.mybatis.mapper;

import com.sync.mybatis.model.Wx_user;

public interface Wx_userMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Wx_user record);

    int insertSelective(Wx_user record);

    Wx_user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Wx_user record);

    int updateByPrimaryKey(Wx_user record);
}