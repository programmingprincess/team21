package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class DiePanel extends JPanel {

	// the panels for the pips on the die face
	private PipPanel pipPanel00;
	private PipPanel pipPanel01;
	private PipPanel pipPanel02;
	private PipPanel pipPanel10;
	private PipPanel pipPanel11;
	private PipPanel pipPanel12;
	private PipPanel pipPanel20;
	private PipPanel pipPanel21;
	private PipPanel pipPanel22;

	/**
	 * Create the panel.
	 */
	public DiePanel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));

		pipPanel00 = new PipPanel();
		add(pipPanel00, "cell 0 0,grow");

		pipPanel01 = new PipPanel();
		add(pipPanel01, "cell 1 0,grow");

		pipPanel02 = new PipPanel();
		add(pipPanel02, "cell 2 0,grow");

		pipPanel10 = new PipPanel();
		add(pipPanel10, "cell 0 1,grow");

		pipPanel11 = new PipPanel();
		add(pipPanel11, "cell 1 1,grow");

		pipPanel12 = new PipPanel();
		add(pipPanel12, "cell 2 1,grow");

		pipPanel20 = new PipPanel();
		add(pipPanel20, "cell 0 2,grow");

		pipPanel21 = new PipPanel();
		add(pipPanel21, "cell 1 2,grow");

		pipPanel22 = new PipPanel();
		add(pipPanel22, "cell 2 2,grow");

		// initially set each pip to not be visible
		pipPanel00.setVisible(true);
		pipPanel01.setVisible(false);
		pipPanel02.setVisible(true);
		pipPanel10.setVisible(true);
		pipPanel11.setVisible(false);
		pipPanel12.setVisible(true);
		pipPanel20.setVisible(true);
		pipPanel21.setVisible(false);
		pipPanel22.setVisible(true);
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#reshape(int, int, int, int)
	 */
	public void reshape(int x, int y, int width, int height) {
		// maintain square dimensions
		if (width < height) {
			height = width;
		} else {
			width = height;
		}

		super.reshape(x, y, width, height);
	}

	/**
	 * shows the given value on the face of the die panel
	 * @param value the value to display
	 */
	public void showValue(int value) {
		switch (value) {
		case 1:
			pipPanel00.setVisible(false);
			pipPanel01.setVisible(false);
			pipPanel02.setVisible(false);
			pipPanel10.setVisible(false);
			pipPanel11.setVisible(true);
			pipPanel12.setVisible(false);
			pipPanel20.setVisible(false);
			pipPanel21.setVisible(false);
			pipPanel22.setVisible(false);
			break;
		case 2:
			pipPanel00.setVisible(false);
			pipPanel01.setVisible(false);
			pipPanel02.setVisible(true);
			pipPanel10.setVisible(false);
			pipPanel11.setVisible(false);
			pipPanel12.setVisible(false);
			pipPanel20.setVisible(true);
			pipPanel21.setVisible(false);
			pipPanel22.setVisible(false);
			break;
		case 3:
			pipPanel00.setVisible(false);
			pipPanel01.setVisible(false);
			pipPanel02.setVisible(true);
			pipPanel10.setVisible(false);
			pipPanel11.setVisible(true);
			pipPanel12.setVisible(false);
			pipPanel20.setVisible(true);
			pipPanel21.setVisible(false);
			pipPanel22.setVisible(false);
			break;
		case 4:
			pipPanel00.setVisible(true);
			pipPanel01.setVisible(false);
			pipPanel02.setVisible(true);
			pipPanel10.setVisible(false);
			pipPanel11.setVisible(false);
			pipPanel12.setVisible(false);
			pipPanel20.setVisible(true);
			pipPanel21.setVisible(false);
			pipPanel22.setVisible(true);
			break;
		case 5:
			pipPanel00.setVisible(true);
			pipPanel01.setVisible(false);
			pipPanel02.setVisible(true);
			pipPanel10.setVisible(false);
			pipPanel11.setVisible(true);
			pipPanel12.setVisible(false);
			pipPanel20.setVisible(true);
			pipPanel21.setVisible(false);
			pipPanel22.setVisible(true);
			break;
		case 6:
			pipPanel00.setVisible(true);
			pipPanel01.setVisible(false);
			pipPanel02.setVisible(true);
			pipPanel10.setVisible(true);
			pipPanel11.setVisible(false);
			pipPanel12.setVisible(true);
			pipPanel20.setVisible(true);
			pipPanel21.setVisible(false);
			pipPanel22.setVisible(true);
			break;
		}
	}

}
