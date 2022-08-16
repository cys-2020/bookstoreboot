package com.cys.boot.utils;

import javax.mail.Authenticator;

import javax.mail.PasswordAuthentication;

/**
 *	@description 
 *	@author cys(ChenYongsheng)
 * 	@date 2022��5��15��
 */
public class MyAuthenticator extends Authenticator {

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		//
		return super.getPasswordAuthentication();
	}
	
}
