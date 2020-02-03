package com.ronving.controller.listeners;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {
    private final static Logger LOGGER = Logger.getLogger(SessionAttributeListener.class);

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.log(Level.INFO,"Attribute " + httpSessionBindingEvent.getName() + " with value: "
                + httpSessionBindingEvent.getValue().toString() + " has been added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.log(Level.INFO,"Attribute " + httpSessionBindingEvent.getName() + " with value: "
                + httpSessionBindingEvent.getValue().toString() + " has been removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        LOGGER.log(Level.INFO,"Attribute " + httpSessionBindingEvent.getName() + " with value: "
                + httpSessionBindingEvent.getValue().toString() + " has been replaced");
    }
}
