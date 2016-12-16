package CubeCasino;

public class Money {
	
	public int moneyCount = 100;

	public boolean checkRate(int rate) {
		if (rate <= moneyCount && rate > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void makeRate(int rate) {
			moneyCount -= rate;
	}
	
	public void ifWon(int rate) {
		moneyCount += 6*rate;
	}
}
