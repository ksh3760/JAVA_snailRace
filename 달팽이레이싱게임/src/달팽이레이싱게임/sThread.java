package 달팽이레이싱게임;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class sThread extends Thread {
	
	static String winSnail = "";		// 이긴 달팽이를 확인하는 변수 (1:엄, 2:준, 3:식)
	static String sTime;		// 경기 시간을 기록하는 변
	
	public void run() {			// 왼쪽에 정렬
		
		cTime();
		System.out.println(" 시작");
		System.out.println("------------------------------");
		
		// 위치 초기화
		sFrame.x1 = 100;
		sFrame.x2 = 100;
		sFrame.x3 = 100;
		sFrame.label1.setBounds(100, 0, 100, 100);	
		sFrame.label2.setBounds(100, 50, 100, 100);
		sFrame.label3.setBounds(100, 100, 100, 100);
		
		for(int i = 0 ; i < 300 ; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sFrame.x1 += (int)(Math.random() * 5);	// 0.1초에 한번씩 변경
			sFrame.label1.setBounds(sFrame.x1, 0, 100, 100);
			
			sFrame.x2 += (int)(Math.random() * 5);
			sFrame.label2.setBounds(sFrame.x2, 50, 100, 100);
			
			sFrame.x3 += (int)(Math.random() * 5);
			sFrame.label3.setBounds(sFrame.x3, 100, 100, 100);
		}
		
	// 순위 결정
		if(sFrame.x1 > sFrame.x2 && sFrame.x1 > sFrame.x3) {
			System.out.println("1등 : 엄");
			sFrame.tf.setText("1등 : 엄");
			winSnail = "엄";
			
		} else 
		if(sFrame.x2 > sFrame.x1 && sFrame.x2 > sFrame.x3) {
			System.out.println("1등 : 준");
			sFrame.tf.setText("1등 : 준");
			winSnail = "준";
			
		} else {
			System.out.println("1등 : 식");
			sFrame.tf.setText("1등 : 식");
			winSnail = "식";
		}
		
	// 경기가 끝났을 때 시작버튼을 누르면 다시 동작하게 한다.
		sFrame.isStart = true;	
	// 경기가 끝났을 때 다시 베팅을 할 수 있게 한다.
		sFrame.isBetted = false; 
		
		// 베팅 결과
		if (winSnail.equals(sFrame.betting)) {
			System.out.println("[예측 성공] 나: " + sFrame.betting + ", 결과: " + winSnail);
			sDb.winBetting();	// 캐쉬 업데이트 +1
			
		} else {
			System.out.println("[예측 실패] 나:" + sFrame.betting + ", 결과: " + winSnail);
			sDb.loseBetting();; // 캐쉬 업데이트 -1
			
		}

		// 경기 결과 업데이트
		sDb.updateGameRecord();

	}// end public void run
	
	
	// 시간 기록
	public void cTime() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date dTime = new Date();		
		sTime = format1.format(dTime);			
		System.out.print(sTime);
	}
	
	
}
