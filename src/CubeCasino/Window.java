package CubeCasino;

import java.awt.EventQueue;

import javax.swing.JFrame;
//import javax.swing.JTable;
//import java.awt.BorderLayout;
//import javax.swing.JMenuBar;
import javax.swing.JTextField;
//import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTable;
//import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Window {

	private static JFrame frame;
	static JTextArea txtMoney;
	private JTextField textField_MoneyRate;
	private JTextField textField_CubeRate;
	static JTextArea Output;
	private JLabel lblImg;
	private JLabel lblMoneyCount;
	private JLabel lblMoneyRate;
	private JLabel lblCubeRate;
	static JButton btnEndGame;
	private JButton btnDropCube;
	static JButton btnLeaderBoard;
	private JButton btnVaBanque;
	private JButton btnRules;

	int randomCubeValue = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
					frame.setTitle("lol project");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(185, 255, 250));
		frame.setBounds(100, 100, 572, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtMoney = new JTextArea();
		txtMoney.setBackground(new Color(224, 255, 255));
		txtMoney.setFont(new Font("Liberation Serif", Font.ITALIC, 20));
		txtMoney.setBounds(12, 51, 101, 25);
		txtMoney.setEditable(false);
		txtMoney.setText(Game.money.moneyCount + " $");
		frame.getContentPane().add(txtMoney);
		txtMoney.setColumns(10);

		lblMoneyCount = new JLabel("Money:");
		lblMoneyCount.setBounds(12, 12, 70, 30);
		lblMoneyCount.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		frame.getContentPane().add(lblMoneyCount);

		lblMoneyRate = new JLabel("Money rate:");
		lblMoneyRate.setBounds(12, 150, 101, 30);
		lblMoneyRate.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		frame.getContentPane().add(lblMoneyRate);

		lblCubeRate = new JLabel("Cube rate:");
		lblCubeRate.setBounds(137, 150, 101, 30);
		lblCubeRate.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		frame.getContentPane().add(lblCubeRate);

		textField_MoneyRate = new JTextField();
		textField_MoneyRate.setBounds(12, 187, 114, 30);
		frame.getContentPane().add(textField_MoneyRate);
		textField_MoneyRate.setColumns(10);

		textField_CubeRate = new JTextField();
		textField_CubeRate.setBounds(147, 187, 114, 30);
		frame.getContentPane().add(textField_CubeRate);
		textField_CubeRate.setColumns(10);

		btnDropCube = new JButton("Drop cube!");
		btnDropCube.setBackground(new Color(144, 238, 144));
		btnDropCube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DropCubeBtn();
			}
		});
		btnDropCube.setBounds(68, 277, 149, 75);
		btnDropCube.setFont(new Font("Liberation Serif", Font.PLAIN, 25));
		frame.getContentPane().add(btnDropCube);

		Output = new JTextArea();
		Output.setBackground(new Color(224, 255, 255));
		Output.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		Output.setBounds(273, 22, 271, 260);
		Output.setEditable(false);
		Output.setText(Game.rules);
		frame.getContentPane().add(Output);
		Output.setColumns(10);
		
		btnLeaderBoard = new JButton("Leader board");
		btnLeaderBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LBWindow lbWindow = new LBWindow();
				lbWindow.main(null);
			}
		});
		btnLeaderBoard.setFont(new Font("Liberation Serif", Font.BOLD, 20));
		btnLeaderBoard.setBackground(new Color(72, 209, 204));
		btnLeaderBoard.setBounds(187, 377, 174, 25);
		btnLeaderBoard.setEnabled(false);
		frame.getContentPane().add(btnLeaderBoard);

		btnEndGame = new JButton("End game");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameOver();
				btnLeaderBoard.setEnabled(true);
			}
		});
		btnEndGame.setBackground(new Color(144, 238, 144));
		btnEndGame.setBounds(331, 327, 132, 25);
		btnEndGame.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		frame.getContentPane().add(btnEndGame);

		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(Window.class.getResource("/CubeCasino/side00.png")));
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setBounds(131, 22, 100, 100);
		frame.getContentPane().add(lblImg);

		btnRules = new JButton("Rules");
		btnRules.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Output.setText(Game.rules);
			}
		});
		btnRules.setBackground(new Color(144, 238, 144));
		btnRules.setBounds(331, 297, 132, 25);
		frame.getContentPane().add(btnRules);

		btnVaBanque = new JButton("Va banque");
		btnVaBanque.setFont(new Font("Liberation Serif", Font.PLAIN, 20));
		btnVaBanque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_MoneyRate.setText(Game.money.moneyCount + "");
			}
		});
		btnVaBanque.setBackground(new Color(144, 238, 144));
		btnVaBanque.setBounds(68, 242, 149, 25);
		frame.getContentPane().add(btnVaBanque);

	}

	void gameOver() {
		Output.setText(Game.OUTPUT_EndGame());
		
		txtMoney.setText(Game.money.moneyCount + " $");
		textField_CubeRate.setText("");
		textField_MoneyRate.setText("");
		btnEndGame.setEnabled(false);
		btnDropCube.setEnabled(true);
		lblImg.setIcon(new ImageIcon(Window.class.getResource("/CubeCasino/side00.png")));

	}

	static int GetIntFromTextField(JTextField field) {
		return Integer.parseInt(field.getText());
	}

	void DropCubeBtn() {
		int mRate = GetIntFromTextField(textField_MoneyRate);
		int cRate = GetIntFromTextField(textField_CubeRate);

		if (Game.money.checkRate(mRate) && Game.cube.checkRate(cRate)) {

			Game.money.makeRate(mRate);
			randomCubeValue = Game.cube.dropCube();

			btnEndGame.setEnabled(true);
			btnDropCube.setEnabled(true);
			lblImg.setIcon(new ImageIcon(Window.class.getResource("/CubeCasino/side" + randomCubeValue + ".png")));

			if (cRate == randomCubeValue) {
				Game.money.ifWon(mRate);
				txtMoney.setText(Game.money.moneyCount + " $");
				Output.setText(Game.OUTPUT_YouWon(randomCubeValue, mRate));
			} else {
				txtMoney.setText(Game.money.moneyCount + " $");
				Output.setText(Game.OUTPUT_YouLost(randomCubeValue, mRate));
			}

		} else if (Game.money.moneyCount == 0) {
			btnDropCube.setEnabled(false);
			Output.setText(Game.OUTPUT_NotEnoughMoney());
		} else {
			btnDropCube.setEnabled(true);
			Output.setText(Game.OUTPUT_InvalidValues());
		}

	}
}
