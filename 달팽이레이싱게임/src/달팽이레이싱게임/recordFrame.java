package 달팽이레이싱게임;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class recordFrame extends JFrame {
	
	private static final int ROWS = 100;
	private static final int COLS = 3;
	
	public static String[][] contents = new String[ROWS][COLS];
	
	
	public recordFrame() {
		Dimension dim = new Dimension(400,150);
		
		setTitle("경기 기록");
		setSize(500, 300);
		

		
		String header[] = {"회차", "시간", "결과"};	
		
		// DB로 부터 게임 기록을 불러온다.
		sDb.gameRecord();
		
		JTable t = new JTable(contents, header);
		JScrollPane sp = new JScrollPane(t);
		add(sp);
		setVisible(true);
		
		

	}


}
