package �����̷��̰̽���;

import java.sql.*;

public class sDb {
	static Connection con;
	static Statement stmt;
	
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
				System.out.println(rs.getInt(sql));
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("ĳ�� ��ȸ�� ������ �߻��Ͽ����ϴ�.");
		}
		
	}
	
	// ���
	
	
}
