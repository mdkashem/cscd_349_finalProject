package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonsterTest {

	@Test
	void testSubtractHitPoints() {
		Monster testMonster = new Gremlin();
		testMonster.subtractHitPoints(41);
		assertTrue(testMonster.getHitPoints() < 70);
	}

	@Test
	void testHeal() {
		Monster testMonster = new Gremlin();
		
		int startingHp = testMonster.getHitPoints();
		
		for(int i = 0; i < 100; i++)
		{
			testMonster.heal();
		}
		assertTrue(startingHp < testMonster.getHitPoints());
	}

}
