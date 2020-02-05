package com.example.hp.dao;

import java.util.List;

import com.example.hp.domian.PubHouse;
import com.example.hp.domian.User;

public interface UserDao {

	User checkUser(User user);
	
	User checkUserByPassword(User user);

	void insertUser(User user);
	
	void updateUser(User user);

	void insertPHouse(PubHouse pubHouse);

	List<PubHouse> findPHouse(String phoneNumber);
	
	void deletePHouse(int id);
}
