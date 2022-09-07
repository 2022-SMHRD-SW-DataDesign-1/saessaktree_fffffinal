package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs;
	boolean result;
	
	//DB연결 - 2022-09-06, 김지수
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String id = "campus_g_0830_2";
			String pw = "smhrd2";
			
			conn = DriverManager.getConnection(url,id,pw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("동적 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
	}
	
	//close
	public void getClose() {
		try {
			if (rs!=null) {
				rs.close();
			}
			if (psmt!=null) {
				psmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//Sing Up
	public int insert(UserDTO uDto) {
		int cnt = 0;
		connect();
		
		try {
			String id = uDto.getId();
			String pw = uDto.getPw();
			String name = uDto.getName();
			int app_cnt = uDto.getApp_cnt();
			
			String sql = "insert into user_info values(?, ?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setInt(4, app_cnt);
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	//login
	public boolean login(String user_id, String user_pw) {
		connect();
		try {
			String sql = "select * from user_info where id= ? and password = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,user_id);
			psmt.setString(2,user_pw);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}else {
				result = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	//basic apple count
	public int app_ok_up(String user_id) {
		int app = 0;
		connect();
		String sql;
		try {
			sql = "select * from user_info where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			rs = psmt.executeQuery();
			rs.next();
			app = rs.getInt(4);
			app = app+2;
			
			sql = "update user_info set app_cnt = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, app);
			psmt.setString(2, user_id);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return app;
	}

	public int app_down_up(String user_id) {
		int app = 0;
		connect();
		String sql;
		try {
			sql = "select * from user_info where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user_id);
			
			rs = psmt.executeQuery();
			rs.next();
			app = rs.getInt(4);
			app = app-1;
			
			sql = "update user_info set app_cnt = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, app);
			psmt.setString(2, user_id);
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return app;
	}

	//apple Reset
	public void appReset(String user_id) {
		try {
			String sql = "update user_info set app_cnt = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, 3);
			psmt.setString(2, user_id);
			
			psmt.executeUpdate();
			
		} catch (Exception e) {
			
		}
		
	}


	

}
