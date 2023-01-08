package com.findgeo.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.findgeo.util.Script;

public class SessionListener implements HttpSessionListener{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		se.getSession().setMaxInactiveInterval(60*60*24);//세션만료 60분 60*60
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}
}
