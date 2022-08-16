package com.cys.boot.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.cys.boot.Application;
import com.cys.boot.controller.AccountController;
import com.cys.boot.controller.TestController;
import com.cys.boot.service.CustomerServiceStaffService;
import com.cys.boot.service.SellerService;
import com.cys.boot.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Tests.class)
@ContextConfiguration(classes=Application.class)
@WebAppConfiguration
public class Tests {
	/*
	@Autowired
	private HttpServletRequest hsr;
	@Autowired
	private UserService userservice;
	@Autowired
	private SellerService sellerservice;
	@Autowired
	private CustomerServiceStaffService csss;
	*/
	@Test
	public void testWeb() throws Exception {
			TestController con=new TestController();
			MockMvc mockmvc=standaloneSetup(con).setSingleView(
					new InternalResourceView("/resources/shuoshuo.html")).build();
			String param="[\"第一版\",\"第二版\",\"第三版\"]";
			mockmvc.perform(post("/testJsonArr")
					.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
					.param( param)
			);	
			mockmvc.perform(post("/testJsonArr1")
					.contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
					.param( param)
			);
	}
	
}
