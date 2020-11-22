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
	JButton bRecord;	// 기록 보기
	JButton start;		// 게임 시작
	JButton bCash;		// 현재금액 조회
	
	// 현재금액
	JLabel currentCash = new JLabel("현재금액"); 
	JTextField fCash = new JTextField(10);
	
	// 버튼 생성 후 배치
	
	// DB연결
	
	
	// 달팽이 게임
	public sFrame() {
		setTitle("SnailRace");
		setSize(1000, 500);
		
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
