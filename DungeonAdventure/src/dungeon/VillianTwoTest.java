package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VillianTwoTest {

	@Test
	void testAttack() {
		VillianTwo testVillianTwo = new VillianTwo();
		BigBoss opponent = new BigBoss();
		
		while(opponent.getHitPoints() > 0)
		{
			testVillianTwo.attack(opponent);
		}
		assertTrue(opponent.getHitPoints() < 1);
	}

}
