package dataStructures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListGUI {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		
		JFrame frame = new JFrame("Numbers");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		frame.add(mainPanel);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		

		JTextArea numbersArea = new JTextArea();
		
		JTextField enterNumbers = new JTextField();
		enterNumbers.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				int num = Integer.parseInt(enterNumbers.getText());
				if(!list.contains(num)) {
					list.add(num);
				}
				enterNumbers.setText("");
				numbersArea.setText(list.toString());
			}
		});
		mainPanel.add(enterNumbers);
		
		numbersArea.setEditable(false);
		mainPanel.add(numbersArea);
		
		JButton sortButton = new JButton("Sort");
		sortButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Collections.sort(list);
				enterNumbers.setText(list.toString());
			}
		});
		mainPanel.add(sortButton);
		
		JButton reverseButton = new JButton("Reverse Sort");
		reverseButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Collections.sort(list, Collections.reverseOrder());
				enterNumbers.setText(list.toString());
			}
		});
		mainPanel.add(reverseButton);
		
		JButton shuffleButton = new JButton("Shuffle");
		shuffleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Collections.shuffle(list);
				enterNumbers.setText(list.toString());
			}
		});
		mainPanel.add(shuffleButton);
		
		frame.setVisible(true);
	}
	
}
