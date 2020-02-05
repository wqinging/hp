package com.example.hp.service;

import java.util.List;

import domian.PubHouse;
import domian.User;

public interface UserService {

	User loginUser(User user);

	void registerUser(User user);

	void insertPHouse(PubHouse pubHouse);

	List<PubHouse> findPHouse(String phone);

	User checkUser(User user);

	User checkUserByPassword(User user);
	
	void deletePHouse(int id);
	
	void updateUser(User user);
}
