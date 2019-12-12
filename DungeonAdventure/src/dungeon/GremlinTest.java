package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GremlinTest {

	@Test
	void testAttack() {
		Gremlin testGremlin = new Gremlin();
		BigBoss opponent = new BigBoss();
		
		while(opponent.getHitPoints() > 0)
		{
			testGremlin.attack(opponent);
		}
		assertTrue(opponent.getHitPoints() < 1);
	}

}
