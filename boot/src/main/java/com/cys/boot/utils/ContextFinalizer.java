package com.cys.boot.utils;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
public class ContextFinalizer implements ServletContextListener{
 
    public void contextInitialized(ServletContextEvent sce) {}
 
    public void contextDestroyed(ServletContextEvent sce) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        Driver d = null;
        while (drivers.hasMoreElements()) {
            try {
                d = drivers.nextElement();
                DriverManager.deregisterDriver(d);
            } catch (SQLException ex) {
            }
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
    }
 }