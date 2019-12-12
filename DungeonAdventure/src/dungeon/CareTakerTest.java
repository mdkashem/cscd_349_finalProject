package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CareTakerTest {

	@Test
	
	//Tests both savedToFile and loadState
	void testSavedToFile() {
		CareTaker testCareTaker = new CareTaker();
		
		testCareTaker.SavedToFile("TestName", 1, 2, 3);
		
		Originator testOriginator = testCareTaker.loadState();
		
		assertTrue(testOriginator.getNameOfHero() == "TestName" && testOriginator.getNumOfHealing() == 1 
				&& testOriginator.getNumOfPillars() == 2 && testOriginator.getNumOfVision() == 3);
		
	}
}
