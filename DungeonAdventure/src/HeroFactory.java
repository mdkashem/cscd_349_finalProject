

import java.util.Scanner;

public class HeroFactory {
	private Scanner input;
	public Hero createHero(){
		int choice;

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief");
		 input = new Scanner(System.in);
		choice = input.nextInt();
		Hero hero = null;
		if(choice == 1){
			hero = new Warrior();
			return hero;
		}else if(choice == 2){
			hero=new Sorceress();
			return hero;
		}else if(choice == 3){
			hero = new Thief();
			return hero;
		}else{
			System.out.println("invalid choice, returning Thief");
		     return new Thief();
		}
		
		
	}

}
