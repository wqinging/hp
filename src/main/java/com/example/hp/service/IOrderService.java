package com.example.hp.service;

import com.example.hp.domian.Order;
import java.util.List;

public interface IOrderService {

    void insert(Order order);

    List<Order> getByUserId(int userId, int page,  int size);

    int countByUserId(int userId);

    void deleteById(int id);

    void deleteByUserId(int userId);

}
