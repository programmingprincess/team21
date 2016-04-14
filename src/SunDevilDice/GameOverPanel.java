package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new MigLayout("", "[grow]", "[][][][grow]"));

		JButton newGameButton = new JButton("New Game");
		newGameButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel_2.add(newGameButton, "cell 0 0,grow");

		JButton hiScoresButton = new JButton("View High Scores");
		hiScoresButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel_2.add(hiScoresButton, "cell 0 1,grow");

		JButton exitButton = new JButton("Exit Game");
		exitButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel_2.add(exitButton, "cell 0 2,grow");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		add(panel_3, "cell 3 0,grow");

		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel parent = getMainPanel();
				CardLayout cards = (CardLayout) (parent.getLayout());
				cards.first(parent);
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel parent = getMainPanel();
				CardLayout cards = (CardLayout) (parent.getLayout());
				cards.first(parent);
			}
		});
	}

	private JPanel getMainPanel() {
		JPanel parent = (JPanel) this.getParent();
		return parent;
	}

}
