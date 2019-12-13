package dungeon;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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



//Done by Kobe Kupp
public class DungeonAdventure
{
    public static void main(String[] args) throws Exception
	{
     HeroFactory factory = new HeroFactory();
     MonsterFactory monster = new MonsterFactory();
		Hero theHero;
		Monster theMonster;
		
		int x = 0;
		int y = 0;
		
		Dungeon startingDungeon = new Dungeon(5,5);
		Room[][] dungeon = startingDungeon.createDungeon();
		
		do
		{
			
			theHero = factory.createHero();
			dungeon[0][0].spawn(theHero);
			Room location = startingDungeon.playerLocation(x, y, dungeon);
			System.out.println("You wake up in a dark room...\n\n");
			
			
			do {
				char choice = movePlayer(theHero, location);
				if(choice == 'N') {
					Hero temp = (Hero) location.map.get("Hero");
					location.map.remove("Hero");
					location = startingDungeon.playerLocation(--x, y, dungeon);
					location.map.put("Hero", temp);
					enterRoom(location);
				}
				if(choice == 'E') {
					Hero temp = (Hero) location.map.get("Hero");
					location.map.remove("Hero");
					location = startingDungeon.playerLocation(x, ++y, dungeon);
					location.map.put("Hero", temp);
					enterRoom(location);
				}
				if(choice == 'S') {
					Hero temp = (Hero) location.map.get("Hero");
					location.map.remove("Hero");
					location = startingDungeon.playerLocation(++x, y, dungeon);
					location.map.put("Hero", temp);
					enterRoom(location);
				}
				if(choice == 'W') {
					Hero temp = (Hero) location.map.get("Hero");
					location.map.remove("Hero");
					location = startingDungeon.playerLocation(x, --y, dungeon);
					location.map.put("Hero", temp);
					enterRoom(location);
				}
				if(choice == 'P') {
					//int rn = new Random().nextInt(30);
					int rn = (int)(Math.random() * (30 - 15 + 1)) + 15;
					theHero.addHitPoints(rn);
					System.out.println("------------------------------------------\n");
					System.out.println("You drink the mysterious liquid and begin to feel refurbished...\n"
										+ "Your wounds begin to heal and you get a burst of energy!\n"
										+ "You gain " + rn + " health points! "
										+ " Now you have " + theHero.getHitPoints()
										+ "\n----------------------------------------\n");
				}
				if(choice == 'G') {
					saveGame(theHero, startingDungeon);
				}
				
				if(choice == 'V') {
					int tempUlX = x;
					int tempUlY = y;
					int tempNX = x;
					int tempNY = y;
					int tempUrX = x;
					int tempUrY = y;
					int tempWX = x;
					int tempWY = y;
					int tempCurX = x;
					int tempCurY = y;
					int tempEX = x;
					int tempEY = y;
					int tempBlX = x;
					int tempBlY = y;
					int tempSX = x;
					int tempSY = y;
					int tempBrX = x;
					int tempBrY = y;
					//upper left
					System.out.println("Upper Left Room");
					System.out.println(visionOutput(--tempUlX, --tempUlY, startingDungeon, dungeon));
					System.out.println("      ");
					//direct North
					System.out.println("Northern Room");
					System.out.println(visionOutput(--tempNX, tempNY, startingDungeon, dungeon));
					System.out.println("      ");
					//upper right
					System.out.println("Upper Right Room");
					System.out.println(visionOutput(--tempUrX, ++tempUrY, startingDungeon, dungeon));
					System.out.println("      ");
					
					//West
					System.out.println("Western Room");
					System.out.println(visionOutput(tempWX, --tempWY, startingDungeon, dungeon));
					System.out.println("      ");
					//cur
					System.out.println("Current Room");
					System.out.println(visionOutput(tempCurX, tempCurY, startingDungeon, dungeon));
					System.out.println("      ");
					//East
					System.out.println("Eastern Room");
					System.out.println(visionOutput(tempEX, ++tempEY, startingDungeon, dungeon));
					System.out.println("      ");
					//bottom left
					System.out.println("Bottom Left Room");
					System.out.println(visionOutput(++tempBlX, --tempBlY, startingDungeon, dungeon));
					System.out.println("      ");
					//South
					System.out.println("Southern Room");
					System.out.println(visionOutput(++tempSX, tempSY, startingDungeon, dungeon));
					System.out.println("      ");
					
					//bottom right
					System.out.println("Bottom Right Room");
					System.out.println(visionOutput(++tempBrX, ++tempBrY, startingDungeon, dungeon));
					
				}
				if(choice == 'F') {
					System.out.println("Please choose N--S--E--W\n\n");
				}

			} while(!location.map.containsValue(500) || theHero.hitPoints == 0);
			

		} while (playAgain());

    }//end main method
    
