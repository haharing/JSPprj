package com.newlecture.jspprj;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//세션 요청을 확인하기 위한 ServletRequestListener 구현
public class NewlecRequestListener implements ServletRequestListener{
	
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("요청 종료 Remote IP="+event.getServletRequest().getRemoteAddr());
	}
	
	@Override
	public void requestInitialized(ServletRequestEvent event) 
	{
		System.out.println("요청 초기화 Remote IP="+event.getServletRequest().getRemoteAddr());
	}

}
