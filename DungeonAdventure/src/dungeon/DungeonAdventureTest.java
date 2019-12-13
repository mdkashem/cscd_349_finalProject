package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DungeonAdventureTest {

	@Test
	void testMovePlayer() throws Exception {
		Room testRoom = new Room(2,2,2,2);
		Hero testHero = new Thief();
		
		char testChar = DungeonAdventure.movePlayer(testHero, testRoom);
		
		assertTrue(testChar == 'N' || testChar == 'W' || testChar == 'S' || testChar == 'E');
	}

	@Test
	void testPlayAgain() {
		//type Y or y into console for a positive test
		assertTrue(DungeonAdventure.playAgain());
		
		//type anything other than y or Y for a positive test
		//assertTrue(!DungeonAdventure.playAgain());
	}

	@Test
	void testEnterRoom() {
		Room testRoom = new Room(2,2,2,2);
		
		DungeonAdventure.enterRoom(testRoom);
		
		//no assertions, verify test via console
	}

	@Test
	void testBattle() {
		Hero testHero = new Thief();
		Monster testMonster = new Ogre();
		
		DungeonAdventure.battle(testHero, testMonster);
		
		//no assertions, verify test via console
	}

	@Test
	
	//Tests both saveGame and loadGame
	void testSaveGame() {
		Hero testHero = new Thief();
		Dungeon testDungeon = new Dungeon(2,2);
		
		DungeonAdventure.saveGame(testHero, testDungeon);
		
		Dungeon testDungeon2 = DungeonAdventure.loadGame(testHero);
		
		assertTrue(testDungeon2 != null);
	}


}
