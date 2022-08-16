package com.cys.boot.dao;

import com.cys.boot.entity.User;

public interface UserDAO {
	User getUser(long id);
	User getUserByPhoneNumber(long phoneNumber);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
}
