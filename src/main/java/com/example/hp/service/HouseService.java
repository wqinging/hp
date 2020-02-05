package com.example.hp.service;

import com.example.hp.domian.House;
import com.example.hp.domian.Page;

import java.util.List;

public interface HouseService {
	
	House showHouseByName(String name);

	List<House> showHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg, Page page);

	int countHouse(String regiArg, String subArg, String rentArg, String areaArg, String typeArg);

    List<House> searchHouseByName(String name);
    
    int countHouseByName(String name);

    
}
