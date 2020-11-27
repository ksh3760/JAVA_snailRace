package 달팽이레이싱게임;

import java.sql.*;

public class sDb {
	static Connection con;
	static Statement stmt;
	
	public sDb() {
		// 1. JDBC 드라이버를 적재
		System.out.println("------------------------------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}
			
		// 2. DB 연결
		String url		= "jdnc:oracle:thin:@net.yju.ac.kr:1521:orcl";	// oracle DB 접속을 위한 url
		String id 		= "s1701052";									// oracle DB 접속을 위한 아이디
		String password = "p1701052";									// oracle DB 접속을 위한 패스워드
		con 	= null;
		
		try {
			con = DriverManager.getConnection(url , id, password);
			System.out.println("연결 성공");
		} catch (SQLException e) {
			System.out.println("연결 오류");
		}

		System.out.println("------------------------------");
	}
	
	// 캐쉬 조회
	public static void ckeckCash() {
		
		
		try {
			stmt = con.createStatement();
			String sql = null;
			sql = "select u_cash from userInfo where u_name = 'John Doe'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("쿼리를 요청하였습니다.");
			while(rs.next()) {
				System.out.println(rs.getInt(sql));
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("캐쉬 조회중 오류가 발생하였습니다.");
		}
		
	}
	
	// 기록
	
	
}
