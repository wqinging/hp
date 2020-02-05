package com.example.hp.serviceImpl;

import java.util.List;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import domian.PubHouse;
import domian.User;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	UserDao userDao = new UserDaoImpl();

	@Override
	public User loginUser(User user) {
		return userDao.checkUser(user);
	}

	@Override
	public void registerUser(User user) {
		
		userDao.insertUser(user);
	}

	@Override
	public void insertPHouse(PubHouse pubHouse) {
		userDao.insertPHouse(pubHouse);
		
	}

	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUser(user);
	}

	@Override
	public User checkUserByPassword(User user) {
		// TODO Auto-generated method stub
		return userDao.checkUserByPassword(user);
	}

	@Override
	public List<PubHouse> findPHouse(String phone) {
		// TODO Auto-generated method stub
		return userDao.findPHouse(phone);
	}

	@Override
	public void deletePHouse(int id) {
		userDao.deletePHouse(id);
		
	}

	@Override
	public void updateUser(User user) {
		
		userDao.updateUser(user);
	}

}
