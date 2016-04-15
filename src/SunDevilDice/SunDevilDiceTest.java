package SunDevilDice;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class SunDevilDiceTest {

	// ##### Test Die class #####
	
	// test that a new die is constructed
	@Test
	public void testDieConstructor() {
		Die testDie = new Die();
		assertNotNull(testDie);
	}
	
	// test that a new die is initialized with face of -1
	@Test
	public void testNewDieFace() {
		Die testDie = new Die();
		assertEquals(-1, testDie.getFace());
	}
	
	// test that die face is equal to the last roll
	@Test
	public void testRollDieFace() {
		Die testDie = new Die();
		assertEquals(-1, testDie.getFace());
		int roll1 = testDie.roll();
		assertEquals(roll1, testDie.getFace());
	}

	// ##### Test Actions class #####
	
	// test that new actions is properly constructed
	@Test
	public void testActionsConstructor() {
		Vector<String> playerList = new Vector<>();
		playerList.add("player1");
		playerList.add("player2");
		playerList.add("player3");
		Actions testGame = new Actions(playerList);
		assertNotNull(testGame);
	}
	
	// test that player scores are initialized to zero
	@Test
	public void testInitialScores() {
		Vector<String> playerList = new Vector<>();
		playerList.add("player1");
		playerList.add("player2");
		playerList.add("player3");
		Actions testGame = new Actions(playerList);
		assertEquals(0, testGame.getTotalScore("player1"));
		assertEquals(0, testGame.getTotalScore("player2"));
		assertEquals(0, testGame.getTotalScore("player3"));
	}
	// test that round score is initialized and adjusted properly
	@Test
	public void testRoundScore() {
		Vector<String> playerList = new Vector<>();
		playerList.add("player1");
		playerList.add("player2");
		playerList.add("player3");
		Actions testGame = new Actions(playerList);
		assertEquals(0, testGame.getRoundScore());
		testGame.updateRoundScore(12);
		assertEquals(12, testGame.getRoundScore());
	}	

	// test that round score is reset on turn change
	@Test
	public void testRoundScoreTurnChange() {
		Vector<String> playerList = new Vector<>();
		playerList.add("player1");
		playerList.add("player2");
		playerList.add("player3");
		Actions testGame = new Actions(playerList);
		assertEquals(0, testGame.getRoundScore());
		testGame.updateRoundScore(12);
		assertEquals(12, testGame.getRoundScore());
		testGame.nextTurn();
		assertEquals(0, testGame.getRoundScore());
	}	
	
	// test that turns are started and rotated appropriately
	@Test
	public void testTurnRotation() {
		Vector<String> playerList = new Vector<>();
		playerList.add("player1");
		playerList.add("player2");
		playerList.add("player3");
		Actions testGame = new Actions(playerList);
		String player1 = testGame.startGame();
		assertEquals("player1", player1);
		String player2 = testGame.nextTurn();
		assertEquals("player2", player2);
		String player3 = testGame.nextTurn();
		assertEquals("player3", player3);
		assertEquals(player1, testGame.nextTurn());
	}	
	// test that scores are updated on hold
	@Test
	public void testHold(){
		Vector<String> playerList = new Vector<>();
		playerList.add("player1");
		playerList.add("player2");
		playerList.add("player3");
		Actions testGame = new Actions(playerList);
		String player1 = testGame.startGame();
		testGame.updateRoundScore(12); 
		String player2 = testGame.nextTurn();
		testGame.updateRoundScore(12);
		testGame.hold(); // set player 2 score to round score = 12
		testGame.updateRoundScore(12);
		testGame.updateRoundScore(54);
		testGame.hold(); // set player 3 score to round score = 66
		assertEquals(0, testGame.getTotalScore(player1));
		assertEquals(12, testGame.getTotalScore(player2));
		assertEquals(66, testGame.getTotalScore("player3"));
	}

}
