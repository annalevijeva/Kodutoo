package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Snippet {
	
	public static void main(String[] args) {
		String line = "Player;200 $;21;30%;2016-12-16;";
		String[] output;
		
		output = line.split(";"); // БОЖЕСТВЕННО!!!
		
		for (String word : output) {
			System.out.println(word);
		} 
	}
	
		static String filePath = "src/CubeCasino/LeaderBoard.txt";
	
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
	
		static void lbEdit(ArrayList<String> data) {
			ArrayList<String> content = lbContent();
			content.addAll(data);
			try {
				PrintWriter writer = new PrintWriter(filePath, "UTF-8");
				for (String line : content) {
					writer.println(line);
				}
				writer.close();
			} catch (Exception e) {
				System.err.format("Exception occurred trying to read '%s'.", filePath);
				e.printStackTrace();
				return;
			}
		}
	
}

