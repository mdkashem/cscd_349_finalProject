package dungeon;




import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;



public class Dungeon {

	
<<<<<<< HEAD:DungeonAdventure/src/Dungeon.java
=======

	private Room entrance;

	private Room exit;

>>>>>>> d867c8bc35b350d6f2f6f622515126f5c4d964b2:DungeonAdventure/src/dungeon/Dungeon.java
	

	

	

	

	

	

	
<<<<<<< HEAD:DungeonAdventure/src/Dungeon.java
	
	
	
	
	
	
	

=======

	public Object getEntrance() {

		return entrance;

	}



	public void setEntrance() {

		

	}



	public Object getExit() {

		return exit;

	}



	public void setExit(int[][] exit) {

		this.exit = exit;

	}



	



	public Dungeon(Room[][] dungeon) {

		//dungeon.createDungeon();

		 dungeon = new Room[5][5];

    	

	}

>>>>>>> d867c8bc35b350d6f2f6f622515126f5c4d964b2:DungeonAdventure/src/dungeon/Dungeon.java
	

	

	

<<<<<<< HEAD:DungeonAdventure/src/Dungeon.java
	

	public Dungeon(int row, int col) {
		Room[][] dungeon = new Room[row][col];
		
		
	    
    	for(int row1 = 0; row1 < col; row1++) {
    		for(int col1 = 0; col1 < row; col1++) {
    			dungeon[row1][col1] = new Room(0,0,0,0);
=======
	public static void createDungeon() {

		

    	Room[][] dungeon = new Room[5][5];

    	for(int row = 0; row < dungeon.length; row++) {

    		for(int col = 0; col < dungeon.length; col++) {

    			Room room = new Room();

>>>>>>> d867c8bc35b350d6f2f6f622515126f5c4d964b2:DungeonAdventure/src/dungeon/Dungeon.java
    		}

    	}
<<<<<<< HEAD:DungeonAdventure/src/Dungeon.java
    	
    	dungeon.toString();
    	int randoRow = new Random().nextInt(5);
    	int randoCol = new Random().nextInt(5);
    	int count = 0;
    	
    	while(count != 4) {
			if(dungeon[randoRow][randoCol].hasPillar() || dungeon[randoRow][randoCol].hasEntrance() || dungeon[randoRow][randoCol].hasExit()) {
				randoRow = new Random().nextInt(5);
				randoCol = new Random().nextInt(5);
			}
			dungeon[randoRow][randoCol].setPillar(10);
			count++;
		}
    	
	}
	
	public boolean isDoor(int wall) {
		return wall == 1;
=======

    

    }

	

	public void setSpawn(Room[][] entrance) {

		//this is to make sure that the entrance is placed on the border

		//of the dungeon, and not in the middle.

		int border = new Random().nextInt(5);

		int randoEntry = new Random().nextInt(6);

		//int randoExit = new Random().nextInt(6);

		

		

		

		if(border == 0) {

			entrance[0][randoEntry].getEntrance();

		}

		else if(border == 1) {

			entrance[randoEntry][0].getEntrance();

		}

		else if(border == 2) {

			entrance[5][randoEntry].getEntrance();

		}

		else {

			entrance[randoEntry][5].getEntrance();

		}

		

>>>>>>> d867c8bc35b350d6f2f6f622515126f5c4d964b2:DungeonAdventure/src/dungeon/Dungeon.java
	}

	

	public void setExitDoor(Room[][] exit) {

		int row = new Random().nextInt(6);

		int col = new Random().nextInt(6);

		

		if(!exit[row][col].hasEntrance()) {

			exit[row][col].getExit();

		}

		else {

			row = new Random().nextInt(6);

			col = new Random().nextInt(6);

			exit[row][col].getExit();

		}

	}

	
<<<<<<< HEAD:DungeonAdventure/src/Dungeon.java
	public void spawnPillar(Room[][] room) {
		int row = 0;
		int col = 0;
=======

	public void placePillar(Room[][] room) {

		int row = new Random().nextInt(6);

		int col = new Random().nextInt(6);

>>>>>>> d867c8bc35b350d6f2f6f622515126f5c4d964b2:DungeonAdventure/src/dungeon/Dungeon.java
		int count = 0;

		

		while(count != 4) {

			if(room[row][col].hasPillar() || room[row][col].hasEntrance() || room[row][col].hasExit()) {

				row = new Random().nextInt(6);

				col = new Random().nextInt(6);

			}

			room[row][col].getPillar();

			count++;

		}

		

	}

	

	
<<<<<<< HEAD:DungeonAdventure/src/Dungeon.java
	 
	  public String location() {
		  return "";
=======

	  public boolean hasEntrance() { 

		  if(this.getEntrance() != null) {

			  return true;

		  } 

		  return false;

	  }

	  

	  public boolean hasExit() {

		  if(this.getExit() != null) {

			  return true; 

			  } 

		  return false;

	  }

	  

	  public String location() {

		  

>>>>>>> d867c8bc35b350d6f2f6f622515126f5c4d964b2:DungeonAdventure/src/dungeon/Dungeon.java
	  }

	

	

	

	public String toString() {

		

		
<<<<<<< HEAD:DungeonAdventure/src/Dungeon.java
		return "";
=======

		for(int row = 0; row < dungeon.length; row++) {

    		for(int col = 0; col < dungeon.length; col++) {

    			

    		}

    	}

		

		return "test";

>>>>>>> d867c8bc35b350d6f2f6f622515126f5c4d964b2:DungeonAdventure/src/dungeon/Dungeon.java
	}
	
	
	



}