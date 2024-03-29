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

public class Thief extends Hero
{
	private static String name="Thief"; 
	private static int hitPoints =75; 
	private static	int attackSpeed =6;
	private static  double chanceToHit=.8; 
	private static  int damageMin=20; 
	private static  int damageMax=40;
	private static double chanceToBlock=0.5;
	
    public Thief()
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock);



    }//end constructor

	public void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								name + " gets an additional turn.");
			numTurns++;
			attackFactory.getBaseAttack("Base Attack ").attack(this, opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
			attackFactory.getBaseAttack("Base Attack ").attack(this, opponent);


	}//end surpriseAttack method


    public void battleChoices(DungeonCharacter opponent)
	{
		super.battleChoices(opponent);
		int choice;
		Scanner kb = new Scanner(System.in);


		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
		    System.out.print("Choose an option: ");
		    choice = kb.nextInt();
		    switch (choice)
		    {
			    case 1: attackFactory.getBaseAttack("Base Attack ").attack(this, opponent);
			        break;
			    case 2: surpriseAttack(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
			if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while(numTurns > 0);

    }
}