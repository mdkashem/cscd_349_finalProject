
package dungeon;
import java.util.*;
public class Room {

		//Monster == 1
		//HealingPotion == 2
		//Pit == 4
		//Pillar == 10
	
	
	private int N;
	private int E;
	private int S;
	private int W;
	private Object entrance;
	private Object exit;
	private Object pillar;
	private int healingPotion;
	private int pit;
	//private MonsterFactory Monster;
	
	
	protected HashMap<String, Object> map = new HashMap();
	
	
	
	public Room(int N, int E, int S, int W) {
		this.N = N;
		this.E = E;
		this.S = S;
		this.W = W;
		
		if(Math.random() <= .7) {
			map.put("Monster", new MonsterFactory().generateMonster());
		}
		if(Math.random() <= .3) {
			map.put("Pit", 1);
		}
		if(Math.random() <= .3) {
			map.put("Health Potion", 1);
		}
		
		
	}
	
	
	public int getHealingPotion() {
		return healingPotion;
	}

	public void setHealingPotion(int healingPotion) {
		this.healingPotion = healingPotion;
	}

	public int getPit() {
		return pit;
	}

	public void setPit(int pit) {
		this.pit = pit;
	}
	
	public Object getPillar() {
		return pillar;
	}
	
	public void setPillar(Object pillar) {
		this.pillar = pillar;
	}
	
//	public int setMonster(int monster) {
//		this.Monster = new MonsterFactory();
//		this.Monster.generateMonster();
//		return monster;
//		
//	}
	
	public Object getEntrance() {
		return entrance;
	}

	public void setEntrance(Object entrance) {
		this.entrance = entrance;
	}

	public Object getExit() {
		return exit;
	}

	public void setExit(int exit) {
		this.exit = exit;
	}

	
	public String toString() {
		char randomChar = 'E';
		
		String n = "";
		String e = "";
		String s = "";
		String w = "";
		
		
		
		if(map.containsValue(entrance)) {
			randomChar = 'I';
		}
		else if(map.containsValue(exit)) {
			randomChar = 'O';
		}
		else if(map.containsKey("Health Potion")) {
			randomChar = 'H';
		}
		else if(map.containsKey("Monster")) {
			randomChar = 'X';
		}
		else if(map.containsKey("Pit")) {
			randomChar = 'P';
		}
		else if(map.isEmpty()) {
			randomChar = 'E';
		}
		else if (map.size() > 1) {
			randomChar = 'M';
		}
		
		if(N == 1) {
			n = "*";
		}
		else {
			n = "-";
		}
		if(E == 1) {
			e = "*";
		}
		else {
			e = "|";
		}
		if(S == 1) {
			s = "*";
		}
		else {
			s = "-";
		}
		if(W == 1) {
			w = "*";
		}
		else {
			w = "|";
		}
		
		String top = "* " + n + " *";
		String middle =  w + " " + randomChar + " " + e;
		String bottom = "* " + s + " *";
		
		String boop = 	top + "\n"
						+ middle + "\n"
						+ bottom;
		
		
		return boop;
		
	}
	
	
	
	
	public boolean hasPillar() {
		if(this.getPillar() != null) {
			return true;
		}
		return false;
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
	
	
	  
	  
	 
	
	
	
	
}