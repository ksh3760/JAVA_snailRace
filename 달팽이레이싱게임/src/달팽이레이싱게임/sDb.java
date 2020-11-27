package �����̷��̰̽���;

import java.sql.*;

public class sDb {
	static Connection con;
	static Statement stmt;
	
	static String bCash;
	
	public sDb() {
		// 1. JDBC ����̹��� ����
		System.out.println("------------------------------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		}
			
		// 2. DB ����
		String url		= "jdnc:oracle:thin:@net.yju.ac.kr:1521:orcl";	// oracle DB ������ ���� url
		String id 		= "s1701052";									// oracle DB ������ ���� ���̵�
		String password = "p1701052";									// oracle DB ������ ���� �н�����
		con 	= null;
		
		try {
			con = DriverManager.getConnection(url , id, password);
			System.out.println("���� ����");
		} catch (SQLException e) {
			System.out.println("���� ����");
		}

		System.out.println("------------------------------");
	}
	
	// ĳ�� ��ȸ
	public static void ckeckCash() {

		try {
			stmt = con.createStatement();
			String sql = null;
			sql = "select u_cash from userInfo where u_name = 'John Doe'";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("������ ��û�Ͽ����ϴ�.");
			
			while(rs.next()) {
				bCash = rs.getString("u_cash");	// ���� ĳ�� 
				System.out.println("���� ĳ�� : " + bCash);
			}
			// ���� ĳ���� �ؽ�Ʈ�� ����Ѵ�.
			sFrame.tf.setText("���� ĳ�� : " + bCash);
		} catch (SQLException e) {
			System.out.println("ĳ�� ��ȸ�� ������ �߻��Ͽ����ϴ�.");
		}
		
	}
	
	// ��� ��� ��� **************************************************
	public static void updateGameRecord() {
		try {
			stmt = con.createStatement();
			
			String  sql = "INSERT into GAMERECORD VALUES (cntRound.NEXTVAL, '" + sThread.sTime + "','" + sThread.winSnail + "')";
			stmt.executeUpdate(sql);
			System.out.println("��� ��Ͽ� �����Ͽ����ϴ�.");
		} catch (Exception e) {
			System.out.println("��� ��� ��� �� ������ �߻��Ͽ����ϴ�.");
		}
	}
	
	
	// ��� ��ȸ
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
			System.out.println("����� ��ȸ�� �����Ͽ����ϴ�.");
		} catch (Exception e) {
			System.out.println("��� ��ȸ�� ������ �߻��Ͽ����ϴ�.");
		}
		
	}
	
	
	// ���� ����
	public static void winBetting() {
		try {
			stmt = con.createStatement();
			String  sql = "update USERINFO set U_CASH = U_CASH + 1 where U_NAME = 'John Doe'";
			stmt.executeUpdate(sql);
			System.out.println("���� ������ �����߼��ϴ�. (winBetting)");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���� ������Ʈ �� ������ �߻��Ͽ����ϴ�.");
		}
		
	}// end winBetting()
	
	public static void loseBetting() {
		try {
			stmt = con.createStatement();
			String  sql = "update USERINFO set U_CASH = U_CASH - 1 where U_NAME = 'John Doe'";
			stmt.executeUpdate(sql);
			System.out.println("���� ������ �����߼��ϴ�. (loseBetting)");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("���� ������Ʈ �� ������ �߻��Ͽ����ϴ�.");
		}
	}// end loseBetting()
	
	
	
	
	
	
}
