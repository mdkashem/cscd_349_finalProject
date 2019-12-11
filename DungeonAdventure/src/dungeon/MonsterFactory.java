package dungeon;


public class MonsterFactory {
	
	public static Monster generateMonster(){
		int choice;

		choice = (int)(Math.random() * 3) + 1;

		switch(choice)
		{
			case 1: return new Ogre();

			case 2: return new Gremlin();

			case 3: return new Skeleton();
			case 4: return new VillianOne();
			case 5: return new VillianTwo();

			default: System.out.println("invalid choice, returning Skeleton");
				     return new Skeleton();
		}//end switch
	}

}
