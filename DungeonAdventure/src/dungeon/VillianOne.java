package dungeon;

public class VillianOne extends Monster {

	public VillianOne() {
		super("New Villain One ", 150, 2, .6, .1, 30, 54, 30, 55);
	}
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " jabs his kris at " +
							opponent.getName() + ":");
		//super.attack(opponent);
		MonsterAttackFactory.getBaseAttack("Base Attack ");

	}//end override of attack

}
