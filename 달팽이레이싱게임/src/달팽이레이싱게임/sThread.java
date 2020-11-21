package 달팽이레이싱게임;

public class sThread extends Thread {
	
	public void run() {
		for(int i = 0 ; i < 120 ; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			sFrame.x1 += (int)(Math.random() * 10);	// 0.1초에 한번씩 변경
			sFrame.label1.setBounds(sFrame.x1, 0, 100, 100);
			
			sFrame.x2 += (int)(Math.random() * 10);
			sFrame.label2.setBounds(sFrame.x2, 50, 100, 100);
			
			sFrame.x3 += (int)(Math.random() * 10);
			sFrame.label3.setBounds(sFrame.x3, 100, 100, 100);
		}
	}
}
