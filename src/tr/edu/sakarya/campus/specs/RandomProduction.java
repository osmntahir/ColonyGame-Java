package tr.edu.sakarya.campus.specs;

import java.util.Random;

/**
 * Produces a random value between 0 and 15
 */
public class RandomProduction implements Production {

	private final Random random = new Random();

	@Override
	public int produce() {
		return 1 + random.nextInt(15);
	}
}
