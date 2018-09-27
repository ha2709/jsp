package com.service;

import java.util.List;

import com.dao.UserDao;
import com.model.User;

public class UserService {
 

private UserDao userDao;
public   UserService() {
	userDao = new UserDao();
}

public List<User> getAllUsers(){
	
	return userDao.getAllUser();
	
}
public User getUserById(int id) {
	return userDao.getUserById(id);
}
public User getUserByUsername(String username) {
	return userDao.getUserByUsername(username);
}
public void addUser(User user) {
	
	userDao.addUser(user);
}
public void updateUserAvatar(User user) {
	userDao.updateUserAvatar(user);
}


public void updateUser(User user) {
	userDao.updateUser(user);
}

public void deleteUser(int id) {
	System.out.println("Delete phan tu");
	userDao.deleteUser(id);
}
public static void main(String[] args) {
	UserService userService = new UserService();
	userService.getAllUsers();
}
}
