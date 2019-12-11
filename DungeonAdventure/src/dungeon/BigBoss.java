package dungeon;

import java.util.Scanner;

public class BigBoss extends Hero{
	
	public BigBoss(){
		super("Big Boss", 325, 4, .8, 35, 60, .2);
	}

	public void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(name + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
		
		
	}//end override of attack method




    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		super.battleChoices(opponent);
		
		Scanner kb = new Scanner(System.in);

		do
		{
		    System.out.println("1. Fire Ball Attack");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.println("3. Basic Attack on Opponent");
		    System.out.print("Choose an option: ");
		    choice = kb.nextInt();

		    switch (choice)
		    {
			    case 1: 
			    	
			    	attackFactory.getFireBallAttack("Fire Ball Attack");
			    	attack(opponent);
			        break;
			    case 2: 
			    	
			    	attackFactory.getCrushingBlow("Crushing Blow Attach");
			    	//crushingBlow(opponent);
			        break;
                 case 3: 
			    	
			    	attackFactory.getBaseAttack("Base Attack ");
			    	//crushingBlow(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }//end battleChoices method
}
