package com.newlecture.jspprj;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpCookie;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home")
public class Index extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
				
		PrintWriter out = response.getWriter();
		
		ServletContext application = request.getServletContext();
		
		HttpSession session = request.getSession();

		Cookie[] cookies = request.getCookies();
			
		String _sum="0";
		String _sum1="0";
		String _sum2="";
				
		if(application.getAttribute("sum")!=null)		
			_sum = application.getAttribute("sum").toString();
		
		if(session.getAttribute("sum")!=null)		
			_sum1 = session.getAttribute("sum").toString(); //
		
		if(cookies != null)
			for(Cookie cookie : cookies)
				if("sum".equals(cookie.getName()))
					_sum2=cookie.getValue();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<p><a href=\"add\">계산하기:</a></p>");
		out.write("<p>app : "+_sum+"</p>");		
		out.write("<p>session : "+_sum1+"</p>");	
		out.write("<p>cookie : "+_sum2+"</p>");	
		out.write("</body>");
		out.write("</html>");
	}

}
