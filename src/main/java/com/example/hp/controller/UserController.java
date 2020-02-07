package com.example.hp.controller;


import com.example.hp.domian.User;
import com.example.hp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "api/user")
public class UserController{

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public ResponseEntity login(HttpServletRequest request,User user){
        User u = userService.login(user);
        request.getSession().setAttribute("user",u);
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        userService.register(user);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody User user){
        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/logout")
    public ResponseEntity logout(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return ResponseEntity.ok().build();
    }



}
