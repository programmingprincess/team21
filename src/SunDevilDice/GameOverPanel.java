package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GameOverPanel extends JPanel {

	// made public for testing purposes
	public JButton newGameButton;
	public JButton exitButton;
	public CardLayout cards;

	/**
	 * Create the panel.
	 */
	public GameOverPanel(String results, String winner) {
		setBackground(Color.BLACK);
		setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow]"));

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		add(panel, "cell 0 0,grow");

		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(Color.decode(MainWindow.maroon));
		add(centerPanel, "cell 1 0 2 1,grow");
		centerPanel.setLayout(new BorderLayout(0, 0));

		JLabel resultLabel = new JLabel(results);
		resultLabel.setForeground(Color.decode(MainWindow.gold));
		resultLabel.setFont(new Font("Narkisim", Font.PLAIN, 24));
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		centerPanel.add(resultLabel, BorderLayout.CENTER);

		JLabel winnerLabel = new JLabel("Winner: " + winner);
		winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		winnerLabel.setFont(new Font("Narkisim", Font.BOLD, 30));
		centerPanel.add(winnerLabel, BorderLayout.NORTH);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(Color.decode(MainWindow.gold));
		centerPanel.add(buttonsPanel, BorderLayout.SOUTH);
		buttonsPanel.setLayout(new MigLayout("", "[grow]", "[][][][grow]"));

		newGameButton = new JButton("New Game");
		newGameButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		buttonsPanel.add(newGameButton, "cell 0 0,grow");

		/*JButton hiScoresButton = new JButton("View High Scores");
		hiScoresButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		buttonsPanel.add(hiScoresButton, "cell 0 1,grow");*/

		exitButton = new JButton("Exit Game");
		exitButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		buttonsPanel.add(exitButton, "cell 0 2,grow");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		add(panel_3, "cell 3 0,grow");

		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JPanel parent = getMainPanel();
				cards = (CardLayout) (parent.getLayout());
				cards.first(parent);
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});		
	}

	// returns the parent of this panel
	private JPanel getMainPanel() {
		JPanel parent = (JPanel) this.getParent();
		return parent;
	}

}
