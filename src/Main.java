
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IRandomValueGenerator random = new RandomGenerator();
		int p = (int)Math.round( .345 *100);
		if (2 <= p) {
		System.out.println("random is " + random.getRandom(1, 20));
		}
		else {
			System.out.println("hi");
		}
	}

}
