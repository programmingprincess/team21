package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class TurnPanel extends JPanel {

	private DiePanel diePanel1;
	private DiePanel diePanel2;
	private DiePanel diePanel3;
	private Random randomNumberGenerator;

	/**
	 * Create the panel.
	 */
	public TurnPanel() {
		randomNumberGenerator = new Random();

		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));

		JPanel playerPanel = new JPanel();
		add(playerPanel, "cell 0 0 3 1,alignx center,aligny center");

		JLabel turnLabel = new JLabel("Turn: ");
		turnLabel.setFont(new Font("Narkisim", Font.PLAIN, 24));
		turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerPanel.add(turnLabel);

		JPanel roundScorePanel = new JPanel();
		add(roundScorePanel, "cell 0 1 3 1,alignx center,aligny center");

		JLabel roundScoreLabel = new JLabel("Round Score: ");
		roundScoreLabel.setFont(new Font("Narkisim", Font.PLAIN, 24));
		roundScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		roundScorePanel.add(roundScoreLabel);

		JPanel controlsPanel = new JPanel();
		add(controlsPanel, "cell 0 2 3 1,growx,aligny center");
		controlsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton rollButton = new JButton("Roll");
		rollButton.setFont(new Font("Narkisim", Font.PLAIN, 20));
		controlsPanel.add(rollButton);

		JButton holdButton = new JButton("Hold");
		holdButton.setFont(new Font("Narkisim", Font.PLAIN, 20));
		controlsPanel.add(holdButton);

		diePanel1 = new DiePanel();
		add(diePanel1, "cell 0 3,grow");

		diePanel2 = new DiePanel();
		add(diePanel2, "cell 1 3,grow");

		diePanel3 = new DiePanel();
		add(diePanel3, "cell 2 3,grow");

		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showRoll(randomNumberGenerator.nextInt(6) + 1, randomNumberGenerator.nextInt(6) + 1,
						randomNumberGenerator.nextInt(6) + 1);
			}
		});
	}

	public void showRoll(int value1, int value2, int value3) {
		diePanel1.showValue(value1);
		diePanel2.showValue(value2);
		diePanel3.showValue(value3);
	}

}
