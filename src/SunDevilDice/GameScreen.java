package SunDevilDice;

import javax.swing.JPanel;
import java.util.*;
import net.miginfocom.swing.MigLayout;

public class GameScreen extends JPanel {

	private TurnPanel turnPanel;

	/**
	 * Create the panel.
	 */
	public GameScreen(Vector<String> playerList) {
		
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));
		turnPanel = new TurnPanel();
		add(turnPanel, "cell 1 1,grow");
		
		if(playerList.size() > 0) {
			PlayerSeat playerSeat1 = new PlayerSeat(playerList.get(0));
			add(playerSeat1, "cell 0 1,grow");
		}
		
		if(playerList.size() > 1) {
			PlayerSeat playerSeat2 = new PlayerSeat(playerList.get(1));
			add(playerSeat2, "cell 2 1,grow");
		}

		if(playerList.size() > 2) {
			PlayerSeat playerSeat3 = new PlayerSeat(playerList.get(2));
			add(playerSeat3, "cell 1 0,grow");
		}
		
		if(playerList.size() > 3) {
			PlayerSeat playerSeat4 = new PlayerSeat(playerList.get(3));
			add(playerSeat4, "cell 1 2,grow");
		}


		if(playerList.size() > 4) {
			PlayerSeat playerSeat5 = new PlayerSeat(playerList.get(4));
			add(playerSeat5, "cell 0 0,grow");
		}

		if(playerList.size() > 5) {
			PlayerSeat playerSeat6 = new PlayerSeat(playerList.get(5));
			add(playerSeat6, "cell 2 0,grow");
		}
		
		if(playerList.size() > 6) {
			PlayerSeat playerSeat7 = new PlayerSeat(playerList.get(6));
			add(playerSeat7, "cell 0 2,grow");
		}
		
		if(playerList.size() > 7) {
			PlayerSeat playerSeat8 = new PlayerSeat(playerList.get(7));
			add(playerSeat8, "cell 2 2,grow");
		}
	}

}
