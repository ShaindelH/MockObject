
public class Betting {

	private int minBalance;
	private int currentBalance;
	private IRandomValueGenerator random;
	
	public Betting(int minBalance, IRandomValueGenerator random) {
			
	}
	
	public int getCurrentBalance() {
		return 0;
	}
	
	public boolean canBet(double amnt) {
		return true;
	}
	
	public void addMoney(double amnt) {
		
	}
	
	public double betOnANumber(double amnt, int min, int max, int selectedNumber) {
		
		return 0;
	}
	
	public double betOnAProbability(double amnt, double p) {
		
		return 0;
	}
	
}
