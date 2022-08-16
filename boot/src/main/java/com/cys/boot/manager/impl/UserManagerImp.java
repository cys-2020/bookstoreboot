package com.cys.boot.manager.impl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cys.boot.dao.UserDAO;
import com.cys.boot.entity.User;
import com.cys.boot.manager.UserManager;
@Service
public class UserManagerImp implements UserManager{
	private UserDAO dao;
	
	public UserManagerImp(UserDAO dao) {
		this.dao = dao;
	}
	@Transactional(rollbackFor=Exception.class,
		propagation=Propagation.SUPPORTS)
	public User getUser(long id) {
		//
		return dao.getUser(id);
	}
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void insertUser(User user) {
		//
		dao.insertUser(user);
	}
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void updateUser(User user) {
		//
		dao.updateUser(user);
	}
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.REQUIRED)
	public void deleteUser(User user) {
		//
		dao.deleteUser(user);
	}
	@Override
	@Transactional(rollbackFor=Exception.class,
	propagation=Propagation.SUPPORTS)
	public User getUserByPhoneNumber(long phoneNumber) {
		//
		return dao.getUserByPhoneNumber(phoneNumber);
	}
}
