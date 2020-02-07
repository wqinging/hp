package com.example.hp.service;


import com.example.hp.domian.Car;
import com.example.hp.domian.Page;

import java.util.List;

public interface ICarService {

    void insert(Car car);

    List<Car> getByUserId(int userId, Page page);

    void deleteById(int id);

    void deleteByUserId(int userId);

    int countByUserId(int userId);

}
