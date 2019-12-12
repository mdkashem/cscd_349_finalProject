package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VillianOneTest {

	@Test
	void testAttack() {
		VillianOne testVillianOne = new VillianOne();
		BigBoss opponent = new BigBoss();
		
		while(opponent.getHitPoints() > 0)
		{
			testVillianOne.attack(opponent);
		}
		assertTrue(opponent.getHitPoints() < 1);
	}

}
