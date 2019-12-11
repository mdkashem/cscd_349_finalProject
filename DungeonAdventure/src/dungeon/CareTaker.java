package dungeon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	public void SavedToFile(String Hero, int healing, int vision, int pillars){
		//List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();
		Originator originator = new Originator();
		originator.setNameOfHero(Hero);
		originator.setNumOfHealing(healing);
		originator.setNumOfVision(vision);
		originator.setnumOfPillars(pillars);
		//savedStates.add(originator.saveToMemento());
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("savedGame.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(originator);
	         out.close();
	         fileOut.close();
	         System.out.println("game saved successfully");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
		
	}
	
	public Originator loadState(){
		Originator e = null;
	      try {
	         FileInputStream fileIn = new FileInputStream("savedGame.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         e = (Originator) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         //return;
	      } catch (ClassNotFoundException c) {
	         System.out.println(" Originator class not found");
	         c.printStackTrace();
	        // return;
	      }
	      
		
		
		return e;
		
	}

}
