package 달팽이레이싱게임;

public class sThread extends Thread {
	
	public void run() {
		
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
		} else 
		if(sFrame.x2 > sFrame.x1 && sFrame.x2 > sFrame.x3) {
			System.out.println("1등 : 준");
		} else {
			System.out.println("1등 : 식");
		}
		
	// 재배치
		// 왼쪽에 정렬
		sFrame.label1.setBounds(100, 0, 100, 100);	
		sFrame.label2.setBounds(100, 50, 100, 100);
		sFrame.label3.setBounds(100, 100, 100, 100);
		// x좌표 초기화
		sFrame.x1 = 100;
		sFrame.x2 = 100;
		sFrame.x3 = 100;
		
	}
	
}
