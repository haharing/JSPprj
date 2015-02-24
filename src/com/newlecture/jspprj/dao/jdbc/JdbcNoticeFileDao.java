package com.newlecture.jspprj.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.jspprj.dao.NoticeFileDao;
import com.newlecture.jspprj.model.Notice;
import com.newlecture.jspprj.model.NoticeFile;

public class JdbcNoticeFileDao implements NoticeFileDao{

	@Override
	public List<NoticeFile> getNoticeFiles(String noticeCode) {
		// TODO Auto-generated method stub
		
		
		String sql = "select * from NoticeFiles where NoticeCode='"+noticeCode+"'";
		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			
			/*st.setString(1, "%" + query + "%");
			st.setInt(2, start);
			st.setInt(3, end);
*/
			ResultSet rs = st.executeQuery();
			
			List<NoticeFile> list = new ArrayList<NoticeFile>();

			while (rs.next()) {
				NoticeFile n = new NoticeFile();
				n.setCode(rs.getString("Code"));
				n.setSrc(rs.getString("Src"));
				n.setRegdate(rs.getDate("RegDate"));
				n.setDescription(rs.getString("Description"));
				
				list.add(n);
			}

			rs.close();
			st.close();
			con.close();

			return list;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int insert(NoticeFile file) {
		// TODO Auto-generated method stub
		

		String sql2 = "SELECT ISNULL(MAX(CAST(CODE AS INT)), 0)+1 CODE FROM NOTICEFILES";
	
		String sql = "INSERT INTO NoticeFiles(CODE, Src,REGDATE,Description, NoticeCode) VALUES(?,?,GETDATE(),?,?)";

		String url = "jdbc:sqlserver://win.newlecture.com:1433;databaseName=newlecdb";
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(url, "sist", "newlec");
			
			Statement stCode = con.createStatement();
			ResultSet rs = stCode.executeQuery(sql2);

			rs.next();
			String code2 = rs.getString("CODE");

			rs.close();
			stCode.close();

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, code2);
			st.setString(2, file.getSrc());
			st.setString(3, file.getDescription());
			st.setString(4, file.getNoticeCode());

			int result = st.executeUpdate();

			st.close();
			con.close();

			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
