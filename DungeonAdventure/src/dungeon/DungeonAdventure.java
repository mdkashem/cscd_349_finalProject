package dungeon;



import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**

 * Title: Dungeon.java
 *
 * Description: Driver file for Heroes and Monsters project
 *
 * Copyright:    Copyright (c) 2001
 * Company: Code Dogs Inc.
 * I.M. Knurdy
 *
 * History:
 *  11/4/2001: Wrote program
 *    --created DungeonCharacter class
 *    --created Hero class
 *    --created Monster class
 *    --had Hero battle Monster
 *    --fixed attack quirks (dead monster can no longer attack)
 *    --made Hero and Monster abstract
 *    --created Warrior
 *    --created Ogre
 *    --made Warrior and Ogre battle
 *    --added battleChoices to Hero
 *    --added special skill to Warrior
 *    --made Warrior and Ogre battle
 *    --created Sorceress
 *    --created Thief
 *    --created Skeleton
 *    --created Gremlin
 *    --added game play features to Dungeon.java (this file)
 *  11/27/2001: Finished documenting program
 * version 1.0
 */



/*
  This class is the driver file for the Heroes and Monsters project.  It will
  do the following:

  1.  Allow the user to choose a hero
  2.  Randomly select a monster
  3.  Allow the hero to battle the monster

  Once a battle concludes, the user has the option of repeating the above

*/
public class DungeonAdventure
{
    public static void main(String[] args)
	{
     HeroFactory factory = new HeroFactory();
     MonsterFactory monster = new MonsterFactory();
		Hero theHero;
		Monster theMonster;
		
		int x = 0;
		int y = 0;
		
		Dungeon startingDungeon = new Dungeon(5,5);
		Room[][] dungeon = startingDungeon.createDungeon();
		
		
		//dungeon.printDungeon();
		
		
		theHero = factory.createHero();
		dungeon[0][0].spawn(theHero);
		startingDungeon.playerLocation(x, y, dungeon);
		System.out.println("You wake up in a dark room...");
		//movePlayer(theHero, dungeon);
		do
		{
			
			
		    theMonster = monster.generateMonster();
			battle(theHero, theMonster);
			

		} while (playAgain());

    }//end main method
    
    
   public static void movePlayer(Hero player, Room[][] dungeon) {
	   Scanner kin = new Scanner(System.in);
		System.out.println("Which direction do you want to go?: \n"
							+ "N, S, E, W? ");
							
		if(kin.next().equalsIgnoreCase("N")) {
//			if() {
//				System.out.println("You ran into a wall, choose another direction.");
//			} else {
//				
//			}
		}
   }
   

	 	
	public static boolean playAgain()
	{
		char again;
		Scanner kin = new Scanner(System.in);

		System.out.println("Play again (y/n)?");
		again = kin.next().charAt(0);
		
		if(again == 'Y' || again == 'y') {
			return true;
		}
	 
		return false;
	}//end playAgain method
	
	//enterRoom is the play-by-play of
	//what happens when entering a new room
	public void enterRoom(Room room) {
		Hero player = (Hero) room.map.get("Hero");
		
		if(room.map.containsKey("Monster")) {
			Monster monster = (Monster) room.map.get("Monster");
			battle(player, monster);
		}
		if(room.map.containsKey("Pit")) {
			int rn = new Random().nextInt(30);
			player.subtractHitPoints(rn);
			System.out.println("You fall 15 feet into a pit." + "\n");
		}
		if(room.map.containsKey("Health Potion")) {
			int rn = new Random().nextInt(30);
			player.addHitPoints(rn);
		}
		if(room.map.containsKey("Pillar")) {
			player.numOfPiller++;
			System.out.println("Congratulations! You have found a Pillar. \n"
								+ "Your total amount of Pillars is " + player.numOfPiller);
		}
		if(room.map.containsKey("Exit")) {
			
		}
		Scanner kin = new Scanner(System.in);
		System.out.println("");
	}


/*-------------------------------------------------------------------
battle is the actual combat portion of the game.  It requires a Hero
and a Monster to be passed in.  Battle occurs in rounds.  The Hero
goes first, then the Monster.  At the conclusion of each round, the
user has the option of quitting.
---------------------------------------------------------------------*/
	public static void battle(Hero theHero, Monster theMonster)
	{   AttackFactory MonsterAttackFactory = new AttackFactory();
		
		Scanner kb = new Scanner(System.in);
		char pause = 'p';
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
		    //hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				MonsterAttackFactory.getBaseAttack("Base Attack ").attack(theHero, theMonster);;
			    //theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = kb.next().charAt(0);

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method


}//end Dungeon class
