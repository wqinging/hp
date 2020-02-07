package com.example.hp.service;

import com.example.hp.domian.House;
import com.example.hp.domian.Page;

import java.util.List;

public interface IHouseService {

	void insert(House house);

	void update(House house);

	House showHouseById(int id);

	List<House> showHouse(House house, Page page);

	int countHouse(House house);

    List<House> searchHouseByName(String name);

    List<House> getByIdIn(List<Integer> ids);

	void deleteById(int id);

    
}
