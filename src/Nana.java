import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nana")
public class Nana extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*OutputStream os = response.getOutputStream();
	       
		PrintWriter out = new PrintWriter(os,true);*/
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String _cnt = request.getParameter("cnt");
		
		int cnt = 100;
		
		if(_cnt!=null)
			cnt = Integer.parseInt(_cnt);
		
		
		PrintWriter out = response.getWriter(); 
		
		for(int i=0; i<cnt; i++)
	       out.println((i+1)+": 안녕 Servlet!! <br/>"); //서유럽 코드방식? 크롬은 텍스트파일, 익스플로어는 html방식으로 그래서 크롬에서는 <br/>이 그대로 출력
				
		
	}

}
