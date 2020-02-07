package com.example.hp.dao;

import java.util.List;

import com.example.hp.domian.House;
import com.example.hp.domian.Page;
import com.example.hp.provider.HouseProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseDao {

	@Insert("insert into house(name,price,area,floor,village,house_type,address,subway,p_time,ori,build_time,image,agent) " +
			"values(#{name},#{price},#{area},#{floor},#{village},#{houseType},#{address},#{subway},#{pTime},#{ori},#{buildTime},#{image},#{agent})")
	void insert(House house);

	@Update("update house set name = #{name},price = #{price},area = #{area},floor = #{floor},village = #{village},house_type = #{houseType},address = #{address}," +
			"subway = #{subway},p_time = #{pTime},ori = #{ori},build_time = #{buildTime},image = #{image},agent = #{agent} where id = #{id}")
	void update(House house);

	@Delete("delete from house where id = #{id}")
	void  delete(int id);

	@Select("select * from house where id = #{id}")
	House getById(int name);

	@SelectProvider(type = HouseProvider.class,method = "findHouse")
	List<House> findHouse(String subArg, String typeArg, Page page);

	@SelectProvider(type = HouseProvider.class,method = "countHouse")
	int countHouse(String subArg, String typeArg);

	@Select("select * from house WHERE name like %#{name}%")
    List<House> searchHouseByName(String name);

	@Select("select count(*) from house WHERE name = #{name}")
    int countHouseByName(String name);

	@Select({
			"<script>",
			"select",
			"*",
			"from house",
			"where id in",
			"<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
			"#{id}",
			"</foreach>",
			"</script>"
	})
	List<House> getByIdIn(@Param("ids") List<Integer> ids);
}
