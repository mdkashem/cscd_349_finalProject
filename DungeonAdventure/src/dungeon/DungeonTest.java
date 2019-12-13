package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DungeonTest {

	@Test
	void testCreateDungeon() {
		Dungeon testDungeon = new Dungeon(2,2);
		
		Room[][] testRooms = testDungeon.createDungeon();
		
		assertTrue(testRooms.length == 2 && testRooms[1].length == 2);
	}

	@Test
	void testPlayerLocation() {
		Dungeon testDungeon = new Dungeon(2,2);
		
		Room[][] testRooms = testDungeon.createDungeon();
		
		Room testRoom = testDungeon.playerLocation(1, 1, testRooms);
		
		assertTrue(testRoom != null);
	}

	@Test
	void testPrintDungeon() {
		Dungeon testDungeon = new Dungeon(2,2);
		
		testDungeon.printDungeon();
		
		//No assertion for this test as it is visual via console.
	}

}
