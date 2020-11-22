package ¥ﬁ∆ÿ¿Ã∑π¿ÃΩÃ∞‘¿”;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.fillRect(10, 10, 30, 30);
	}
}
