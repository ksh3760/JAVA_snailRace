package �����̷��̰̽���;
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
	// ������ ���̺�
	static JLabel label1;	
	static JLabel label2;
	static JLabel label3;
	// ������ x��ǥ
	static int x1 = 50, 
			   x2 = 50, 
			   x3 = 50;
	
	// ��ư
	JButton bRecord;	// ��� ����
	JButton start;		// ���� ����
	JButton bCash;		// ����ݾ� ��ȸ
	
	// ����ݾ�
	JLabel currentCash = new JLabel("����ݾ�"); 
	JTextField fCash = new JTextField(10);
	
	// ��ư ���� �� ��ġ
	
	// DB����
	
	
	// ������ ����
	public sFrame() {
		setTitle("SnailRace");
		setSize(1000, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);	// ���� ��ġ�� ���
			
			label1 = new JLabel();
			label1.setIcon(new ImageIcon("a.gif"));
			add(label1);
			
			label2 = new JLabel();
			label2.setIcon(new ImageIcon("b.gif"));
			add(label2);
			
			label3 = new JLabel();
			label3.setIcon(new ImageIcon("c.gif"));		
			add(label3);
			
			// �����ʿ� ����
//			label1.setBounds(100, 0, 100, 100);	
//			label2.setBounds(100, 50, 100, 100);
//			label3.setBounds(100, 100, 100, 100);
			
			
			
// -----------------------------------------------------------------

			
			
			
			// ������ ����
			(new sThread()).start();
			setVisible(true);
	
	}

}
