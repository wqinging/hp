package com.example.hp.serviceImpl;

import com.example.hp.dao.OrderDao;
import com.example.hp.domian.Order;
import com.example.hp.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public void insert(Order order) {
        orderDao.insert(order);
    }

    @Override
    public List<Order> getByUserId(int userId, int page, int size) {
        List<Order> orders = orderDao.getByUserId(userId, page, size);
        return orders;
    }

    @Override
    public int countByUserId(int userId) {
        int total = orderDao.countByUserId(userId);
        return total;
    }

    @Override
    public void deleteById(int id) {
        orderDao.deleteById(id);
    }

    @Override
    public void deleteByUserId(int userId) {
        orderDao.deleteByUserId(userId);
    }
}
