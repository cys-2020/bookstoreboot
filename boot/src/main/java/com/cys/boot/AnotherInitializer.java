package com.cys.boot;

import javax.servlet.ServletRegistration.Dynamic;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class AnotherInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) 
			throws ServletException {/*
		//�ֶ�ע��Servlet����ǰ��д��web.xml���
		Dynamic servlet1=servletContext.addServlet(
				"servlet1name", servlet1.class);
		servlet1.addMapping("servlet1��url");
		//�ֶ�ע��Filter
		javax.servlet.FilterRegistration.Dynamic filter1=
				servletContext.addFilter("filter1name", filter1.class);
		filter1.addMappingForUrlPatterns(null, false, "��Ҫfilter��url");*/
	}

}
