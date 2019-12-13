package dungeon;
import java.util.Random;
import java.util.Scanner;

//Done by Kobe Kupp
	public class Dungeon implements java.io.Serializable {

		
		private int row;
		private int col;
		
		
		
	public Dungeon(int row, int col) {
		
		this.row = row;
		this.col = col;
	}
	
	public Room[][] createDungeon() {
		
		Room[][] dungeon = new Room[this.row][this.col];
		
		//placing walls and filling rooms
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
    			//default room(no walls)
    			else {
    				dungeon[row1][col1] = new Room(0,0,0,0);
    			}
    			
    			
    			
    			
    		}
    	}
    	
    	//setting entrance and exit
    			dungeon[0][0].map.clear();
    			dungeon[0][0].map.put("Entrance", 1);
    			dungeon[4][4].map.clear();
    			dungeon[4][4].map.put("Exit", 1);
    	
    	//placing pillars randomly into
    	//four separate rooms
    	int randoRow = new Random().nextInt(5);
    	int randoCol = new Random().nextInt(5);
    	int count = 0;
    	
    	while(count != 4) {
			while(dungeon[randoRow][randoCol].map.containsKey("Pillar") || 
					dungeon[randoRow][randoCol].map.containsKey("Entrance") ||
					dungeon[randoRow][randoCol].map.containsKey("Exit")) {
				
				randoRow = new Random().nextInt(5);
				randoCol = new Random().nextInt(5);
			}
			dungeon[randoRow][randoCol].map.put("Pillar", 1);
			count++;
		}
    	
    	return dungeon;
    	
	}
	
	
	public Room playerLocation(int x, int y, Room[][] room) {
		return room[x][y];
	}
	
	public void printDungeon(Room[][] room) {
		
		for(int row1 = 0; row1 < col; row1++) {
    		for(int col1 = 0; col1 < row; col1++) {
    			System.out.println(room.toString());
    		}
		}

	}
	
	
	


}
