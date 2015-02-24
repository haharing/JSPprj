<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcNoticeFileDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeFileDao"%>
<%@page import="com.newlecture.jspprj.model.NoticeFile"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.newlecture.jspprj.model.Notice"%>
<%@page import="com.newlecture.jspprj.dao.jdbc.JdbcNoticeDao"%>
<%@page import="com.newlecture.jspprj.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 컨트롤러 -->
<%
	ServletContext ctx = request.getServletContext();
     String path = ctx.getRealPath("/customer/upload");
     
      

     MultipartRequest req = new MultipartRequest(request
                                   , path
                                   ,1024*1024*10
                                   ,"UTF-8"
                                   ,new DefaultFileRenamePolicy());

     
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String fileName = req.getFilesystemName("file");
     

/* String title = request.getParameter("title");
   String content = request.getParameter("content");
   String file = request.getParameter("file"); */ 

   Notice notice = new Notice(); //데이터를 담는 모델
   notice.setTitle(title);
   notice.setContent(content);//현재는 임시로 이름을 직접지정
   notice.setWriter("A0A");
   
//컨트롤러의 일부분 데이터베이스의 연동하는 부분을 만들어 놓은거? 다오를 쓰는 입장에서는 자바만 알아도 되니깐.. 따로 만들어줌? 
//데이터 소스를 숨긴다는 것에 장점이 있다. 데이터소스를 변화를 줘도 이것을 ㅅ정을 안해줘도 된다. 
//데이터소스를 가리는거는 집중화의 의미도 있고 협업의 장점 재사용의 장점이 있다. mvc와는 상관없다.
   NoticeDao noticeDao = new JdbcNoticeDao();  
   noticeDao.insert(notice);
   
   if(req.getFile("file") !=null)
   {
   		String noticeCode =  noticeDao.lastCode();
   
   		NoticeFile noticeFile = new NoticeFile();
   
   		noticeFile.setDescription("");
   noticeFile.setSrc(fileName);
   noticeFile.setNoticeCode(noticeCode);
   
	NoticeFileDao fileDao = new JdbcNoticeFileDao();
	fileDao.insert(noticeFile);
   }
//목록 페이지로 이동
   response.sendRedirect("notice.jsp");
%>