package com.example.hp.serviceImpl;


import com.example.hp.dao.UserDao;
import com.example.hp.domian.User;
import com.example.hp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login(User user) {
		User u = userDao.find(user);
		return u;
	}

	@Override
	public void register(User user) {
		userDao.insert(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}
}
