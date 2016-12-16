package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Snippet {
	
	public static void main(String[] args) {
		ArrayList<String> list = lbContent();
		for (String line : list) {
			System.out.println(line);
		}
	}
	
		
		//place;name;rates;percent;profit;date
	
		static String filePath = "src/CubeCasino/LeaderBoard.txt";
		
	//	public static void main(String[] args) {
	//	ArrayList<String> data = new ArrayList<String>();
	//	data.add("line 1");
	//	writeFile(data);
	//	ArrayList<String> lbTable = readFile();
	//	System.out.println("");
	//	for (String line : lbTable) {
	//		System.out.println(line);
	//	}
	//}
		
		
	
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

