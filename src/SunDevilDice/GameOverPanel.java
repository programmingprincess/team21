package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GameOverPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GameOverPanel(String results, String winner) {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow]"));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel, "cell 0 0,grow");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1, "cell 1 0 2 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel resultLabel = new JLabel(results);
		resultLabel.setFont(new Font("Narkisim", Font.PLAIN, 24));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(resultLabel, BorderLayout.CENTER);

		JLabel winnerLabel = new JLabel("Winner: " + winner);
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winnerLabel.setFont(new Font("Narkisim", Font.BOLD, 30));
		panel_1.add(winnerLabel, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		add(panel_3, "cell 3 0,grow");

	}

}
