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
	private JButton bRecord;	// ��� ����
	private JButton start;		// ���� ����
	private JButton bCash;		// ����ݾ� ��ȸ
	
	private JButton uhm;
	private JButton joon;
	private JButton sik;
	
	// ���
	JLabel bg = new JLabel(new ImageIcon("field.png"));
	
	// ����ݾ�
	JLabel currentCash = new JLabel("����ݾ�"); 
	JTextField fCash = new JTextField(10);
	
	public void backGroung() {
//		bg.setBounds(0, 40, 600, 200);
//		add(bg);
	}
	
	
	// ��ư ���� & ��ġ
	public void bSet() {
		//setLayout(null);	// ������ġ ���

		bRecord = new JButton("���");
		add(bRecord);
		
		start = new JButton("���� ����");
		add(start);
		
		bCash = new JButton("ĳ�� ��ȸ");
		add(bCash);
		
		uhm = new JButton("��");
		add(uhm);
		joon = new JButton("��");
		add(joon);
		sik = new JButton("��");
		add(sik);
		
		// ��ư ��ġ ����
		int x = 50;
		int y = 200;
		bRecord.setBounds(x, y, 100, 50);	// ��� ��ġ
		bCash.setBounds(x*4, y, 120, 50);	// ĳ�� ��ġ
		start.setBounds(x*8, y, 100, 50);	// ���� ��ġ
		
		
		uhm.setBounds(x, y+60, 50, 50);
		joon.setBounds(x, y+115, 50, 50);
		sik.setBounds(x, y+170, 50, 50);
		
		
	}
	
	
	// DB����
	
	
	
	
	// ������ ����
	public sFrame() {
		setTitle("SnailRace");
		setSize(900, 500);
		
		bSet();	// ��ư ��ġ
		
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
