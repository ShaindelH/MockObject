import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BettingTest {

	private Betting bet;
	private MockRandomGenerator random1;
	
	@BeforeEach
	void setUp() {
		random1 = new MockRandomGenerator();
		bet = new Betting(-5, random1);
	}

	@Test
	void getCurrentBalanceReturnsCorrectBalance() {
		assertEquals(0, bet.getCurrentBalance(), .00001);
		bet.addMoney(10);
		assertEquals(10,bet.getCurrentBalance(),.00001);
	}

	@Test
	void canBetReturnsBooleanIfBetCanBePlaced() {
		bet.addMoney(30);
		assertTrue(bet.canBet(20));
		assertFalse(bet.canBet(500));
	}

	@Test
	void addMoneyIncreasesBalance() {
		assertEquals(0, bet.getCurrentBalance(),.00001);
		bet.addMoney(123.33);
		assertEquals(123.33,bet.getCurrentBalance(),.00001);
	}
	
	@Test
	void negativeNumbersDoesntLowerBalance() {
		bet.addMoney(-100);
		assertEquals(0, bet.getCurrentBalance(),.0001);
	}

	@Test
	void betOnANumberLowersBalance() {
			
		bet.addMoney(10);
		random1.setRandom(10);
		bet.betOnANumber(10, 100, 132, random1.getRandom());
		assertEquals(0, bet.getCurrentBalance(), .0001);
		
	}
	
	@Test
	void betOnANumberIncreasesBalance() {
		bet.addMoney(10);
		random1.setRandom(60);
		
		bet.betOnANumber(10, 55, 65, random1.getRandom());
		assertEquals(120, bet.getCurrentBalance(),.00001);
	}
	
	@Test
	void betNotPlacedIfBalanceIsTooLow() {
		
		double returnedDouble = bet.betOnANumber(30, 1, 2, random1.getRandom());
		assertEquals(0, returnedDouble);
		
	}

	@Test 
	void invalidProbabilityThrowsException() throws InvalidProbabilityException {
		
		
		assertThrows(InvalidProbabilityException.class, ()-> bet.betOnAProbability(2, 1.3));
		
	}
	
	@Test
	void betOnProbabilityIncreasesBalance() {
		bet.addMoney(200);
		random1.setRandom(25);
		
		try {
		bet.betOnAProbability(100, .3);	
		assertEquals(200 + Math.pow(.3, -1) * 100 ,bet.getCurrentBalance() ,.0001);
		}
		catch(Exception e) {
			
		}
		
	}
	
	@Test
	void betOnAProbabilityDecreasesBalance() {
		bet.addMoney(200);
		random1.setRandom(35);
		
		try {
		bet.betOnAProbability(100, .3);	
		assertEquals(100 ,bet.getCurrentBalance() ,.0001);
		}
		catch(Exception e) {
			
		}
	}
}
