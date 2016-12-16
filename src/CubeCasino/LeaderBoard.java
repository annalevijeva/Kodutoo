package CubeCasino;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class LeaderBoard {
	
	public static void main(String[] args) {
		
	}
	
	String name, profit, rates, won, date;

	static String[] columnNames = { "Name", "Profit", "Rates", "Won", "Date" };

	static String[][] rowData = new String[10][5];

	// IO File --

	static String filePath = "src/CubeCasino/LeaderBoard.txt";

	/**
	 * Puts the data of LeaderBoard.txt. into ArrayList, where one String is one
	 * line in file.
	 * 
	 * @return ArrayList<String>, one element = one line in file.
	 */
	static ArrayList<String> lbContent() {

		ArrayList<String> content = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				content.add(line);
			}
			reader.close();
			return content;
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'. ", filePath);
			// e.printStackTrace();
			return null;
		}
	}

	/**
	 * Rewrites content of LeaderBoard.txt file.
	 * 
	 * @param data. One String in ArrayList
	 * parameter is written into file as a line.
	 */
	static void lbEdit(String[] data) {
		ArrayList<String> lbFileContent = lbContent();
		lbFileContent.add(convertArrayToString(data));
		try {
			PrintWriter writer = new PrintWriter(filePath, "UTF-8");
			for (String line : lbFileContent) {
				writer.println(line);
			}
			writer.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filePath);
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 
	 * @param playerData {name, profit, rates, percent, date}
	 * @return String "name;profit;rates;won;date;\n"
	 */
	static String convertArrayToString(String[] playerData) {
		String ret = "";
		for (String data : playerData) {
			ret = ret + data + ";";
		}
		return ret += "\n";
	}

	// -- IO File

	/**
	 * 
	 * @param name (other parameters are got from Game class)
	 * @return String[] {name, profit, rates, percent, date}
	 */
	static String[] getPlayerData(String name) {
		String[] ret = new String[5];
		ret[0] = name;
		ret[1] = Game.money.moneyCount - 100 + "";
		ret[2] = Game.rates + "";
		ret[3] = Math.round(((1.0 * Game.won) / Game.rates * 100)) + "%";
		ret[4] = LocalDate.now() + "";
		for (String e : ret) {
			System.out.println(e);
		}
		return ret;
	}
}
