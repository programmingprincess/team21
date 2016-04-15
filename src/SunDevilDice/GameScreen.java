package SunDevilDice;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.*;
import net.miginfocom.swing.MigLayout;

public class GameScreen extends JPanel {

	private TurnPanel turnPanel;
	private JButton menu;
	private HashMap<String, PlayerSeat> seatDictionary = new HashMap<String, PlayerSeat>(); // a map of player names to their respective PlayerSeat
	private String currentSeat;
	/**
	 * Create the panel.
	 */
	public GameScreen(Vector<String> playerList) {
		
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		
		turnPanel = new TurnPanel(playerList);
		add(turnPanel, "cell 1 1,grow");
		
		if(playerList.size() > 0) {
			PlayerSeat playerSeat1 = new PlayerSeat(playerList.get(0));
			add(playerSeat1, "cell 0 1,grow");
			seatDictionary.put(playerList.get(0), playerSeat1);
			currentSeat = playerList.get(0);
			
			playerSeat1.setBorder(new LineBorder(Color.RED, 4, true));
		}
		
		if(playerList.size() > 1) {
			PlayerSeat playerSeat2 = new PlayerSeat(playerList.get(1));
			add(playerSeat2, "cell 2 1,grow");
			seatDictionary.put(playerList.get(1), playerSeat2);
		}

		if(playerList.size() > 2) {
			PlayerSeat playerSeat3 = new PlayerSeat(playerList.get(2));
			add(playerSeat3, "cell 1 0,grow");
			seatDictionary.put(playerList.get(2), playerSeat3);
		}
		
		if(playerList.size() > 3) {
			PlayerSeat playerSeat4 = new PlayerSeat(playerList.get(3));
			add(playerSeat4, "cell 1 2,grow");
			seatDictionary.put(playerList.get(3), playerSeat4);
		}


		if(playerList.size() > 4) {
			PlayerSeat playerSeat5 = new PlayerSeat(playerList.get(4));
			add(playerSeat5, "cell 0 0,grow");
			seatDictionary.put(playerList.get(4), playerSeat5);
		}

		if(playerList.size() > 5) {
			PlayerSeat playerSeat6 = new PlayerSeat(playerList.get(5));
			add(playerSeat6, "cell 2 0,grow");
			seatDictionary.put(playerList.get(5), playerSeat6);
		}
		
		if(playerList.size() > 6) {
			PlayerSeat playerSeat7 = new PlayerSeat(playerList.get(6));
			add(playerSeat7, "cell 0 2,grow");
			seatDictionary.put(playerList.get(6), playerSeat7);
		}
		
		if(playerList.size() > 7) {
			PlayerSeat playerSeat8 = new PlayerSeat(playerList.get(7));
			add(playerSeat8, "cell 2 2,grow");
			seatDictionary.put(playerList.get(7), playerSeat8);
		}
	}
	

	/**
	 * updates the UI with the current score for the given player
	 * @param player the player whose score is to be updated
	 * @param newScore the value of the updated score
	 */
	public void updatePlayerScore(String player, int newScore){
		seatDictionary.get(currentSeat).setScore(newScore);
	}
	
	/**
	 * Highlights the border of the given player and rests the border of the current player, then updates current player
	 * @param player the player whose seat border is to be updated
	 */
	public void updatePlayerBorder(String player){
		seatDictionary.get(currentSeat).setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		seatDictionary.get(player).setBorder(new LineBorder(Color.RED, 4, true));
		currentSeat = player;
	}
}
