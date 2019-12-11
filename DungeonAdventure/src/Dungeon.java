




import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Dungeon {
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

	

	public Dungeon(int row, int col) {
		Room[][] dungeon = new Room[row][col];
		
		
	    
    	for(int row1 = 0; row1 < col; row1++) {
    		for(int col1 = 0; col1 < row; col1++) {
    			dungeon[row1][col1] = new Room(0,0,0,0);
    		}
    	}
    	
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
	
	public void spawnPillar(Room[][] room) {
		int row = 0;
		int col = 0;
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
	
	
	 
	  public String location() {
		  return "";
	  }
	
	
	
	public String toString() {
		
		
		return "";
	}
	
	
	

}

    