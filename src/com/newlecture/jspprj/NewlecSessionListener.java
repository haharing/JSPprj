package com.newlecture.jspprj;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class NewlecSessionListener implements HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent event) 
	{
		System.out.println("���� ����: "+event.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent event)
	{
		System.out.println("���� ����: "+event.getSession().getId());
	}
	
}
