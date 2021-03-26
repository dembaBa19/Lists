package lists;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.*;

import javax.swing.JPanel;

class BallPanel extends JPanel {
	private int delay = 10;
	private ArrayList<Ball> list = new ArrayList<Ball>();
// Create a timer with the initial delay
	protected Timer timer = new Timer(delay, new TimerListener());

	private class TimerListener implements ActionListener {
		@Override /** Handle the action event */
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

	public BallPanel() {
		timer.start();
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent a) {
				// TODO Auto-generated method stub
				int x=a.getX();
				int y=a.getY();
				for(int i=0; i<list.size(); i++) {
					Ball ball = (Ball) list.get(i);
					int radiusSum = ball.radius;
					double distance = BallPanel.distance(ball.x, ball.y, x, y);
					
					if(radiusSum>=distance) {
						list.remove(ball);
						break;
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public void add() {
		list.add(new Ball());
	}

	public void subtract() {
		if (list.size() > 0)
			list.remove(list.size() - 1); // Remove the last ball
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i); // Get a ball
			g.setColor(ball.color); // Set ball color
			// Check boundaries
			if(ball.x < 0 + ball.radius) {
				ball.dx=Math.abs(ball.dx);
			}
			if(ball.x > getWidth() - ball.radius) {
				ball.dx = -Math.abs(ball.dx);
			}
			if(ball.y < 0 + ball.radius) {
				ball.dy = Math.abs(ball.dy);
			}
			if(ball.y > getHeight() - ball.radius) {
				ball.dy = - Math.abs(ball.dy);
			}
				
			// Adjust ball position
			ball.x += ball.dx;
			ball.y += ball.dy;
			g.fillOval(ball.x - ball.radius, ball.y - ball.radius, ball.radius * 2, ball.radius * 2);
		}
		
		ArrayList<Ball> ballsToRemove = new ArrayList<>();		
		for(int i=0; i<list.size(); i++) {
			Ball ball = (Ball) list.get(i);
			for(int j=i+1; j<list.size(); j++) {
				Ball ball2 = (Ball) list.get(j);
				Ball ball3, ball4;
				if(ball.radius<ball2.radius) {
					ball3=ball;
					ball4=ball2;
				} else {
					ball3=ball2;
					ball4=ball;
				}
				double radiusMax = ball4.radius;
				double distance = BallPanel.distance(ball.x, ball.y, ball2.x, ball2.y);
				
				if(radiusMax>=distance) {
					ballsToRemove.add(ball3);
					ball4.radius+=ball3.radius/2;
				}
			}
		}
		
		list.removeAll(ballsToRemove);
		
	}

	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(Math.abs(x1-x2), 2) + Math.pow(Math.abs(y1-y2), 2));
	}
	
	public void suspend() {
		timer.stop();
	}

	public void resume() {
		timer.start();
	}

	public void setDelay(int delay) {
		this.delay = delay;
		timer.setDelay(delay);
	}
}