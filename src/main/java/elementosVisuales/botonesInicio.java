package elementosVisuales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

public class botonesInicio extends JButton{
	
	Border blackline = BorderFactory.createLineBorder(Color.black);
	
	public botonesInicio(String m) {
		super(m);
		estiloPorDefecto();
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(Color.WHITE);
				setBorder(blackline);
				setFont(new Font("Source Sans Pro", Font.BOLD, 26));
				setSize(125,40);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				estiloPorDefecto();
			}
		});
	}
	
	private void estiloPorDefecto() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.setBorder(blackline);
		this.setFont(new Font("Source Sans Pro", Font.PLAIN, 22));
		this.setForeground(Color.RED);
		setSize(112,32);
	}
}
