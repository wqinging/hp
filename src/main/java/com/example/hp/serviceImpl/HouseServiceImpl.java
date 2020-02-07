package com.example.hp.serviceImpl;


import com.example.hp.dao.HouseDao;
import com.example.hp.domian.House;
import com.example.hp.domian.Page;
import com.example.hp.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    private HouseDao houseDao;

    @Override
    public void insert(House house) {
        houseDao.insert(house);
    }

    @Override
    public void update(House house) {
        houseDao.update(house);
    }

    @Override
    public House showHouseById(int id) {
        House house = houseDao.getById(id);
        return house;
    }

    @Override
    public List<House> showHouse(House house, Page page) {
        List<House> houses = houseDao.findHouse(house.getSubway(), house.getHouseType(), page);
        return houses;
    }

    @Override
    public int countHouse(House house) {
        int count = houseDao.countHouse(house.getSubway(), house.getHouseType());
        return count;
    }

    @Override
    public List<House> searchHouseByName(String name) {
        return null;
    }

    @Override
    public List<House> getByIdIn(List<Integer> ids) {
        List<House> houses = houseDao.getByIdIn(ids);
        return houses;
    }


    @Override
    public void deleteById(int id) {
        houseDao.delete(id);
    }
}
