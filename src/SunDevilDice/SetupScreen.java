package SunDevilDice;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SetupScreen extends JPanel {

	public JButton addPlayerButton;
	public JButton addAiButton;
	public JButton hiScoreButton;
	public JButton startButton;
	public JList<String> list;
	public Vector<String> playerList;

	/**
	 * Create the panel.
	 */
	public SetupScreen() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));

		JPanel panel_4 = new JPanel();
		add(panel_4, "cell 0 0 1 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow]", "[][grow]"));

		JLabel playerListLabel = new JLabel("Players");
		playerListLabel.setFont(new Font("Narkisim", Font.PLAIN, 16));
		panel_4.add(playerListLabel, "cell 0 0,alignx center,aligny center");

		playerList = new Vector<String>();
		list = new JList<String>(playerList);
		panel_4.add(list, "cell 0 1,grow");

		JPanel panel = new JPanel();
		add(panel, "cell 1 0 1 3,grow");
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][][]"));

		JTextField playerName = new JTextField();
		playerName.setPreferredSize(new Dimension(200, 38));
		panel.add(playerName, "cell 0 0 3 1,growx,aligny center");

		addPlayerButton = new JButton("Add Player");
		addPlayerButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(addPlayerButton, "cell 0 0 3 1,growx,aligny center");

		addAiButton = new JButton("Add AI");
		addAiButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(addAiButton, "cell 0 1 3 1,growx,aligny center");

		hiScoreButton = new JButton("View High Scores");
		hiScoreButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(hiScoreButton, "cell 0 2 3 1,growx,aligny center");

		startButton = new JButton("Start Game");
		startButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(startButton, "cell 0 3 3 1,growx,aligny center");

		JButton instructionsButton = new JButton("Instructions");
		instructionsButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(instructionsButton, "cell 1 4,grow");

		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 2 0,grow");

		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 1,grow");

		JPanel panel_3 = new JPanel();
		add(panel_3, "cell 0 2,grow");

		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!playerName.getText().trim().equals(" ") && !playerName.getText().trim().equals("") && !playerList.contains(playerName.getText().trim())
						&& playerList.size() < 8) {
						playerList.addElement(playerName.getText());
						list.updateUI();
						playerName.setText("");
						}
			}
		});
	}

}
