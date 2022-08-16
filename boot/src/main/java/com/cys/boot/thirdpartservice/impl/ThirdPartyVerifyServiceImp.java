package com.cys.boot.thirdpartservice.impl;

import org.springframework.stereotype.Service;

import com.cys.boot.thirdpartservice.ThirdPartyVerifyService;

@Service
public class ThirdPartyVerifyServiceImp implements ThirdPartyVerifyService {

	@Override
	public String getMessageVerifyCode(long phoneNumber) {
		//NOT YET
		return "220101";
	}

}
