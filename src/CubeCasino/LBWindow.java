package CubeCasino;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class LBWindow {

	private static JFrame leaderBoardWindow;
	private static JButton btnClose;
	private static JTable table;
	private static JScrollPane scrollPane;
	private static JTextField textField_Name;
	private static JButton btnAddMe;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LBWindow lbWindow = new LBWindow();
					lbWindow.leaderBoardWindow.setVisible(true);
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
		leaderBoardWindow.setBounds(300, 300, 581, 442);
		leaderBoardWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leaderBoardWindow.getContentPane().setLayout(null);
		
		btnAddMe = new JButton("Add me!");
		btnAddMe.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		btnAddMe.setBackground(new Color(144, 238, 144));
		btnAddMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeaderBoard.getPlayerData(textField_Name.getText());
				textField_Name.setText("");
				btnAddMe.setEnabled(false);
			}
		});
		btnAddMe.setBounds(181, 359, 126, 25);
		leaderBoardWindow.getContentPane().add(btnAddMe);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		textField_Name.setBounds(69, 358, 99, 25);
		leaderBoardWindow.getContentPane().add(textField_Name);
		textField_Name.setText("player");
		textField_Name.setColumns(10);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leaderBoardWindow.dispose();
				Game.money.moneyCount = 100;
				Window.txtMoney.setText(Game.money.moneyCount + " $");
				Window.Output.setText(Game.rules);
				Window.btnEndGame.setEnabled(true);
				Window.btnLeaderBoard.setEnabled(false);
			}
		});
		btnClose.setBackground(new Color(144, 238, 144));
		btnClose.setBounds(463, 359, 90, 25);
		leaderBoardWindow.getContentPane().add(btnClose);
		
		table = new JTable(LeaderBoard.rowData, LeaderBoard.columnNames);
		table.setRowSelectionAllowed(false);
		table.setBorder(null);
		table.setFont(new Font("Liberation Serif", Font.PLAIN, 17));
		table.setRowHeight(30);
		table.setBackground(new Color(224, 255, 255));
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 583, 323);
        leaderBoardWindow.getContentPane().add(scrollPane);

	}
}
