package com.example.hp.service;


import com.example.hp.domian.PubHouse;
import com.example.hp.domian.User;

import java.util.List;

public interface IUserService {

	User login(User user);

	void register(User user);

	void update(User user);

	void delete(int id);
}
