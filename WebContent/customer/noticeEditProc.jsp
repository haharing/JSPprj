<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   String title = request.getParameter("title");
   String code = request.getParameter("code");
   String content = request.getParameter("content");
   
   Notice n = new Notice();
   n.setTitle(title);
   n.setContent(content);
   n.setCode(code);
   
   NoticeDao dao = new JdbcNoticeDao();
   dao.update(n);
   
   response.sendRedirect("noticeDetail.jsp?c="+code);
%>