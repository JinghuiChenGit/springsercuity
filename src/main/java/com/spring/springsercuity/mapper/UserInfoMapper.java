package com.spring.springsercuity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {

    @Select("select * from users where username = #{name}")
    public Map findUserByName(String name);

    @Select("select authority from authorities where username = #{name}")
    public List<String> fingUserRoleByName(String name);

}
