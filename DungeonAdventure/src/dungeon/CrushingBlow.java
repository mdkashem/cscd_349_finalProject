package dungeon;

public class CrushingBlow implements Attack {

private String name;
	
	public CrushingBlow(String name ){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	
	public void attack(DungeonCharacter attacker, DungeonCharacter defender) {

				if (Math.random() <= .4)
				{
					int blowPoints = (int)(Math.random() * 76) + 100;
					System.out.println(attacker.name + " lands a CRUSHING BLOW for " + blowPoints
										+ " damage!");
					defender.subtractHitPoints(blowPoints);
					System.out.println(attacker.getName() + " did "+getName()+" on " + defender.getName());
					System.out.println();
				}//end if can attack
				else
				{

					System.out.println(attacker.name + " failed to land a crushing blow");
					System.out.println();
				}//end else
				
			}

}
