package com.example.hp.dao;

import com.example.hp.domian.Manager;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDao {

    @Select("select * from manager where name = #{userName} and password = #{password}")
    Manager findOne(@Param("userName") String userName,@Param("password") String password);

}
