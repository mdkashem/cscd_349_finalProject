package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BigBossTest {

	@Test
	void testBattleChoices() {
		BigBoss testBigBoss = new BigBoss();
		
		Ogre opponent = new Ogre();
		
		testBigBoss.battleChoices(opponent);
		
		assertTrue(testBigBoss.getHitPoints() < 25 || opponent.getHitPoints() < 200);
	}

}
