package com.newlecture.jspprj;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.connector.Request;

public class CharacterEncodingFilter implements Filter {
   //public FilterConfig filterConfig;
   
   private String encoding;
   
   @Override
   public void destroy() {
      // TODO Auto-generated method stub

   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
         FilterChain chain) throws IOException, ServletException {
      /*System.out.println("before 필터입니다");
      arg2.doFilter(arg0, arg1);
      System.out.println("after 필터입니다");*/
	   
	   request.setCharacterEncoding(encoding);
	   chain.doFilter(request, response);
   }

   @Override
   public void init(FilterConfig confing) throws ServletException {
      //filterConfig = arg0;
      encoding = confing.getInitParameter("encoding");
    		  
   }

}