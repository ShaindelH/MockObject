
public class MockRandomGenerator implements IRandomValueGenerator{

	private int random;
	
	public MockRandomGenerator() {
		random = 0;
	}
	
	public void setRandom(int random) {
		this.random = random;
	}
	
	public int getRandom() {
		return random;
	}
	
}
