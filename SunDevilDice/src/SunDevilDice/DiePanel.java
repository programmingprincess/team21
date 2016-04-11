package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class DiePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DiePanel() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));

		PipPanel pipPanel00 = new PipPanel();
		add(pipPanel00, "cell 0 0,grow");

		PipPanel pipPanel01 = new PipPanel();
		add(pipPanel01, "cell 1 0,grow");

		PipPanel pipPanel02 = new PipPanel();
		add(pipPanel02, "cell 2 0,grow");

		PipPanel pipPanel10 = new PipPanel();
		add(pipPanel10, "cell 0 1,grow");

		PipPanel pipPanel11 = new PipPanel();
		add(pipPanel11, "cell 1 1,grow");

		PipPanel pipPanel12 = new PipPanel();
		add(pipPanel12, "cell 2 1,grow");

		PipPanel pipPanel20 = new PipPanel();
		add(pipPanel20, "cell 0 2,grow");

		PipPanel pipPanel21 = new PipPanel();
		add(pipPanel21, "cell 1 2,grow");

		PipPanel pipPanel22 = new PipPanel();
		add(pipPanel22, "cell 2 2,grow");

		pipPanel00.setVisible(false);
	}

	public void reshape(int x, int y, int width, int height) {
		// maintain square dimensions
		if (width < height) {
			height = width;
		} else {
			width = height;
		}

		super.reshape(x, y, width, height);
	}

}
