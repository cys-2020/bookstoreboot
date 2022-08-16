package com.cys.boot.service;

import com.cys.boot.entity.User;

public interface EmailService {
	void sendEmail(User user);
}
