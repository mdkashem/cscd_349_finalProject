package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SorceressTest {

	@Test
	void testBattleChoices() {
		Sorceress testSorceress = new Sorceress();
		
		Ogre opponent = new Ogre();
		
		testSorceress.battleChoices(opponent);
		
		assertTrue(testSorceress.getHitPoints() < 25 || opponent.getHitPoints() < 200);
	}

	@Test
	void testIncreaseHitPoints() {
		Sorceress testSorceress = new Sorceress();
		
		int startingHp = testSorceress.getHitPoints();
		
		testSorceress.increaseHitPoints();
		
		assertTrue(startingHp < testSorceress.getHitPoints());
		
	}

}
