package 달팽이레이싱게임;
import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	static JTextField tf;
	
	boolean startFlag = false;	// 스레드 시작

	// 배경
//	JLabel bg = new JLabel(new ImageIcon("field.png"));
//	public void backGroung() {
//		bg.setBounds(0, 10, 600, 200);
//		add(bg);
//	}
		
	
	// 버튼 생성 & 배치
	public void bSet() {
		//setLayout(null);	// 절대위치 사용
		
		start = new JButton("시작");
		add(start);
		
		bCash = new JButton("캐쉬 조회");
		add(bCash);
		
		bRecord = new JButton("기록");
		add(bRecord);
		
		uhm = new JButton("엄");
		add(uhm);
		joon = new JButton("준");
		add(joon);
		sik = new JButton("식");
		add(sik);
		
		// 텍스트 필드 생성
		tf = new JTextField("텍스트를 입력");
		add(tf);
		
		// 버튼 위치 지정
		int x = 50;
		int y = 250;
		start.setBounds(x, y, 100, 50);			// 기록 배치
		bCash.setBounds(x+200, y, 120, 50);		// 캐쉬 배치
		bRecord.setBounds(x+400, y, 100, 50);	// 시작 배치
		
		
		uhm.setBounds(x, y+60, 50, 50);
		joon.setBounds(x+50, y+60, 50, 50);
		sik.setBounds(x+100, y+60, 50, 50);
		
		tf.setBounds(x, y+50 + 100, 500, 30);	// 텍스트필드 배치
		
	// 버튼 동작
		
		// 시작
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("시작 버튼을 클릭하셨습니다.");
				startFlag = true;
				
				if(startFlag) {
					(new sThread()).start();
				}
				
				System.out.println("startFlag : " + startFlag);
				System.out.println("-------------------------");
			}
		});
		
		// 캐쉬조회 ******************************************************
		bCash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("캐쉬조회 버튼을 클릭하셨습니다.");
				sDb.ckeckCash();
			}

		});
		
		
		// 기록 *********************************************************
		bRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("기록 버튼을 클릭하셨습니다.");
				
			}
		});
		
		uhm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("엄 버튼을 클릭하셨습니다.");
				
			}
		});
		
		joon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("준 버튼을 클릭하셨습니다.");
				
			}
		});
		
		sik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("식 버튼을 클릭하셨습니다.");
				
			}
		});
		
		
	}// end public void bSet
	
	// 배팅 설정 *****************************************************
	
	
	
	
	// 달팽이 게임
	public sFrame() {
		setTitle("SnailRace");
		setSize(900, 500);
		
		bSet();	// 버튼 배치
		
		//gameActionListener listener = new gameActionListener(this);
		
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
			
			
			//backGroung();	// 배경화면
			
			setVisible(true);
	
	}

}
