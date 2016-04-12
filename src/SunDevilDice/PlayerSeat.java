package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PlayerSeat extends JPanel {

	private String playerName;
	private JLabel scoreLabel;
	private JLabel nameLabel;

	/**
	 * Create the panel.
	 */
	public PlayerSeat(String _playerName) {
		setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setLayout(new MigLayout("", "[grow]", "[grow][grow][grow]"));

		JPanel panel = new JPanel();
		add(panel, "cell 0 0,grow");
		panel.setLayout(new BorderLayout(0, 0));

		nameLabel = new JLabel(_playerName);
		nameLabel.setFont(new Font("Narkisim", Font.PLAIN, 24));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(nameLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 0 1,grow");
		panel_1.setLayout(new BorderLayout(0, 0));

		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel_1.add(scoreLabel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 2,grow");

	}

	public void setPlayerName(String newPlayerName) {
		playerName = newPlayerName;
		nameLabel.setText(playerName);
	}

	public void setScore(int score) {
		scoreLabel.setText("Score: " + score);
	}
}
