




import java.util.Arrays;
import java.util.Random;

public class Dungeon {
	
	private Room entrance;
	private Room exit;
	
	
	
	
	
	
	
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
	
	
	
	public static void createDungeon() {
    	Room[][] dungeon = new Room[5][5];
    	dungeon[0][0] = new Room();
    
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
	
	public void placePillar(Room[][] room) {
		int row = new Random().nextInt(6);
		int col = new Random().nextInt(6);
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
	
	
	
	public String toString() {
		Room[][] array = new Room[5][5];
		System.out.println(Arrays.deepToString(array));
		
		return "test";
	}

}

    