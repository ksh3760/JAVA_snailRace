package �����̷��̰̽���;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class sFrame extends JFrame {
	// ������ ���̺�
	static JLabel label1;	
	static JLabel label2;
	static JLabel label3;
	// ������ x��ǥ
	static int x1 = 100, 
			   x2 = 100, 
			   x3 = 100;
	
	BufferedImage img = null; // �ʵ� �̹���
	
	

	
	// ������ ����
	public sFrame() {
		setTitle("SnailRace");
		setSize(1000, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);	// ���� ��ġ�� ���
			
			label1 = new JLabel();
			label1.setIcon(new ImageIcon("a.gif"));
			
			label2 = new JLabel();
			label2.setIcon(new ImageIcon("b.gif"));
			
			label3 = new JLabel();
			label3.setIcon(new ImageIcon("c.gif"));
			
			add(label1);
			add(label2);
			add(label3);
			
			// �����ʿ� ����
			label1.setBounds(100, 0, 100, 100);	
			label2.setBounds(100, 50, 100, 100);
			label3.setBounds(100, 100, 100, 100);
			
// -----------------------------------------------------------------

			
			
			(new sThread()).start();
			setVisible(true);
	
	}

}
