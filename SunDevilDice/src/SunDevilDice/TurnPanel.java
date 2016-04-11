package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class TurnPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public TurnPanel() {
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));

		JPanel panel = new JPanel();
		add(panel, "cell 1 0,grow");

		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 1,grow");

		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 1 2,grow");

		DiePanel diePanel1 = new DiePanel();
		add(diePanel1, "cell 0 3,grow");

		DiePanel diePanel2 = new DiePanel();
		add(diePanel2, "cell 1 3,grow");

		DiePanel diePanel3 = new DiePanel();
		add(diePanel3, "cell 2 3,grow");

	}

}
