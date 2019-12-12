package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OgreTest {

	@Test
	void testAttack() {
		Ogre testOgre = new Ogre();
		BigBoss opponent = new BigBoss();
		
		while(opponent.getHitPoints() > 0)
		{
			testOgre.attack(opponent);
		}
		assertTrue(opponent.getHitPoints() < 1);
	}

}
