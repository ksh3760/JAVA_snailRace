//package 달팽이레이싱게임;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JPanel;
//
//public class sPanel extends JPanel implements ActionListener {
//	// 버튼
//	static JButton bRecord;		// 기록 보기
//	static JButton start;		// 게임 시작
//	static JButton bCash;		// 현재금액 조회
//	
//	static JButton uhm;
//	static JButton joon;
//	static JButton sik;
//
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		// 시작(start) 버튼 눌렀을 때 run
//		
//	}
//
//	
//	// 버튼 생성 & 배치
//	public void bSet() {
//		//setLayout(null);	// 절대위치 사용
//
//		bRecord = new JButton("기록");
//		add(bRecord);
//		
//		start = new JButton("게임 시작");
//		add(start);
//		
//		bCash = new JButton("캐쉬 조회");
//		add(bCash);
//		
//		uhm = new JButton("엄");
//		add(uhm);
//		joon = new JButton("준");
//		add(joon);
//		sik = new JButton("식");
//		add(sik);
//		
//		// 버튼 위치 지정
//		int x = 50;
//		int y = 200;
//		bRecord.setBounds(x, y, 100, 50);	// 기록 배치
//		bCash.setBounds(x*4, y, 120, 50);	// 캐쉬 배치
//		start.setBounds(x*8, y, 100, 50);	// 시작 배치
//		
//		
//		uhm.setBounds(x, y+60, 50, 50);
//		joon.setBounds(x, y+115, 50, 50);
//		sik.setBounds(x, y+170, 50, 50);
//		
//		
//	}
//
//}
