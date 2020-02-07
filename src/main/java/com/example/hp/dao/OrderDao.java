package com.example.hp.dao;

import com.example.hp.domian.Car;
import com.example.hp.domian.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    @Insert("insert into `order`(userId,houseId,createTime) values(#{userId},#{houseId},#{createTime})")
    void insert(Order order);

    @Select("select * from `order` where userId = #{userId} limit #{page},#{size}")
    List<Order> getByUserId(@Param("userId") int userId, @Param("page") int page, @Param("size") int size);

    @Select("select count(*) from `order` where userId = #{userId}")
    int countByUserId(int userId);

    @Delete("delete from `order` where id = #{id}")
    void deleteById(int id);

    @Delete("delete from `order` where userId = #{userId}")
    void deleteByUserId(int userId);


}
