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
	public JList<String> list;
	public Vector<String> playerList;
	public int AICount = 0;
	private int maxPlayerCount = 8;
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

		JPanel panel = new JPanel();		//add panel 
		add(panel, "cell 1 0 1 3,grow");
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][][]"));

		JTextField playerNameField = new JTextField();		//add field for user to enter name
		playerNameField.setPreferredSize(new Dimension(200, 38));
		panel.add(playerNameField, "cell 0 0 3 1,growx,aligny center");

		addPlayerButton = new JButton("Add Player");		//add action buttons
		addPlayerButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(addPlayerButton, "cell 0 0 3 1,growx,aligny center");
		
		deletePlayerButton = new JButton("Delete Player");
		deletePlayerButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(deletePlayerButton, "cell 0 1 3 1,growx,aligny center");
		
		addAiButton = new JButton("Add AI");
		addAiButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(addAiButton, "cell 0 2 3 1,growx,aligny center");

		hiScoreButton = new JButton("View High Scores");
		hiScoreButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(hiScoreButton, "cell 0 3 3 1,growx,aligny center");

		startButton = new JButton("Start Game");
		startButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(startButton, "cell 0 4 3 1,growx,aligny center");

		JButton instructionsButton = new JButton("Instructions");
		instructionsButton.setFont(new Font("Narkisim", Font.PLAIN, 24));
		panel.add(instructionsButton, "cell 0 3 1 4,grow");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 2 0,grow");

		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 0 1,grow");

		JPanel panel_3 = new JPanel();
		add(panel_3, "cell 0 2,grow");

		//Add JTextField text to the list; make a new player seat on game screen
		addPlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempName = playerNameField.getText().trim();
				if(!tempName.equals("") && !playerList.contains(tempName) && playerList.size() < maxPlayerCount) {
					playerList.addElement(tempName);
					list.updateUI();
					playerNameField.setText("");
				}
				//Error handling 
				else if(playerList.contains(tempName))
					JOptionPane.showMessageDialog(null, "That user name already exists.");// pop up alert for duplicate name
				else if(playerList.size() >= maxPlayerCount)
					JOptionPane.showMessageDialog(null, "Lobby is full. No more players can be added.");// pop up for too many players
				else
					JOptionPane.showMessageDialog(null, "Invalid user name."); // for entering empy names
			}
		});
		
		//Create a "Computer" player when pressed 
		addAiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(playerList.size() < 8) {
					AICount++;
					playerList.addElement("Computer " + AICount);
					list.updateUI();
				}
			//Needs to be completed
			}
		});
		
		//Remove selected player from the list 
		deletePlayerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int selectedIndex = list.getSelectedIndex();
				 if(selectedIndex >= 0 && !playerList.isEmpty() && selectedIndex < playerList.size()){ //Remove only if a particular item is selected				 
					 playerList.remove(selectedIndex);
					 list.updateUI();
				 }
				 else 
					 JOptionPane.showMessageDialog(null, "Please select a player to be removed.");// pop up alert for user
			}
		});
	}

}
