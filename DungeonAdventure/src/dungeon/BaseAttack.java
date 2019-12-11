package dungeon;

public class BaseAttack implements Attack{

	public void attack(DungeonCharacter attacker, DungeonCharacter defender) {
		// TODO Auto-generated method stub
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= attacker.chanceToHit;

		if (canAttack)
		{
			damage = (int)(Math.random() * (attacker.damageMax - attacker.damageMin + 1))
						+ attacker.damageMin ;
			defender.subtractHitPoints(damage);

			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(attacker.getName() + "'s attack on " + defender.getName() +
								" failed!");
			System.out.println();
		}//end else
		
	}

}