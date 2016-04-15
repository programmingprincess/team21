package SunDevilDice;

import java.util.HashMap;
import java.util.Vector;

public class Actions implements GameInterface {
	
	private HashMap<String, Integer> scoreDictionary = new HashMap<String, Integer>();
	private int roundScore;
	private int turnNumber;
	private Vector<String> playerList;
	public static final int scoreThreshold = 200;
	
	public Actions(Vector<String> playerList){
		this.playerList = playerList;
		this.turnNumber = 0;
		for(int playerIndex = 0; playerIndex < playerList.size(); playerIndex++){
			scoreDictionary.put(playerList.get(playerIndex), 0); // initialize player scores to 0
		}
	}
	
	public int getTotalScore(String player) {
		return scoreDictionary.get(player);
	}
	
	public int getRoundScore() {
		return roundScore;
	}
	
	public void updateRoundScore(int value) {
		roundScore += value;
	}
	
	public String startGame(){
		return playerList.get(0);
	}
	
	public void increaseRoundScore(int scoreToAdd){
		roundScore += scoreToAdd;
	}
	
	// returns the player whose turn is next and prepares the game for the next turn.
	public String nextTurn(){
		turnNumber++;
		
		// loop back to the first player at the end
		if(turnNumber >= playerList.size()){
			turnNumber = 0;
		}
		
		roundScore = 0; // reset score for the next turn
		return playerList.get(turnNumber);
	}
	
	// performs a hold for the current player and ends the turn, returning the name of the player whose turn is next
	public String hold(){
		scoreDictionary.put(playerList.get(turnNumber), getTotalScore(playerList.get(turnNumber)) + roundScore);
		return nextTurn();
	}
	
	// Updates the winning score and returns the resulting scores 
	public String getWinner(){
		scoreDictionary.put(playerList.get(turnNumber), getTotalScore(playerList.get(turnNumber)) + roundScore);
		return getScoresString();
	}
	
	// creates a string representation of scores
	public String getScoresString(){
		String scores = "<html>";
		
		for(int playerIndex = 0; playerIndex < playerList.size(); playerIndex++){
			scores += extractMax();
			scores += "<br>";
		}
		scores += "</html>";
		return scores;
	}
	
	private String extractMax(){
		int max = -1;
		String maxPlayer = "";
		
		for(int playerIndex = 0; playerIndex < playerList.size(); playerIndex++){
			String playerName = playerList.get(playerIndex);
			int value;
			try{
				value = scoreDictionary.get(playerName);
			}
			catch(Exception exception){
				value = -1;
			}
			if( value > max){
				max = value;
				maxPlayer = playerName;
			}
		}
		
		scoreDictionary.remove(maxPlayer);
		return maxPlayer + "------------" + max;
	}
	
	// resets the score of the player whose turn it currently is.
	public void resetScore(){
		scoreDictionary.put(playerList.get(turnNumber), 0);
	}
}
