package com.example.hp.controller;

import com.example.hp.domian.Manager;
import com.example.hp.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "api/manager")
public class ManagerController {

    @Autowired
    private IManagerService managerService;

    @GetMapping("/login")
    public ResponseEntity login(Manager manager){
        Manager one = managerService.findOne(manager);
        return ResponseEntity.ok().body(one);
    }

}
