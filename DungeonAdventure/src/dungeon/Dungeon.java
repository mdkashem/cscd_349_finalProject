package dungeon;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
	public class Dungeon {

	public Dungeon(int row, int col) {
		Room[][] dungeon = new Room[row][col];
		
		
	    
    	for(int row1 = 0; row1 < col; row1++) {
    		for(int col1 = 0; col1 < row; col1++) {
    			//top left corner
    			if(row1 == 0 && col1 == 0) {
    				dungeon[row1][col1] = new Room(1,0,0,1);
    			}
    			//all north walls
    			else if(row1 == 0 && (col1 == 1 || col1 == 2 || col1 == 3)) {
    				dungeon[row1][col1] = new Room(1,0,0,0);
    			}
    			
    			//top right corner
    			else if(row1 == 0 && col1 == 4) {
    				dungeon[row1][col1] = new Room(1,1,0,0);
    			}
    			//all East walls
    			else if(col1 == 4 && (row1 == 1 || row1 == 2 || row1 == 3)) {
    				dungeon[row1][col1] = new Room(0,1,0,0);
    			}
    			
    			//bottom left corner
    			else if(row1 == 4 && col1 == 0) {
    				dungeon[row1][col1] = new Room(0,0,1,1);
    			}
    			//all West walls
    			else if(col1 == 0 && (row1 == 1 || row1 == 2 || row1 == 3)) {
    				dungeon[row1][col1] = new Room(0,0,0,1);
    			}
    			
    			//bottom right corner
    			else if(row1 == 4 && col1 == 4) {
    				dungeon[row1][col1] = new Room(0,1,1,0);
    			}
    			//all South walls
    			else if(row1 == 4 &&  (col1 == 1 || col1 == 2 || col1 == 3)) {
    				dungeon[row1][col1] = new Room(0,0,1,0);
    			}
    			else {
    				dungeon[row1][col1] = new Room(0,0,0,0);
    			}
    			
    			//setting entrance and exit
    			dungeon[0][0].map.clear();
    			dungeon[0][0].map.put("Entrance", 1);
    			dungeon[4][4].map.clear();
    			dungeon[4][4].map.put("Exit", 1);
    			
    			
    		}
    	}
    	
    	//dungeon.toString();
    	int randoRow = new Random().nextInt(5);
    	int randoCol = new Random().nextInt(5);
    	int count = 0;
    	
    	while(count != 4) {
			if(dungeon[randoRow][randoCol].hasPillar() || dungeon[randoRow][randoCol].hasEntrance() || dungeon[randoRow][randoCol].hasExit()) {
				randoRow = new Random().nextInt(5);
				randoCol = new Random().nextInt(5);
			}
			dungeon[randoRow][randoCol].map.put("Pillar", 1);
			count++;
		}
    	
    	
	}
	
	

	
	public boolean isDoor(int wall) {
		return wall == 1;

    }

	

	public void setSpawn(int row, int col) {

		
	}

	
	public void movePlayer(DungeonCharacter player, Room room) {
		Scanner kin = new Scanner(System.in);
		System.out.println("Which direction do you want to go?: \n"
							+ "N, S, E, W? ");
							
		if(kin.next().equalsIgnoreCase("N")) {
			if(room.getN() == 1) {
				System.out.println("You ran into a wall, choose another direction.");
			}
		}
	}
	
	public void enterRoom() {
		
	}
	
	public void playerLocation() {
		
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

	

	 
	  public String location() {
		  return "";
	  }

	 


	public void printDungeon(Room[][] dungeon) {

		for(int row1 = 0; row1 < dungeon.length; row1++) {
    		for(int col1 = 0; col1 < dungeon[row1].length; col1++) {
    			System.out.println(dungeon[row1][col1] + " ");
    		
    		}
		}
	}

}
