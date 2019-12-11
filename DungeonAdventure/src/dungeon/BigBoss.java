package dungeon;

import java.util.Scanner;

public class BigBoss extends Hero{
	
	public BigBoss(){
		super("Big Boss", 325, 4, .8, 35, 60, .2);
	}


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
			    	
			        break;
			    case 2: 
			    	
			    	attackFactory.getCrushingBlow("Crushing Blow Attach");
			    	
			        break;
                 case 3: 
			    	
			    	attackFactory.getBaseAttack("Base Attack ");
			    	
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
