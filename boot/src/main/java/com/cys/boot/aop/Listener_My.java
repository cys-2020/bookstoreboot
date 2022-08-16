package com.cys.boot.aop;
import com.cys.boot.entity.User;
import com.cys.boot.service.ShoppingCartService;
import com.cys.boot.service.UserService;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
 
@WebListener
@Service
public class Listener_My implements HttpSessionListener, ServletRequestListener, ServletContextListener, ServletContextAttributeListener,
        ServletRequestAttributeListener, HttpSessionAttributeListener {
	private UserService userservice;
	private ShoppingCartService scservice;
	
	@Autowired
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}
	@Autowired
	public void setScservice(ShoppingCartService scservice) {
		this.scservice = scservice;
	}

	@Override
    public void sessionCreated(HttpSessionEvent se) {
    	System.err.println("已经开启会话！！");
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    	System.err.println("会话销毁！！！！！");
    	User user=(User)se.getSession().getAttribute("user");
    	userservice.updateUser(user);
    	userservice.flushAddresses(user);
    	//scitem
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("请求初始化");
    }
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("请求销毁");
 
    }
 
    @Override
    public void contextInitialized(ServletContextEvent sce){
        try{
            System.out.println("Servlet初始化");
        }catch (Exception e){
            System.out.println("初始化失败");
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            System.out.println("Servlet销毁");
            Enumeration drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = (Driver) drivers.nextElement();
                DriverManager.deregisterDriver(driver);
                System.out.println("deregistering jdbc driver: " + driver);
            }
            AbandonedConnectionCleanupThread.uncheckedShutdown();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("销毁工作异常");
        }
 
    }

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		// TODO Auto-generated method stub
		
	}
}