package com.example.hp.controller;


import com.example.hp.domian.Car;
import com.example.hp.domian.House;
import com.example.hp.domian.Page;
import com.example.hp.domian.User;
import com.example.hp.service.ICarService;
import com.example.hp.service.IHouseService;
import com.example.hp.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/car")
public class CarController {

    @Autowired
    private ICarService carService;

    @Autowired
    private IHouseService houseService;

    @GetMapping(value = "/all")
    public ResponseEntity all(HttpServletRequest request, Page page){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResponseEntity.ok().body("请登录");
        }
        List<Car> cars = carService.getByUserId(user.getId(),page);
        if(cars.size()>0){
            List<Integer> ids = new ArrayList<>();
            cars.forEach(car -> {
                ids.add(car.getHouseId());
            });
            List<House> houses = houseService.getByIdIn(ids);
            int total = carService.countByUserId(user.getId());
            PageResult pageResult = new PageResult();
            pageResult.setBody(houses);
            pageResult.setTotal(total);
            return ResponseEntity.ok().body(pageResult);
        }else {
            return ResponseEntity.ok().body(null);
        }
    }


    @PostMapping(value = "/create")
    public ResponseEntity create(HttpServletRequest request,@RequestBody Car car){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResponseEntity.ok().body("请登录");
        }
        car.setUserId(user.getId());
        carService.insert(car);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id){
        houseService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "")
    public ResponseEntity deleteByUserId(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            return ResponseEntity.ok().body("请登录");
        }
        carService.deleteByUserId(user.getId());
        return ResponseEntity.ok().build();
    }

}
