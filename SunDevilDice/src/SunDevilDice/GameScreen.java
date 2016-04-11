package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class GameScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameScreen() {
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));

		PlayerSeat playerSeat1 = new PlayerSeat();
		add(playerSeat1, "cell 0 0,grow");

		PlayerSeat playerSeat2 = new PlayerSeat();
		add(playerSeat2, "cell 1 0,grow");

		PlayerSeat playerSeat3 = new PlayerSeat();
		add(playerSeat3, "cell 2 0,grow");

		PlayerSeat playerSeat4 = new PlayerSeat();
		add(playerSeat4, "cell 0 1,grow");

		TurnPanel turnPanel = new TurnPanel();
		add(turnPanel, "cell 1 1,grow");

		PlayerSeat playerSeat5 = new PlayerSeat();
		add(playerSeat5, "cell 2 1,grow");

		PlayerSeat playerSeat6 = new PlayerSeat();
		add(playerSeat6, "cell 0 2,grow");

		PlayerSeat playerSeat7 = new PlayerSeat();
		add(playerSeat7, "cell 1 2,grow");

		PlayerSeat playerSeat8 = new PlayerSeat();
		add(playerSeat8, "cell 2 2,grow");

	}

}
