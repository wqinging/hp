package com.example.hp.dao;

import java.util.List;

import com.example.hp.domian.House;
import com.example.hp.domian.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseDao {

	House showHouseByName(String name);

	List<House> findHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg, Page page);

	int countHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg);
	
    List<House> searchHouseByName(String name);
    
    int countHouseByName(String name);
}
