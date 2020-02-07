package com.example.hp.dao;

import com.example.hp.domian.Car;
import com.example.hp.domian.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao {

    @Insert("insert into car(userId,houseId) values(#{userId},#{houseId})")
    void insert(Car car);

    @Select("select * from car where userId = #{userId} limit #{page},#{size}")
    List<Car> getByUserId(@Param("userId") int userId,@Param("page") int page,@Param("size") int size);

    @Select("select count(*) from car where userId = #{userId}")
    int countByUserId(int userId);

    @Delete("delete from car where id = #{id}")
    void deleteById(int id);

    @Delete("delete from car where userId = #{userId}")
    void deleteByUserId(int userId);


}
