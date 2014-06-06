import java.awt.Graphics;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public SimpleFrame() {
		
		this.setTitle("SimpleFrame");
		this.setSize(300, 200);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		
		g.drawString("One World One Dream!", 100, 100);
		
		
	}



	public static void main(String[] args) {
		
		new SimpleFrame();

	}

}
