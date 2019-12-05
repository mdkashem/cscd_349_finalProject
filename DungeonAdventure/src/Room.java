import java.util.LinkedList;

public class Room {

	private Object pillar;
	private Object healingPotion;
	private Object pit;
	
	public Room(Object pillar, Object healingPotion, Object pit) {
		this.pillar = pillar;
		this.healingPotion = healingPotion;
		this.pit = pit;
	}
	
	public Room() {
	}
	
	
	Room room = new Room();
	
	
	
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

	public void healingChance() {
		if (Math.random() <= .4) {
			this.setHealingPotion(this.getHealingPotion());
		}
	}
	

	public String toString() {
		char randomChar = 'x';
		String result = "";
		
		
		
		return "* - *" + "\n" + "| " + randomChar + " |" + "\n" + "* - *";
		
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
	  
	  public boolean hasExit() { if(this.getExit() != null) { return true; } return
	  false; }
	 
	
	
	
	
}
