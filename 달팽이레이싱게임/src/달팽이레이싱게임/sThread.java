package �����̷��̰̽���;

import java.text.SimpleDateFormat;
import java.util.Date;

public class sThread extends Thread {
	
	public void run() {		// ���ʿ� ����
		
		cTime();
		System.out.println(" ����");
		System.out.println("-------------------------");
		
		// ��ġ �ʱ�ȭ
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
			
			sFrame.x1 += (int)(Math.random() * 5);	// 0.1�ʿ� �ѹ��� ����
			sFrame.label1.setBounds(sFrame.x1, 0, 100, 100);
			
			sFrame.x2 += (int)(Math.random() * 5);
			sFrame.label2.setBounds(sFrame.x2, 50, 100, 100);
			
			sFrame.x3 += (int)(Math.random() * 5);
			sFrame.label3.setBounds(sFrame.x3, 100, 100, 100);
		}
		
	// ���� ����
		if(sFrame.x1 > sFrame.x2 && sFrame.x1 > sFrame.x3) {
			System.out.println("1�� : ��");
		} else 
		if(sFrame.x2 > sFrame.x1 && sFrame.x2 > sFrame.x3) {
			System.out.println("1�� : ��");
		} else {
			System.out.println("1�� : ��");
		}

	}
	
	// �ð� ���
	public void cTime() {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
		Date dTime = new Date();		
		String sTime = format1.format(dTime);			
		System.out.print(sTime);
	}
	
	
}
