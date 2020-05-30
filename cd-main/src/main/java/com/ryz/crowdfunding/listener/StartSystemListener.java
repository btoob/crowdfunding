package com.ryz.crowdfunding.listener;

import org.slf4j.ILoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartSystemListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        String contextPath = application.getContextPath();
        System.out.println("app_path...."+contextPath);

        application.setAttribute("APP_PATH", contextPath);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
