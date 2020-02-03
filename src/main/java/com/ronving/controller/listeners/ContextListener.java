package com.ronving.controller.listeners;

import com.ronving.dao.impl.SQLAccountDAO;
import com.ronving.dao.impl.SQLDAOFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {
    private final static Logger LOGGER = Logger.getLogger(SessionListener.class);
    private AtomicReference<SQLAccountDAO> dao;
    private static SQLDAOFactory factory = new SQLDAOFactory();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.log(Level.INFO, "Context initialized");
        dao = new AtomicReference<>(factory.getAccountDAO());
//
//
//        dao.get().addNewUser(new Account("admin", "admin",9999, ADMIN));
//        dao.get().addNewUser(new Account("user", "user",0, USER));
//
        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.log(Level.INFO, "Context destroyed");
        dao = null;
    }


}
