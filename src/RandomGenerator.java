import java.util.Random;

public class RandomGenerator implements IRandomValueGenerator {

	private Random rand;
	private int random;
	
	public RandomGenerator() {
		rand = new Random();
		
	}
	
	//returns random integer
	public int getRandom() {
		random = rand.nextInt();
		return random;
	}
	
}