   public static String visionOutput(int x, int y, Dungeon dungeon, Room[][] room) throws ArrayIndexOutOfBoundsException{
	   
	   try {
		   Room location = dungeon.playerLocation(x, y, room);
		    return location.toString();
	   } catch(Exception e) {
		   return "WALL";
	   }
   }
    
   public static char movePlayer(Hero player, Room cur) throws Exception{
	   Scanner kin = new Scanner(System.in);
	   System.out.println("Current Room: ");
	   System.out.println(cur.toString() + "\n");
	   System.out.println("What do you wish to do?:\n"
			   				+ "Move Character? -> M\n"
			   				+ "Check inventory? -> I\n"
			   				+ "Save Game? -> S\n");

	   
	   char c = kin.next().charAt(0);
	   char e = Character.toUpperCase(c);
	   
	   //check health potions
	   do {
		   if(e == 'I') {
			   Scanner scan = new Scanner(System.in);
			   System.out.println("-------------------------------------------");
			   System.out.println("Items in inventory:\n");
			   System.out.println("Healing Potions: " + player.getNumOfHealing() + "\n"
					   				+ "Pillars: " + player.getNumOfPiller() + "\n"
					   				+"Vision Potions: " + player.getNumOfVision() + "\n"
					   				+ "------------------------------------------\n");
			   System.out.println("Drink Healing Potion? -> H\n"
					   				+ "Drink Vision Potion? -> V\n"
				    				+ "Go back? -> B\n");
			  
			   char test = scan.next().charAt(0);
			   char input = Character.toUpperCase(test);
			   do {
				    
		
				   if(input == 'H') {
					   if(player.getNumOfHealing() == 0) {
						   System.out.println("You do not have any Health Potions :(\n");
						   return 'B';
					   } else {
						   return 'P';
					   } 
				   }
				   if(input == 'V') {
					   if(player.getNumOfVision() == 0) {
						   System.out.println("You do not have any Vision Potions :(\n");
						   return 'B';
					   } else {
						   return 'V';
					   }
				   }
				   if(input == 'B') {
					   System.out.println("\n");
					   return 'B';
					  
				   }
				   else {
					   System.out.println("Please select an available option.\n");
				   }
			   } while(input != 'B');
			   
		  }
		  if( e == 'S') {
			  return 'G';
		  }
	   } while (e != 'M');
	   
	  
	   Scanner kb = new Scanner(System.in);
	   System.out.println("Which direction do you want to go?: \n"
				+ "N--S--E--W? ");
	   
	   char o = kb.next().charAt(0);
	   char key = Character.toUpperCase(o);
	  
	   
	   if(key == 'N') {
		   if(cur.getN() == 1) {
			System.out.println("You ran into a wall, choose another direction.");
		   } 
		   else {
			return 'N';
		   }

	   }
	   else if(key == 'E') {
			if(cur.getE() == 1) {
				System.out.println("You ran into a wall, choose another direction.");
			} 
			else {
				return 'E';
			}
		}
		else if(key == 'S') {
			if(cur.getS() == 1) {
				System.out.println("You ran into a wall, choose another direction.");
			} 
			else {
				return 'S';
			}
		}
		else if(key == 'W') {

			if(cur.getW() == 1) {
				System.out.println("You ran into a wall, choose another direction.");
			} 
			else {
				return 'W';
			}
		}
	 
		
		
		char incorrect = 'F';
		return incorrect;
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
	public static void enterRoom(Room room) {
		Hero player = (Hero) room.map.get("Hero");
		Scanner kb = new Scanner(System.in);
		
		if(room.map.containsKey("Monster")) {
			Monster monster = (Monster) room.map.get("Monster");
			battle(player, monster);
			room.map.remove("Monster");
		}
		if(room.map.containsKey("Pit")) {
			System.out.println("You fall 15 feet into a pit." + "\n");
			int rn = new Random().nextInt(30);
			player.subtractHitPoints(rn);
			
		}
		if(room.map.containsKey("Health Potion")) {
			player.setNumOfHealing(player.getNumOfHealing() + 1);
			room.map.remove("Health Potion");
			System.out.println("You have found a Health Potion!\n"
								+ "Now you have " + player.getNumOfHealing() + "!");
		}
		if(room.map.containsKey("Vision Potion")) {
			player.setNumOfVision(player.getNumOfVision() + 1);
			room.map.remove("Vision Potion");
			System.out.println("You have found a Vision Potion!\n"
					+ "Now you have " + player.getNumOfVision() + "!");
		}
		if(room.map.containsKey("Pillar")) {
			player.setNumOfPiller(player.getNumOfPiller() + 1);
			room.map.remove("Pillar");
			System.out.println("Congratulations! You have found a Pillar. \n"
								+ "Your total amount of Pillars is " + player.getNumOfPiller() + ".");
		}
		if(room.map.containsKey("Entrance")) {
			System.out.println("You are at the entrance...\n");
		}
		if(room.map.containsKey("Exit")) {
			System.out.println("You have found the exit, do you wish to leave? y/n\n");
			if(kb.next().equalsIgnoreCase("Y")) {
				if(player.getNumOfPiller() == 1) {
					System.out.println("You miscreant. You only have " + player.getNumOfPiller()
					+ " Pillar!");
				}
				else if(player.getNumOfPiller() < 4) {
				System.out.println("You miscreant. You only have " + player.getNumOfPiller()
									+ " Pillars!");
				}
				else {
					System.out.println("Congratulations! You have escaped the dungeon!");
					room.map.put("Pit", 500);
				}
			}
			else if(kb.next().equalsIgnoreCase("N")) {
				
			}
			
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
				MonsterAttackFactory.getBaseAttack("Base Attack ").attack(theMonster, theHero);;
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
	
	//Done by Md Abul Kashem
	public static void saveGame(Hero player, Dungeon dungeon){
		CareTaker caretaker = new CareTaker();
		caretaker.SavedToFile(player.name, player.getNumOfHealing(), player.getNumOfVision(), player.getNumOfPiller());
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("savedDungeon.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(dungeon);
	         out.close();
	         fileOut.close();
	         System.out.println("\nDungeon saved successfully");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
	}
	//Done by Md Abul Kashem
	public static Dungeon loadGame(Hero player){
		CareTaker caretaker = new CareTaker();
		player.name=caretaker.loadState().getNameOfHero();
		player.setNumOfHealing(caretaker.loadState().getNumOfHealing());
		player.setNumOfVision(caretaker.loadState().getNumOfVision());
		player.setNumOfPiller(caretaker.loadState().getNumOfPillars());
		
		Dungeon e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("savedDungeon.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Dungeon) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         //return;
	      } catch (ClassNotFoundException c) {
	         System.out.println(" Dungeon  not found");
	         c.printStackTrace();
	        // return;
	      }
	      
		
		
		return e;
	}


}//end Dungeon class