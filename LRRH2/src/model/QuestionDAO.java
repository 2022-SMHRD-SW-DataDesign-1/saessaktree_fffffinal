package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDAO {
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
	
	
	//ques print
	public void ques_select(int forNum) {
		connect();
		
		try {
			//int i = 1;
			String sql = "select * from question_10s where q_num10 = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, forNum);
			rs = psmt.executeQuery();
			
			System.out.println("문제");
			rs.next();
			String quePint = rs.getString(2);
			System.out.println(quePint+"?");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//ans match
	public boolean ques_select(String ans) {
		connect();
		boolean re;
		try {
			String sql = "select * from question_10s where ans10 = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ans);
			rs = psmt.executeQuery();
		
			if (rs.next()) {
				System.out.println("딩동댕동동");
				re = true;
				
			} else {
				System.out.println("땡!");
				re = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			re = false;
		}
		return re;
		
	}
	
	// ques print 20' - YURI
		public void ques_select20(int forNum) {
			connect();
			
			try {
				//int i = 1;
				String sql = "select * from question_20s where q_num20 = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, forNum);
				rs = psmt.executeQuery();
				
				System.out.println("문제");
				rs.next();
				String quePint = rs.getString(2);
				System.out.println(quePint+"?");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		//ans match 20'
		public boolean ques_select20(String ans) {
			connect();
			boolean re;
			try {
				String sql = "select * from question_20s where ans20 = ?";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, ans);
				rs = psmt.executeQuery();
			
				if (rs.next()) {
					System.out.println("딩동댕동동");
					re = true;
					
				} else {
					System.out.println("땡!");
					re = false;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				re = false;
			}
			return re;
			
		}
		


	
	
}
