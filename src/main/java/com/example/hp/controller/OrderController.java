package com.example.hp.controller;


import com.example.hp.domian.*;
import com.example.hp.service.ICarService;
import com.example.hp.service.IHouseService;
import com.example.hp.service.IOrderService;
import com.example.hp.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/car")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private IHouseService houseService;

    @Autowired
    private ICarService carService;

    @GetMapping(value = "/all")
    public ResponseEntity all(HttpServletRequest request, Page page){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResponseEntity.ok().body("请登录");
        }
        List<Order> orders = orderService.getByUserId(user.getId(), page.getPage(), page.getSize());
        if(orders.size()>0){
            List<Integer> ids = new ArrayList<>();
            orders.forEach(order -> {
                ids.add(order.getHouseId());
            });
            List<House> houses = houseService.getByIdIn(ids);
            int total = orderService.countByUserId(user.getId());
            PageResult pageResult = new PageResult();
            pageResult.setBody(houses);
            pageResult.setTotal(total);
            return ResponseEntity.ok().body(pageResult);
        }else {
            return ResponseEntity.ok().body(null);
        }
    }


    @PostMapping(value = "/create")
    public ResponseEntity all(HttpServletRequest request, @RequestBody List<Integer> houseIds){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResponseEntity.ok().body("请登录");
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDate = format.format(date);
        for (Integer houseId : houseIds){
            Order order = new Order();
            order.setHouseId(houseId);
            order.setUserId(user.getId());
            order.setCreateTime(formatDate);
            orderService.insert(order);
            carService.deleteByHouseId(houseId);
        }
        return ResponseEntity.ok().build();
    }

}
