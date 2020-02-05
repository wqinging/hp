package com.example.hp.dao;

import com.example.hp.domian.Agent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentDao {

    @Select("select * from agent where id = #{id}")
    Agent findById(int id);

    @Select("select * from agent")
    List<Agent> findAll();

    @Insert("insert into agent(name,phone,image) values(#{name},#{phone},#{image})")
    void insert(Agent agent);

    @Update("update agent set name = #{name},phone = #{phone},image = #{image}")
    void update(Agent agent);

    @Delete("delete from agent where id = #{id}")
    void  delete(int id);
}
