package dungeon;

import java.util.Scanner;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */




public class Warrior extends Hero
{

    public Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);


    }//end constructor


    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		super.battleChoices(opponent);
		
		Scanner kb = new Scanner(System.in);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");
		    choice = kb.nextInt();

		    switch (choice)
		    {
			    case 1: attackFactory.getBaseAttack("Base Attack ");
			        break;
			    case 2: attackFactory.getCrushingBlow("Crushing Blow on Opponant");
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }//end battleChoices method

}//end Hero class