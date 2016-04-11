package SunDevilDice;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PipPanel extends JPanel {

	private int pipRatio = 4; // the ratio of the size of the pip to its
								// container

	/**
	 * Create the panel.
	 */
	public PipPanel() {
		setBackground(Color.WHITE);

	}

	protected void paintComponent(Graphics graphicsObject) {
		int panelHeight = getHeight();
		int panelWidth = getWidth();

		super.paintComponent(graphicsObject);

		graphicsObject.setColor(Color.BLACK);
		graphicsObject.fillOval(panelWidth / 2 - (panelWidth / pipRatio) / 2,
				panelHeight / 2 - (panelHeight / pipRatio) / 2, panelWidth / pipRatio, panelHeight / pipRatio);
	}

}
