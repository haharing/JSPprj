package com.newlecture.jspprj;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class NewlecSessionListener implements HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent event) 
	{
		System.out.println("技记 积己: "+event.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent event)
	{
		System.out.println("技记 辆丰: "+event.getSession().getId());
	}
	
}
