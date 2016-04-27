package SunDevilDice;

import java.util.HashMap;
import java.util.Vector;
import java.io.*;

public class Actions implements GameInterface {
	
	private HashMap<String, Integer> scoreDictionary = new HashMap<String, Integer>(); // stores a map of player names to scores
	private int roundScore;		// the score for the current round
	private int turnNumber;		// the turn number corresponding to the index of a player
	private Vector<String> playerList;	// a list of player in the current game
	public static final int SCORE_THRESHOLD = 200;	// the score threshold needed to win the game
	public Vector<ScoreObj> highScores = new Vector<ScoreObj>(); // loads and stores local high score list
	
	/**
	 * Constructs an actions object
	 * @param playerList the list of players of the game
	 */
	public Actions(Vector<String> playerList){
		this.playerList = playerList;
		this.turnNumber = 0;
		
		for(int playerIndex = 0; playerIndex < playerList.size(); playerIndex++){
			scoreDictionary.put(playerList.get(playerIndex), 0); // initialize player scores to 0
		}
	}

	/**
	 * gets the current total score for the given player
	 * @param player the player whose score is requested
	 * @return the player's score
	 */
	public int getTotalScore(String player) {
		return scoreDictionary.get(player);
	}
	
	/**
	 * gets the current round score
	 * @return the round score
	 */
	public int getRoundScore() {
		return roundScore;
	}
	
	/**
	 * adds the given value to the current round score
	 * @param value the value to add
	 */
	public void updateRoundScore(int value) {
		roundScore += value;
	}

	/**
	 * starts the game, returning the name of the player whose turn is first
	 * @return the player name
	 */
	public String startGame(){
		return playerList.get(0);
	}
	
	/**
	 * returns the player whose turn is next and prepares the game for the next turn.
	 * @return the name of player whose turn is next
	 */
	public String nextTurn(){
		turnNumber++;
		
		// loop back to the first player at the end
		if(turnNumber >= playerList.size()){
			turnNumber = 0;
		}
		
		roundScore = 0; // reset score for the next turn
		return playerList.get(turnNumber);
	}
	
	/**
	 * performs a hold for the current player and ends the turn, returning the name of the player whose turn is next
	 * @return name of the player whose turn is next
	 */
	public String hold(){
		scoreDictionary.put(playerList.get(turnNumber), getTotalScore(playerList.get(turnNumber)) + roundScore);
		return nextTurn();
	}

	/**
	 * Updates the winning score and returns the resulting scores as a string
	 * @return the string representation of final score standings
	 */
	public String getWinner(){
		scoreDictionary.put(playerList.get(turnNumber), getTotalScore(playerList.get(turnNumber)) + roundScore);
		return getScoresString();
	}
	
	/**
	 *  creates a string representation of scores
	 * @return a string representation of scores
	 */
	private String getScoresString(){
		loadScores();
		String scores = "<html><table>";		//return scores in the form of a table
		
		for(int playerIndex = 0; playerIndex < playerList.size(); playerIndex++){
			scores += "<tr>";
			scores += extractMax();
			scores += "</tr>";
		}
		
		scores += "</table></html>";
		saveScores();
		return scores;
	}
	
	/**
	 * Extract the player with the highest score
	 * @return a string containing the max player and corresponding score
	 */
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
			
			if(value > max){
				max = value;
				maxPlayer = playerName;
			}
		}
		scoreDictionary.remove(maxPlayer);
		addScore(maxPlayer, max);
		return "<td>" + maxPlayer + "</td><td>" + max + "</td>";
	}
	
	/** 
	 * Loads local file high score list
	 */
	public void loadScores() {
		BufferedReader in;
		try {
			ScoreObj currentScore;
			in = new BufferedReader(new FileReader("scores.txt"));
			String line = "";
	        while ((line = in.readLine()) != null) {
	            String parts[] = line.split("\t");
	            currentScore = new ScoreObj(parts[0], Integer.parseInt(parts[1]));
	            highScores.add(currentScore);
	        }
	        in.close();
		}
		catch(Exception exception) {
			
		}
	}
	
	/**
	 * Adds each individual score from current game to high score list if possible
	 * 
	 * @param playerName name of player
	 * @param score number of points scored by player
	 */
	private void addScore(String playerName, int score) {
		ScoreObj currentScore = new ScoreObj(playerName, score);
		int index = 0;
		while(score < highScores.get(index).score && index < 10) {
			index++;
		}
		if(index != 10) {
			if(highScores.size() == 10) {
				highScores.remove(9);
			}
			highScores.add(index, currentScore);
		}
	}
	
	/**
	 * Saves scoreboard back to local file
	 */
	private void saveScores() {
		PrintWriter pw;
		try {
			pw = new PrintWriter("scores.txt", "UTF-8");
			for(ScoreObj so : highScores) {
				System.out.println(so.name + "\t" + so.score);
				pw.println(so.name + "\t" + so.score);
			}
			pw.close();
		}
		catch(Exception exception) {
			
		}
	}

	/**
	 *  resets the score of the player whose turn it currently is.
	 */
	public void resetScore(){
		scoreDictionary.put(playerList.get(turnNumber), 0);
	}
}
