package com.example.hp.dao;


import com.example.hp.domian.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	@Select("select * from user where name = #{name} and password = #{password} ")
	User find(User user);

	@Insert("insert into user(name,password,phone,email,sex) values(#{name},#{password},#{phone},#{email},#{sex})")
	void insert(User user);

	@Update("update user set name = #{name},password = #{password},phone = #{phone},email = #{email},sex = #{sex} where id  = #{id}")
	void update(User user);

	@Delete("delete from user where id = #{id}")
	void  delete(int id);

}
