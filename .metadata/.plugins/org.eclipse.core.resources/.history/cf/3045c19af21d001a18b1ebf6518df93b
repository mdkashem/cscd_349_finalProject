package dungeon;
import java.util.List; 
import java.util.ArrayList; 
public class Originator {
	private String nameOfHero;
	private int numOfHealing;
	private int numOfVision;
	private int numOfPillars;
	
	

	public Memento saveToMemento() {
		 System.out.println("Originator: Saving to Memento.");
		 return new Memento(nameOfHero,numOfHealing,numOfVision,numOfPillars);
		 }
	public void restoreFromMemento(Memento memento) {
		nameOfHero = memento.getSavedNameOfHero();
		numOfHealing=memento.getSavedNumOfHealing();
		numOfVision=memento.getSavedNumOfVision();
		numOfPillars= memento.getSavedNumOfPillars();
		 System.out.println("Originator: State after restoring from Memento: " );
		 }
	public void setNameOfHero(String name) {
		 System.out.println("Originator: Setting state to " + nameOfHero);
		 this.nameOfHero = name;
		 }
	public void setNumOfHealing(int healing) {
		 System.out.println("Originator: Setting state to " + numOfHealing);
		 this.numOfHealing = healing;
		 }
	public void setNumOfVision(int vision) {
		 System.out.println("Originator: Setting state to " + numOfVision);
		 this.numOfVision = vision;
		 }
	public void setnumOfPillars(int pillars) {
		 System.out.println("Originator: Setting state to " + numOfPillars);
		 this.numOfPillars = pillars;
		 }
	
	public String getNameOfHero() {
		return nameOfHero;
	}
	public int getNumOfHealing() {
		return numOfHealing;
	}
	public int getNumOfVision() {
		return numOfVision;
	}
	public int getNumOfPillars() {
		return numOfPillars;
	}
	
	
	
	
	public static class Memento {
		private final String nameOfHero;
		private final int numOfHealing;
		private final int numOfVision;
		private  final int numOfPillars;
		
		private Memento(String nameOfHero, int numOfHealing, int numOfVision, int numOfPillars) {
			this.nameOfHero = nameOfHero;
			this.numOfHealing=numOfHealing;
			this.numOfVision=numOfVision;
			this.numOfPillars=numOfPillars;
			 }
			 private String getSavedNameOfHero() {
			 return nameOfHero;
			 }
			 private int getSavedNumOfHealing(){
				 return numOfHealing;
			 }
			 private int getSavedNumOfVision(){
				 return numOfVision;
			 }
			 private int getSavedNumOfPillars(){
				 return numOfPillars;
			 }


	}
	
	
	
}
