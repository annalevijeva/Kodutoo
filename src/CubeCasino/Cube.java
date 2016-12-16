package CubeCasino;

import java.util.Random;

public class Cube {
	
	Random rand = new Random();

	public int dropCube() {
		return rand.nextInt(6) + 1;
		
	}
	
	boolean checkRate(int rate) {
		if (rate < 1 || rate > 6) {
			return false;
		} else {
			return true;
		}
	}
}
