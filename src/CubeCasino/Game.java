package CubeCasino;

public class Game {
	
	static Money money = new Money();
	static Cube cube = new Cube();

	static int rates = 0;
	static int won = 0;
	
	static String rules = 
			"You have 100$ when game starts.\n"
			+ "You can make money rates no \n"
			+ "more than money you've got.\n"
			+ "Cube rate is your dice forecast\n"
			+ "(1-6).\n"
			+ "If your forecast was true, your\n"
			+ "profit is your rate x6.\n"
			+ "If not, you'll lose your rate.";

	public static String OUTPUT_EndGame() {
		
		if (money.moneyCount >= 100) {
			return "You won " + (money.moneyCount - 100) + " $.\n\nYou made " + rates + " rates,\n" + won
					+ " of them were succesful.\n(" + Math.round(((1.0 * won) / rates * 100)) + "%)";
		} else {
			return "You lost " + (100 - money.moneyCount) + " $.\n\nYou made " + rates + " rates,\n" + won
					+ " of them were succesful.\n(" + Math.round(((1.0 * won) / rates * 100)) + "%)";
		}
	}
	
	public static String OUTPUT_InvalidValues() {
		return "Invalid values.\nMoney count should be \nfrom 1 to " + money.moneyCount
		+ "\nCube rate should be\nfrom 1 to 6";
	}
	
	public static String OUTPUT_NotEnoughMoney() {
		return "You have not enough money\nto make rates.\n\nGame is over. \nPress \"End game\" for statistics.";
	}

	public static String OUTPUT_YouWon(int randomCubeValue, int mRate) {
		rates++;
		won++;
		return "Computer's choise: " + randomCubeValue + "\n\nCongrats!\nYou won " + 6 * mRate + " $ !";
	}

	public static String OUTPUT_YouLost(int randomCubeValue, int mRate) {
		rates++;
		return "Computer's choise: " + randomCubeValue + "\n\nYou lost " + mRate + " $ !";
	}

}
