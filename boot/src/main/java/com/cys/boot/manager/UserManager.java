package com.cys.boot.manager;

import com.cys.boot.entity.User;

public interface UserManager {
	User getUser(long id);
	User getUserByPhoneNumber(long phoneNumber);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
}
