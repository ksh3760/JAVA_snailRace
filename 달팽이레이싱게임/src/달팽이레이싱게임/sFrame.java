package 달팽이레이싱게임;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class sFrame extends JFrame {
	// 달팽이 레이블
	static JLabel label1;	
	static JLabel label2;
	static JLabel label3;
	// 달팽이 x좌표
	static int x1 = 50, 
			   x2 = 50, 
			   x3 = 50;
	
	// 버튼
	private JButton bRecord;	// 기록 보기
	private JButton start;		// 게임 시작
	private JButton bCash;		// 현재금액 조회
	
	private JButton uhm;
	private JButton joon;
	private JButton sik;
	
	// 배경
	JLabel bg = new JLabel(new ImageIcon("field.png"));
	
	// 현재금액
	JLabel currentCash = new JLabel("현재금액"); 
	JTextField fCash = new JTextField(10);
	
	public void backGroung() {
//		bg.setBounds(0, 40, 600, 200);
//		add(bg);
	}
	
	
	// 버튼 생성 & 배치
	public void bSet() {
		//setLayout(null);	// 절대위치 사용

		bRecord = new JButton("기록");
		add(bRecord);
		
		start = new JButton("게임 시작");
		add(start);
		
		bCash = new JButton("캐쉬 조회");
		add(bCash);
		
		uhm = new JButton("엄");
		add(uhm);
		joon = new JButton("준");
		add(joon);
		sik = new JButton("식");
		add(sik);
		
		// 버튼 위치 지정
		int x = 50;
		int y = 200;
		bRecord.setBounds(x, y, 100, 50);	// 기록 배치
		bCash.setBounds(x*4, y, 120, 50);	// 캐쉬 배치
		start.setBounds(x*8, y, 100, 50);	// 시작 배치
		
		
		uhm.setBounds(x, y+60, 50, 50);
		joon.setBounds(x, y+115, 50, 50);
		sik.setBounds(x, y+170, 50, 50);
		
		
	}
	
	
	// DB연결
	
	
	
	
	// 달팽이 게임
	public sFrame() {
		setTitle("SnailRace");
		setSize(900, 500);
		
		bSet();	// 버튼 배치
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);	// 절대 위치를 사용
			
			label1 = new JLabel();
			label1.setIcon(new ImageIcon("a.gif"));
			add(label1);
			
			label2 = new JLabel();
			label2.setIcon(new ImageIcon("b.gif"));
			add(label2);
			
			label3 = new JLabel();
			label3.setIcon(new ImageIcon("c.gif"));		
			add(label3);
			
			// 오른쪽에 정렬
//			label1.setBounds(100, 0, 100, 100);	
//			label2.setBounds(100, 50, 100, 100);
//			label3.setBounds(100, 100, 100, 100);
			
			
			
// -----------------------------------------------------------------

			
			
			
			// 스레드 실행
			(new sThread()).start();
			setVisible(true);
	
	}

}
