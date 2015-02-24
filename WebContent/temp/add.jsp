<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%
	int x = 0;
	int y = 0;

	if (request.getMethod().equals("POST")) {
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		if (_x != null && !_x.equals(""))
			x = Integer.parseInt(_x);

		if (_y != null && !_y.equals(""))
			y = Integer.parseInt(_y);
	}

	int sum = x + y;

	String _save = request.getParameter("save");
	if (_save != null)// 저장소 사용하는 법~
	{
		String _sum = request.getParameter("sum");

		if (_save.equals("앱")) {
			//ServletContext application = request.getServletContext();
			application.setAttribute("sum", _sum);
			System.out.println("saved in app");
		}

		if (_save.equals("세션")) {
			//HttpSession session = request.getSession();
			session.setAttribute("sum", _sum);
			System.out.println("saved in session");
		}

		if (_save.equals("쿠키")) {
			Cookie cookie = new Cookie("sum", _sum);
			cookie.setMaxAge(24 * 60 * 60);
			response.addCookie(cookie);
			System.out.println("saved in session");
		}

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="add.jsp" method="post">
		<ul>
			<li><label for=x>X:</label><input name=x /></li>
			<li><label for=y>Y:</label><input name=y /></li>
			<li><label for=sum>Sum:</label><input name=sum value="<%=sum%>"/></li>
		</ul>

		<p>
			<input type="submit" value="덧셈" /> 
			<input type="submit" value="앱" />
			<input type="submit" value="세션" />
			<input type="submit" value="쿠키" />
			<p><a href="home">home</a></p>
		</p>
	</form>

</body>
</html>