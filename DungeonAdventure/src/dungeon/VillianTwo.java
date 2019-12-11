package dungeon;

public class VillianTwo extends Monster{
	public VillianTwo(){
		super("Gnarltooth the Gremlin", 270, 5, .8, .4, 15, 40, 20, 80);
	}
	
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack

}
