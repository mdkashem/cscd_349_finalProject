package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseAttackTest {

	@Test
	void testAttack() {
		BaseAttack testBaseAttack = new BaseAttack("TestBaseAttack");
		Thief attacker = new Thief();
		Ogre defender = new Ogre();
		
		while(defender.getHitPoints() > 0)
		{
			testBaseAttack.attack(attacker, defender);
		}
		
		assertTrue(defender.getHitPoints() < 1);
	}

}
