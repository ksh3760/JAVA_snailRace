package �����̷��̰̽���;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class recordFrame extends JFrame {
	
	private static final int ROWS = 10;
	private static final int COLS = 3;
	
	public static String[][] contents = new String[ROWS][COLS];
	
	
	public recordFrame() {
		Dimension dim = new Dimension(400,150);
		
		setTitle("��� ���");
		setSize(500, 300);
		

		
		String header[] = {"ȸ��", "�ð�", "���"};	
		
		// DB�� ���� ���� ����� �ҷ��´�.
		sDb.gameRecord();
		
		JTable t = new JTable(contents, header);
		JScrollPane sp = new JScrollPane(t);
		add(sp);
		setVisible(true);
		
		

	}


}
