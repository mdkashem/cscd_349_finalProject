

public class Room extends DungeonSpace{

	private char door;
	
	
	public void healingChance() {
		if (Math.random() <= .4) {
			this.setHealingPotion(this.getHealingPotion());
		}
	}

	public void setRoom() {
		
	}
	

	public String toString() {
		char randomChar = 'x';
		return "* - *" + "\n" + "| " + randomChar + " |" + "\n" + "* - *";
		
	}
	
	
	
	
	
}
