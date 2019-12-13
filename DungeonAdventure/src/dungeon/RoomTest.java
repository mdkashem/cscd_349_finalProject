package dungeon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoomTest {

	@Test
	void testSpawn() {
		Room testRoom = new Room(1, 1, 1, 1);
		
		Hero testHero = new Thief();
		
		testRoom.spawn(testHero);
		
		assertTrue(testRoom.map.containsKey("Hero"));
	}

}
