
public class Betting {

	private double minBalance;
	private double currentBalance;
	private IRandomValueGenerator random;

	public Betting(int minBalance, IRandomValueGenerator random) {

		if (minBalance <= 0) {
			this.minBalance = minBalance;
		}
		currentBalance = 0;
		this.random = random;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public boolean canBet(double amnt) {
		return (currentBalance - amnt) >= minBalance;
	}

	public void addMoney(double amnt) {
		if (amnt > 0) {
			currentBalance += amnt;
		}
	}

	public double betOnANumber(double amnt, int min, int max, int selectedNumber) {

		if (currentBalance - amnt >= minBalance) {
			if (selectedNumber <= max && selectedNumber >= min) {
				amnt = (max - min + 1) * amnt;
				currentBalance += amnt;
			} else {
				currentBalance -= amnt;
				amnt *= -1;
			}
		} else {
			// can't make bet if it may cause currentBalance less than minBalance
			return 0;
		}
		return amnt;
	}

	public double betOnAProbability(double amnt, double p) throws InvalidProbabilityException {
		
		if (currentBalance - amnt >= minBalance) {
			if (p < 0 || p > 1) {
				throw new InvalidProbabilityException();
			}
			//if the random number is within the probability (as a percent) then bet wins
			if (random.getRandom() <= (p*100)) {
				amnt = Math.pow(p, -1) * amnt;
				currentBalance += amnt;
			}
		
			else {
				//lose bet subtracts amnt from balance
				currentBalance -= amnt;
				amnt *= -1;
			}
		} else { 
			//can't make bet if it may cause currentBalance less than minBalance
			return 0;
		}
			return amnt;
	}
}
