package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dungeon.Originator.Memento;

class OriginatorTest {

	@Test
	//tests saveToMemeno as well as restoreFromMemento
	void testSaveToMemento() {
		Originator testOriginator = new Originator();
		testOriginator.setNameOfHero("TestName");
		testOriginator.setNumOfHealing(1);
		testOriginator.setnumOfPillars(2);
		testOriginator.setNumOfVision(3);
		
		Memento testMemento = testOriginator.saveToMemento();
		
		testOriginator.restoreFromMemento(testMemento);
		
		assertTrue(testOriginator.getNameOfHero() == "TestName" && testOriginator.getNumOfHealing() == 1 
				&& testOriginator.getNumOfPillars() == 2 && testOriginator.getNumOfVision() == 3);
		
	}
}
