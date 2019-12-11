package dungeon;


import java.util.Scanner;

public class HeroFactory {
	private Scanner input;
	public Hero createHero(){
		int choice;

		System.out.println("Choose a hero:\n" +
					       "1. Warrior\n" +
						   "2. Sorceress\n" +
						   "3. Thief\n" +
						   "4. King Khan\n" +
						   "5. Big Boss");
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
		}else if(choice == 4){
			hero = new KingKhan();
			return hero;
		}else if(choice == 5){
			hero = new BigBoss();
			return hero;
		}else{
			System.out.println("invalid choice, returning Thief");
		     return new Thief();
		}
		
		
	}

}
