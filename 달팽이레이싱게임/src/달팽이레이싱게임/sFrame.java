package �����̷��̰̽���;
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
	
	static JTextField tf;
	
	boolean startFlag = false;	// ������ ����

	// ���
//	JLabel bg = new JLabel(new ImageIcon("field.png"));
//	public void backGroung() {
//		bg.setBounds(0, 10, 600, 200);
//		add(bg);
//	}
		
	
	// ��ư ���� & ��ġ
	public void bSet() {
		//setLayout(null);	// ������ġ ���
		
		start = new JButton("����");
		add(start);
		
		bCash = new JButton("ĳ�� ��ȸ");
		add(bCash);
		
		bRecord = new JButton("���");
		add(bRecord);
		
		uhm = new JButton("��");
		add(uhm);
		joon = new JButton("��");
		add(joon);
		sik = new JButton("��");
		add(sik);
		
		// �ؽ�Ʈ �ʵ� ����
		tf = new JTextField("�ؽ�Ʈ�� �Է�");
		add(tf);
		
		// ��ư ��ġ ����
		int x = 50;
		int y = 250;
		start.setBounds(x, y, 100, 50);			// ��� ��ġ
		bCash.setBounds(x+200, y, 120, 50);		// ĳ�� ��ġ
		bRecord.setBounds(x+400, y, 100, 50);	// ���� ��ġ
		
		
		uhm.setBounds(x, y+60, 50, 50);
		joon.setBounds(x+50, y+60, 50, 50);
		sik.setBounds(x+100, y+60, 50, 50);
		
		tf.setBounds(x, y+50 + 100, 500, 30);	// �ؽ�Ʈ�ʵ� ��ġ
		
	// ��ư ����
		
		// ����
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("���� ��ư�� Ŭ���ϼ̽��ϴ�.");
				startFlag = true;
				
				if(startFlag) {
					(new sThread()).start();
				}
				
				System.out.println("startFlag : " + startFlag);
				System.out.println("-------------------------");
			}
		});
		
		// ĳ����ȸ ******************************************************
		bCash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ĳ����ȸ ��ư�� Ŭ���ϼ̽��ϴ�.");
				sDb.ckeckCash();
			}

		});
		
		
		// ��� *********************************************************
		bRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��� ��ư�� Ŭ���ϼ̽��ϴ�.");
				
			}
		});
		
		uhm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ��ư�� Ŭ���ϼ̽��ϴ�.");
				
			}
		});
		
		joon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ��ư�� Ŭ���ϼ̽��ϴ�.");
				
			}
		});
		
		sik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ��ư�� Ŭ���ϼ̽��ϴ�.");
				
			}
		});
		
		
	}// end public void bSet
	
	// ���� ���� *****************************************************
	
	
	
	
	// ������ ����
	public sFrame() {
		setTitle("SnailRace");
		setSize(900, 500);
		
		bSet();	// ��ư ��ġ
		
		//gameActionListener listener = new gameActionListener(this);
		
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
			
			
			//backGroung();	// ���ȭ��
			
			setVisible(true);
	
	}

}
