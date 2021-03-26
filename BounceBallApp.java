package lists;

import javax.swing.*;

public class BounceBallApp {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1500, 800);
		frame.add(new BallControl());
		frame.setTitle("Bouncy");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
