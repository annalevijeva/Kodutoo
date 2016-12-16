package tests;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JTable;
//import java.awt.BorderLayout;
//import javax.swing.JMenuBar;
import javax.swing.JTextField;
//import javax.swing.JTextPane;
import javax.swing.JLabel;
//import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GUI {

	private static JFrame frame;
	private static JFrame leaderBoard;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					frame.setTitle("lol project");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public GUI() {
		initialize();
	}
	
	private void initialize() {

		leaderBoard = new JFrame();
		leaderBoard.getContentPane().setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		leaderBoard.getContentPane().setBackground(new Color(185, 255, 250));
		leaderBoard.setBounds(300, 300, 570, 400);
		leaderBoard.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		leaderBoard.getContentPane().setLayout(null);

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(185, 255, 250));
		frame.setBounds(100, 100, 572, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnLeaderBoard = new JButton("Leader board");
		btnLeaderBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LBWindow lbWindow = new LBWindow();
				lbWindow.main(null);
				
			}
		});
		btnLeaderBoard.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		btnLeaderBoard.setBackground(new Color(72, 209, 204));
		btnLeaderBoard.setBounds(187, 377, 174, 25);
		frame.getContentPane().add(btnLeaderBoard);

	}
}
