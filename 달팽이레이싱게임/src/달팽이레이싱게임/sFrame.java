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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class sFrame extends JFrame {
	
	// ������ ���̺�
	static JLabel label1;	
	static JLabel label2;
	static JLabel label3;
	
	// ������ x��ǥ
	static int x1, x2, x3  = 50;

	
	// ���� ����
	static String betting;		// ���� Ȯ���� ���� ���� (1:��, 2:��, 3:��)
	boolean isWin = false;		// ���ÿ� ���� �Ͽ����� Ȯ���� ���� ����
	
	// ��ư
	private JButton bRecord;	// ��� ����
	private JButton start;		// ���� ����
	private JButton bCash;		// ����ݾ� ��ȸ
	
	private JButton uhm;		// ��ư ��
	private JButton joon;		// ��ư ��
	private JButton sik;		// ��ư ��
	
	static JTextField tf;		// �ؽ�Ʈ �ʵ�
	
	boolean startFlag = false;			// ������ ����
	static boolean isStart   = true;	// ���۹�ư �ߺ� Ŭ�� ����
	static boolean isBetted  = false;	// ������ �ߴ��� Ȯ���� ���� ����
	
	
// ��� ��ġ   *************************************************************
	JLabel bg = new JLabel(new ImageIcon("bg1.png"));
	public void backGroung() {
		bg.setBounds(0, 0, 900, 460);
		add(bg);
	}
		
	
// ��ư ���� & ��ġ  *************************************************************
	public void bSet() {
		//setLayout(null);	// ������ġ ���
		
		start = new JButton("����");
		add(start);
		
		bCash = new JButton("ĳ�� ��ȸ");
		add(bCash);
		
		bRecord = new JButton("�����ȸ");
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
		
// ��ư ���� ******************************************************************
		
		// ���� ��ư�� ������ ��
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isBetted) {	// ������ ���� �Ͽ����� Ȯ���Ѵ�.
					if(isStart) {	// ���۹�ư�� �� ������ �������� ���ϰ� �Ѵ�.
						System.out.println("���� ��ư�� Ŭ���ϼ̽��ϴ�.");
						startFlag = true;
						isStart = false;
						
						if(startFlag) {
							(new sThread()).start();
						}
						
						System.out.println("startFlag : " + startFlag);
						System.out.println("------------------------------");
					} else {
						System.out.println("�̹� �����Ͽ����ϴ�.");
						tf.setText("�̹� ���� �Ͽ����ϴ�.");
					}	
				} else {
					tf.setText("���� ������ �ؾ� �մϴ�.");
				}		
			}	
		});
		
		// ĳ����ȸ  ��ư�� ������ ��
		bCash.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ĳ����ȸ ��ư�� Ŭ���ϼ̽��ϴ�.");
				sDb.ckeckCash();
			}

		});
		
		
		// �����ȸ ��ư�� ������ ��
		bRecord.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�����ȸ ��ư�� Ŭ���ϼ̽��ϴ�.");
				
				recordFrame rFrame = new recordFrame();
				
			}
		});
		
		
		// �� ��ư�� ������ ��
		uhm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ��ư�� Ŭ���ϼ̽��ϴ�.");
			
				if(isBetted) {
					System.out.println("�̹� ���� �Ͽ����ϴ�.");
					tf.setText("�̹� ���� �Ͽ����ϴ�.");
				} else {
					// ������ ����� �Ͽ����� Ȯ���Ѵ�.
					int result = JOptionPane.showConfirmDialog(null, 
								 "'��'�� ���� �Ͻðڽ��ϱ�?", 
								 "Confirm", 
								 JOptionPane.YES_NO_OPTION);
				
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("â�� �ݾҽ��ϴ�.");
					} else 
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("'��'�� ���� �Ͽ����ϴ�.");
						betting = "��";
						isBetted = true;
						System.out.println("betting : " + betting);
					} else {
						tf.setText("����Ͽ����ϴ�.");
					}	
				}
				

			}
		});// end uhm.addActionListener
		
		
		// �� ��ư�� ������ ��
		joon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ��ư�� Ŭ���ϼ̽��ϴ�.");
				
				if(isBetted) {
					System.out.println("�̹� ���� �Ͽ����ϴ�.");
					tf.setText("�̹� ���� �Ͽ����ϴ�.");
				} else {
					// ������ ����� �Ͽ����� Ȯ���Ѵ�.
					int result = JOptionPane.showConfirmDialog(null, 
								 "'��'�� ���� �Ͻðڽ��ϱ�?", 
								 "Confirm", 
								 JOptionPane.YES_NO_OPTION);
				
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("â�� �ݾҽ��ϴ�.");
					} else 
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("'��'�� ���� �Ͽ����ϴ�.");
						betting = "��";
						isBetted = true;
						System.out.println("betting : " + betting);
					} else {
						tf.setText("����Ͽ����ϴ�.");
					}	
				}
				
			}
		});// end joon.addActionListener
		
		
		// �� ��ư�� ������ ��
		sik.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("�� ��ư�� Ŭ���ϼ̽��ϴ�.");
				
				if(isBetted) {
					System.out.println("�̹� ���� �Ͽ����ϴ�.");
					tf.setText("�̹� ���� �Ͽ����ϴ�.");
				} else {
					// ������ ����� �Ͽ����� Ȯ���Ѵ�.
					int result = JOptionPane.showConfirmDialog(null, 
								 "'��'�� ���� �Ͻðڽ��ϱ�?", 
								 "Confirm", 
								 JOptionPane.YES_NO_OPTION);
				
					if(result == JOptionPane.CLOSED_OPTION) {
						tf.setText("â�� �ݾҽ��ϴ�.");
					} else 
					if(result == JOptionPane.YES_OPTION) {
						tf.setText("'��'�� ���� �Ͽ����ϴ�.");
						betting = "��";
						isBetted = true;
						System.out.println("betting : " + betting);
					} else {
						tf.setText("����Ͽ����ϴ�.");
					}
				}

			}
		});// end sik.addActionListener
		
		
	}// end public void bSet
	
	
// ������ ���� ������ ************************************************************
	public sFrame() {
		setTitle("���ؽ� ������ ���̽�");
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

			
			
			backGroung();	// ���ȭ��
			
			setVisible(true);
	
	}


}
