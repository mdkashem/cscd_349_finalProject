package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SkeletonTest {

	@Test
	void testAttack() {
		Skeleton testSkeleton = new Skeleton();
		BigBoss opponent = new BigBoss();
		
		while(opponent.getHitPoints() > 0)
		{
			testSkeleton.attack(opponent);
		}
		assertTrue(opponent.getHitPoints() < 1);
	}

}
