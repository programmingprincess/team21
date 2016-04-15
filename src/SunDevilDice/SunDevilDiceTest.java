package SunDevilDice;

import static org.junit.Assert.*;

import org.junit.Test;

public class SunDevilDiceTest {
	
	@Test
	public void holdScore() {
		fail("Not yet implemented");
	}
	
	@Test
	public void highScore() {
		fail("Not yet implemented");
	}
	
	@Test
	public void addPlayer() {
		SetupScreen setup = new SetupScreen();
		setup.playerNameField.setText("derpjqi");
		setup.addPlayerButton.doClick();
		
		assertEquals(setup.playerList.get(0), "derpjqi");
	}
	
	@Test
	public void addAI() {
		SetupScreen setup = new SetupScreen();
		setup.addAiButton.doClick();
		
		assertEquals(setup.playerList.get(0), "Computer 1");
	}
	
	@Test
	public void deletePlayer() {
		SetupScreen setup = new SetupScreen();
		setup.playerList.add("derpjqi");
		setup.list.setSelectedIndex(0);
		setup.deletePlayerButton.doClick();
		
		
		assertEquals(setup.playerList.size(), 0);
	}

}
