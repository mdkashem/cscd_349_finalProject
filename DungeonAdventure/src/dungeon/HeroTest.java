package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeroTest {

	@Test
	void testSubtractHitPoints() {
		Hero testHero = new BigBoss();
		while(testHero.getHitPoints() > 0)
		{
			testHero.subtractHitPoints(1);
		}
		
		//can assert block clause of subtractHitPoints via console.
		assertTrue(testHero.getHitPoints() < 1);
	}

	@Test
	void testDefend() {
		Hero testHero = new BigBoss();
		
		for(int i = 0; i <100; i++)
		{
			//only needs to assert true at least once, can run test multiple times. 
			assertTrue(testHero.defend());
		}
	}

	@Test
	void testBattleChoices() {
		Hero testHero = new BigBoss();
		Ogre opponent = new Ogre();
		
		testHero.battleChoices(opponent);
		assertTrue(testHero.numTurns == 2);
	}

}
