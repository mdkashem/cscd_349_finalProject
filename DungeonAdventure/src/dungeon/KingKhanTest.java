package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KingKhanTest {

	@Test
	void testBattleChoices() {
		KingKhan testKingKhan = new KingKhan();
		
		Ogre opponent = new Ogre();
		
		testKingKhan.battleChoices(opponent);
		
		assertTrue(testKingKhan.getHitPoints() < 25 || opponent.getHitPoints() < 200);
	}

}
