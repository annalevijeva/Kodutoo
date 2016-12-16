package tests;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class LBWindow {

	private static JFrame leaderBoardWindow;
	private JTextField textField_Name;
	private JButton btnAddMe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LBWindow window = new LBWindow();
					window.leaderBoardWindow.setVisible(true);
					leaderBoardWindow.setTitle("super stars");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public LBWindow() {
		initialize();
	}

	private void initialize() {

		leaderBoardWindow = new JFrame();
		leaderBoardWindow.getContentPane().setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		leaderBoardWindow.getContentPane().setBackground(new Color(185, 255, 250));
		leaderBoardWindow.setBounds(300, 300, 560, 470);
		leaderBoardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leaderBoardWindow.getContentPane().setLayout(null);
		
		btnAddMe = new JButton("Add me!");
		btnAddMe.setBackground(new Color(144, 238, 144));
		btnAddMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_Name.getText();
				textField_Name.setText("");
				btnAddMe.setEnabled(false);
			}
		});
		btnAddMe.setBounds(181, 404, 126, 25);
		leaderBoardWindow.getContentPane().add(btnAddMe);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(70, 404, 99, 25);
		leaderBoardWindow.getContentPane().add(textField_Name);
		textField_Name.setText("player");
		textField_Name.setColumns(10);
		
		JTextArea textArea_prKey = new JTextArea();
		textArea_prKey.setBackground(new Color(224, 255, 255));
		textArea_prKey.setEditable(false);
		textArea_prKey.setBounds(12, 43, 46, 349);
		leaderBoardWindow.getContentPane().add(textArea_prKey);
		
		JTextArea textArea_Name = new JTextArea();
		textArea_Name.setEditable(false);
		textArea_Name.setBounds(70, 43, 99, 349);
		leaderBoardWindow.getContentPane().add(textArea_Name);
		
		JTextArea textArea_Rates = new JTextArea();
		textArea_Rates.setEditable(false);
		textArea_Rates.setBounds(181, 43, 72, 349);
		leaderBoardWindow.getContentPane().add(textArea_Rates);
		
		JTextArea textArea_Won = new JTextArea();
		textArea_Won.setBounds(265, 43, 72, 349);
		leaderBoardWindow.getContentPane().add(textArea_Won);
		
		JTextArea textArea_Profit = new JTextArea();
		textArea_Profit.setBounds(349, 43, 99, 349);
		leaderBoardWindow.getContentPane().add(textArea_Profit);
		
		JTextArea textArea_Date = new JTextArea();
		textArea_Date.setBounds(460, 43, 98, 349);
		leaderBoardWindow.getContentPane().add(textArea_Date);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(70, 12, 99, 25);
		leaderBoardWindow.getContentPane().add(lblName);
		
		JLabel lblRates = new JLabel("Rates");
		lblRates.setBounds(181, 17, 72, 15);
		leaderBoardWindow.getContentPane().add(lblRates);
		
		JLabel lblWon = new JLabel("Won");
		lblWon.setBounds(267, 17, 70, 15);
		leaderBoardWindow.getContentPane().add(lblWon);
		
		JLabel lblProfit = new JLabel("Profit");
		lblProfit.setBounds(355, 17, 70, 15);
		leaderBoardWindow.getContentPane().add(lblProfit);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(460, 17, 70, 15);
		leaderBoardWindow.getContentPane().add(lblDate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leaderBoardWindow.dispose();
			}
		});
		btnClose.setBackground(new Color(144, 238, 144));
		btnClose.setBounds(470, 404, 90, 25);
		leaderBoardWindow.getContentPane().add(btnClose);

	}
}
