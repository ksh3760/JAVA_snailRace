package 달팽이레이싱게임;

import java.sql.*;

public class sDb {
	static Connection con;
	static Statement stmt;
	
	static String bCash;
	
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
				bCash = rs.getString("u_cash");	// 현재 캐쉬 
				System.out.println("현재 캐쉬 : " + bCash);
			}
			// 현재 캐쉬를 텍스트에 출력한다.
			sFrame.tf.setText("현재 캐쉬 : " + bCash);
		} catch (SQLException e) {
			System.out.println("캐쉬 조회중 오류가 발생하였습니다.");
		}
		
	}
	
	// 경기 결과 기록 **************************************************
	public static void updateGameRecord() {
		try {
			stmt = con.createStatement();
			
			String  sql = "INSERT into GAMERECORD VALUES (cntRound.NEXTVAL, '" + sThread.sTime + "','" + sThread.winSnail + "')";
			stmt.executeUpdate(sql);
			System.out.println("경기 기록에 성공하였습니다.");
		} catch (Exception e) {
			System.out.println("경기 결과 기록 중 오류가 발생하였습니다.");
		}
	}
	
	
	// 기록 조회
	public static void gameRecord() {
		try {
			stmt = con.createStatement();
			String sql = null;
			sql = "select * from GAMERECORD";
			ResultSet rs = stmt.executeQuery(sql);
			
			int row = 0;
			while (rs.next()) {
				recordFrame.contents[row][0] = rs.getString("g_round");
				recordFrame.contents[row][1] = rs.getString("g_date");
				recordFrame.contents[row][2] = rs.getString("g_winner");
				row ++;
			}
			System.out.println("경기기록 조회에 성공하였습니다.");
		} catch (Exception e) {
			System.out.println("기록 조회중 오류가 발생하였습니다.");
		}
		
	}
	
	
	// 베팅 성공
	public static void winBetting() {
		try {
			stmt = con.createStatement();
			String  sql = "update USERINFO set U_CASH = U_CASH + 1 where U_NAME = 'John Doe'";
			stmt.executeUpdate(sql);
			System.out.println("베팅 수정에 성공했숩니다. (winBetting)");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("베팅 업데이트 중 오류가 발생하였습니다.");
		}
		
	}// end winBetting()
	
	public static void loseBetting() {
		try {
			stmt = con.createStatement();
			String  sql = "update USERINFO set U_CASH = U_CASH - 1 where U_NAME = 'John Doe'";
			stmt.executeUpdate(sql);
			System.out.println("베팅 수정에 성공했숩니다. (loseBetting)");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("베팅 업데이트 중 오류가 발생하였습니다.");
		}
	}// end loseBetting()
	
	
	
	
	
	
}
