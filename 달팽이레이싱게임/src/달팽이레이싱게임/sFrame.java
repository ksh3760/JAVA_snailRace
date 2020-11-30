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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class sFrame extends JFrame {
	
	// 달팽이 레이블
	static JLabel label1;	
	static JLabel label2;
	static JLabel label3;
	
	// 달팽이 x좌표
	static int x1, x2, x3  = 50;

	
	// 베팅 여부
	static String betting;		// 베팅 확인을 위한 변수 (1:엄, 2:준, 3:식)
	boolean isWin = false;		// 베팅에 성공 하였는지 확인을 위한 변수
	
	// 버튼
	private JButton bRecord;	// 기록 보기
	private JButton start;		// 게임 시작
	private JButton bCash;		// 현재금액 조회
	
	private JButton uhm;		// 버튼 엄
	private JButton joon;		// 버튼 준
	private JButton sik;		// 버튼 식
	
	static JTextField tf;		// 텍스트 필드
	
	boolean startFlag = false;			// 스레드 시작
	static boolean isStart   = true;	// 시작버튼 중복 클릭 방지
	static boolean isBetted  = false;	// 베팅을 했는지 확인을 위한 변수
	
	static boolean isAlive = true;	// 사용자의 목숨을 확인하는 변수
	
// 배경 배치   *************************************************************
	JLabel bg = new JLabel(new ImageIcon("bg1.png"));
	public void backGroung() {
		bg.setBounds(0, 0, 900, 460);
		add(bg);
	}
		
	
// 버튼 생성 & 배치  *************************************************************
	public void bSet() {
		//setLayout(null);	// 절대위치 사용
		
		start = new JButton("시작");
		add(start);
		
		bCash = new JButton("캐쉬 조회");
		add(bCash);
		
		bRecord = new JButton("기록조회");
		add(bRecord);
		
		uhm = new JButton("엄");
		add(uhm);
		joon = new JButton("준");
		add(joon);
		sik = new JButton("식");
		add(sik);
		
		// 텍스트 필드 생성
		tf = new JTextField("★엄준식 달팽이 게임★");
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
		
// 버튼 동작 ******************************************************************
		
		// 시작 버튼을 눌렀을 때
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				// 시작 전 유저가 보유한 캐쉬를 확인한다.
				sDb.ckeckCash();
				if(Integer.parseInt(sDb.bCash) < 1) {	// 캐쉬가 0일 시 게임을 못하게 한다.
					isAlive = false;
					sDb.userDead();
				}
				
				if(isAlive) {
					if(isBetted) {	// 베팅을 먼저 하였는지 확인한다.
						if(isStart) {	// 시작버튼을 또 눌러서 동작하지 못하게 한다.
							System.out.println("시작 버튼을 클릭하셨습니다.");
							startFlag = true;
							isStart = false;
							
							if(startFlag) {
								(new sThread()).start();
							}
							
							System.out.println("startFlag : " + startFlag);
							System.out.println("------------------------------");
						} else {
							System.out.println("이미 시작하였습니다.");
							tf.setText("이미 시작 하였습니다.");
						}	
					} else {
						tf.setText("먼저 베팅을 해야 합니다.");
					}		
				} else {
					System.out.println("사용자 목숨이 0입니다.");
					tf.setText("사용자 목숨이 0이므로 시작할 수 없습니다.");
				}
			}
		});
		
		// 캐쉬조회  버튼을 눌렀을 때
		bCash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("캐쉬조회 버튼을 클릭하셨습니다.");
				sDb.ckeckCash();
			}

		});
		
		
		// 기록조회 버튼을 눌렀을 때
		bRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("기록조회 버튼을 클릭하셨습니다.");
				
				recordFrame rFrame = new recordFrame();
				
			}
		});
		
		
		// 엄 버튼을 눌렀을 떄
		uhm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("엄 버튼을 클릭하셨습니다.");
			
				if(isBetted) {
					System.out.println("이미 베팅 하였습니다.");
					tf.setText("이미 베팅 하였습니다.");
				} else {
					// 베팅을 제대로 하였는지 확인한다.
					int result = JOptionPane.showConfirmDialog(null, 
								 "'엄'에 베팅 하시겠습니까?", 
								 "Confirm", 
								 JOptionPane.YES_NO_OPTION);
				
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("창을 닫았습니다.");
					} else 
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("'엄'에 베팅 하였습니다.");
						betting = "엄";
						isBetted = true;
						System.out.println("betting : " + betting);
					} else {
						tf.setText("취소하였습니다.");
					}	
				}
				

			}
		});// end uhm.addActionListener
		
		
		// 준 버튼을 눌렀을 때
		joon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("준 버튼을 클릭하셨습니다.");
				
				if(isBetted) {
					System.out.println("이미 베팅 하였습니다.");
					tf.setText("이미 베팅 하였습니다.");
				} else {
					// 베팅을 제대로 하였는지 확인한다.
					int result = JOptionPane.showConfirmDialog(null, 
								 "'준'에 베팅 하시겠습니까?", 
								 "Confirm", 
								 JOptionPane.YES_NO_OPTION);
				
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("창을 닫았습니다.");
					} else 
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("'준'에 베팅 하였습니다.");
						betting = "준";
						isBetted = true;
						System.out.println("betting : " + betting);
					} else {
						tf.setText("취소하였습니다.");
					}	
				}
				
			}
		});// end joon.addActionListener
		
		
		// 식 버튼을 눌렀을 때
		sik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("식 버튼을 클릭하셨습니다.");
				
				if(isBetted) {
					System.out.println("이미 베팅 하였습니다.");
					tf.setText("이미 베팅 하였습니다.");
				} else {
					// 베팅을 제대로 하였는지 확인한다.
					int result = JOptionPane.showConfirmDialog(null, 
								 "'식'에 베팅 하시겠습니까?", 
								 "Confirm", 
								 JOptionPane.YES_NO_OPTION);
				
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("창을 닫았습니다.");
					} else 
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("'식'에 베팅 하였습니다.");
						betting = "식";
						isBetted = true;
						System.out.println("betting : " + betting);
					} else {
						tf.setText("취소하였습니다.");
					}
				}

			}
		});// end sik.addActionListener
		
		
	}// end public void bSet
	
	
// 달팽이 게임 프레임 ************************************************************
	public sFrame() {
		setTitle("★엄준식 달팽이 레이싱 게임★");
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

			
			
			backGroung();	// 배경화면
			
			setVisible(true);
	
	}


}
