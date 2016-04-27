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
	public JButton deletePlayerButton;
	public JButton addAiButton;
	public JButton hiScoreButton;
	public JButton startButton;
	public JTextField playerNameField;
	public JList<String> list;
	public Vector<String> playerList;
	public int AICount = 0;
	private int maxPlayerCount = 8;
	private Actions currentGame;

	/**
	 * Create the panel.
	 */
	public SetupScreen() {
		setBackground(Color.BLACK);
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow]"));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.decode(MainWindow.gold));
		add(panel_4, "cell 0 0 1 2,grow");
		panel_4.setLayout(new MigLayout("", "[grow]", "[][grow]"));

		JLabel playerListLabel = new JLabel("Players");
		playerListLabel.setFont(new Font("Narkisim", Font.PLAIN, 16));
		panel_4.add(playerListLabel, "cell 0 0,alignx center,aligny center");

		playerList = new Vector<String>();
		list = new JList<String>(playerList);
		list.setBackground(Color.decode(MainWindow.gold));
		panel_4.add(list, "cell 0 1,grow");

		JPanel centerPanel = new JPanel(); // add panel
		centerPanel.setBackground(Color.decode(MainWindow.maroon));
		add(centerPanel, "cell 1 0 1 3,grow");
		centerPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][][]"));

		playerNameField = new JTextField(); // add field for user to enter name
		playerNameField.setPreferredSize(new Dimension(200, 38));
		centerPanel.add(playerNameField, "cell 0 0 3 1,growx,aligny center");

		addPlayerButton = new JButton("Add Player"); // add action buttons
		addPlayerButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		centerPanel.add(addPlayerButton, "cell 0 0 3 1,growx,aligny center");

		deletePlayerButton = new JButton("Delete Player");
		deletePlayerButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		centerPanel.add(deletePlayerButton, "cell 0 1 3 1,growx,aligny center");

		addAiButton = new JButton("Add AI");
		addAiButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		centerPanel.add(addAiButton, "cell 0 2 3 1,growx,aligny center");

		hiScoreButton = new JButton("View High Scores");
		hiScoreButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		centerPanel.add(hiScoreButton, "cell 0 3 3 1,growx,aligny center");

		startButton = new JButton("Start Game");
		startButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		centerPanel.add(startButton, "cell 0 4 3 1,growx,aligny center");

		JButton instructionsButton = new JButton("Instructions");
		instructionsButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		centerPanel.add(instructionsButton, "cell 0 3 1 4,grow");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		add(panel_1, "cell 2 0,grow");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		add(panel_2, "cell 0 1,grow");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.BLACK);
		add(panel_3, "cell 0 2,grow");

		currentGame = new Actions(playerList);
		
		// Add JTextField text to the list; make a new player seat on game
		// screen
		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// remove leading and trailing whitespace
				String tempName = playerNameField.getText().trim();

				if (!tempName.equals("") && !playerList.contains(tempName) && playerList.size() < maxPlayerCount) {
					playerList.addElement(tempName);
					list.updateUI();
					playerNameField.setText("");
				}
				// Error handling
				else if (playerList.contains(tempName)) {
					JOptionPane.showMessageDialog(null, "That user name already exists.", "Username exists",
							JOptionPane.PLAIN_MESSAGE);
				} else if (playerList.size() >= maxPlayerCount) {
					JOptionPane.showMessageDialog(null, "Lobby is full. No more players can be added.", "Lobby Full",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Invalid user name.", "Invalid", JOptionPane.PLAIN_MESSAGE);
				}

			}
		});

		// Create a "Computer" player when pressed
		addAiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (playerList.size() < maxPlayerCount) {
					AICount++;
					playerList.addElement("Computer " + AICount);
					list.updateUI();
				} else {
					JOptionPane.showMessageDialog(null, "Lobby is full. No more Computer players can be added.",
							"Lobby Full", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		// Remove selected player from the list
		deletePlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int selectedIndex = list.getSelectedIndex();

				if (selectedIndex >= 0 && !playerList.isEmpty() && selectedIndex < playerList.size()) {
					playerList.remove(selectedIndex);
					list.updateUI();
				} else {
					JOptionPane.showMessageDialog(null, "Please select a player to be removed.", "Select Player",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});

		// show game instruction pop-up when pressed
		instructionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Each player takes turns rolling the dice. A player's turn is terminated when they roll a sum of 10 or 11, roll three 6's, or when they choose to hold.\n"
								+ "\t-Holding will save the player's current round score, increasing their total score.\n"
								+ "\t-Rolling three 6's will render a player's total score to 0 and end their turn.\n"
								+ "\t-Rolling 10 or 11 will end the player's turn without increasing the total score.\n"
								+ "\t-Rolling three of a kind (other than 6's) will counts as triple the face value for that roll. (For example: rolling three 3's will result in a score of 9 x 3 = 27).\n"
								+ "\t-If a player rolls three one's, each die will be treated as a value of 6 instead of one. (Rolling three 1's will result in a score of 6 x 3 = 18 x 3 = 54).\n\n"
								+ "The game will terminate when a player's total score reaches 200 points or more declaring that player the winner!",
						"Instructions", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// show local high score list
		hiScoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hScores = currentGame.retrieveScores();
				JOptionPane.showMessageDialog(null, hScores, "High Scores", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

}
