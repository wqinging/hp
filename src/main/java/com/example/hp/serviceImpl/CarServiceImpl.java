package com.example.hp.serviceImpl;

import com.example.hp.dao.CarDao;
import com.example.hp.domian.Car;
import com.example.hp.domian.Page;
import com.example.hp.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarDao carDao;

    @Override
    public void insert(Car car) {
        carDao.insert(car);
    }

    @Override
    public List<Car> getByUserId(int userId, Page page) {
        List<Car> cars = carDao.getByUserId(userId,page.getPage(),page.getSize());
        return cars;
    }

    @Override
    public void deleteById(int id) {
        carDao.deleteById(id);
    }

    @Override
    public void deleteByHouseId(int houseId) {
        carDao.deleteByHouseId(houseId);
    }

    @Override
    public void deleteByUserId(int userId) {
        carDao.deleteByUserId(userId);
    }

    @Override
    public int countByUserId(int userId) {
        int total = carDao.countByUserId(userId);
        return total;
    }
}
