

import java.util.Arrays;

public abstract class DungeonSpace {
	
	private Object entrance;
	private Object exit;
	private Object healingPotion;
	private Object pit;
	private Object pillar;
	
	
	
	
	
	
	public Object getEntrance() {
		return entrance;
	}

	public void setEntrance(Object entrance) {
		this.entrance = entrance;
	}

	public Object getExit() {
		return exit;
	}

	public void setExit(Object exit) {
		this.exit = exit;
	}

	public Object getHealingPotion() {
		return healingPotion;
	}

	public void setHealingPotion(Object healingPotion) {
		this.healingPotion = healingPotion;
	}

	public Object getPit() {
		return pit;
	}

	public void setPit(Object pit) {
		this.pit = pit;
	}
	
	public Object getPillar() {
		return pillar;
	}
	
	public void setPillar(Object pillar) {
		this.pillar = pillar;
	}

	public static void createDungeon() {
    	Room[][] dungeon = new Room[5][5];
    	dungeon[0][0] = new Room();
    
    }
	
	public void setEntEx(Room[][] array) {
		//if(array[])
	}
	
	public String toString() {
		Room[][] array = new Room[5][5];
		System.out.println(Arrays.deepToString(array));
		
		return "test";
	}

}
