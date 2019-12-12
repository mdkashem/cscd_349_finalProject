package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThiefTest {

	@Test
	void testBattleChoices() {
		Thief testThief = new Thief();		
		Ogre opponent = new Ogre();
		
		testThief.battleChoices(opponent);
		
		assertTrue(testThief.getHitPoints() < 25 || opponent.getHitPoints() < 200);
	}

	@Test
	void testSurpriseAttack() {
		Thief testThief = new Thief();		
		Ogre opponent = new Ogre();
		
		int startingTurns = testThief.numTurns;
		
		testThief.surpriseAttack(opponent);
		
		//cycle through each assertion for each if scenario based on RNG. Each assertions needs only to be true once in any number of tests.
		assertTrue(testThief.numTurns > startingTurns && opponent.getHitPoints() < 200);
		//assertTrue(testThief.numTurns == startingTurns && opponent.getHitPoints() < 200);
		//assertTrue(testThief.numTurns == startingTurns && opponent.getHitPoints() == 200);
	}

}