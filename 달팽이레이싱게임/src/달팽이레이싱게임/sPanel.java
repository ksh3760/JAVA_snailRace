//package �����̷��̰̽���;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JPanel;
//
//public class sPanel extends JPanel implements ActionListener {
//	// ��ư
//	static JButton bRecord;		// ��� ����
//	static JButton start;		// ���� ����
//	static JButton bCash;		// ����ݾ� ��ȸ
//	
//	static JButton uhm;
//	static JButton joon;
//	static JButton sik;
//
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		// ����(start) ��ư ������ �� run
//		
//	}
//
//	
//	// ��ư ���� & ��ġ
//	public void bSet() {
//		//setLayout(null);	// ������ġ ���
//
//		bRecord = new JButton("���");
//		add(bRecord);
//		
//		start = new JButton("���� ����");
//		add(start);
//		
//		bCash = new JButton("ĳ�� ��ȸ");
//		add(bCash);
//		
//		uhm = new JButton("��");
//		add(uhm);
//		joon = new JButton("��");
//		add(joon);
//		sik = new JButton("��");
//		add(sik);
//		
//		// ��ư ��ġ ����
//		int x = 50;
//		int y = 200;
//		bRecord.setBounds(x, y, 100, 50);	// ��� ��ġ
//		bCash.setBounds(x*4, y, 120, 50);	// ĳ�� ��ġ
//		start.setBounds(x*8, y, 100, 50);	// ���� ��ġ
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
