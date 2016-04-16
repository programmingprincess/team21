package SunDevilDice;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class TurnPanel extends JPanel {

	private DiePanel diePanel1;
	private DiePanel diePanel2;
	private DiePanel diePanel3;
	JLabel turnLabel; 
	JLabel roundScoreLabel;
	CardLayout cards;
	
	Die die1; //the 3 dice
	Die die2;
	Die die3;
	
	final int multiplier = 3;
	
	String currentPlayer;
	
	Actions currentGame;
	
	/**
	 * Create the panel.
	 */
	public TurnPanel(Vector<String> playerList) {
		currentGame = new Actions(playerList);
		currentPlayer = currentGame.startGame();
		
		// initialize the dice
		die1 = new Die();
		die2 = new Die();
		die3 = new Die();
		
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));

		JPanel playerPanel = new JPanel();
		add(playerPanel, "cell 0 0 3 1,alignx center,aligny center");

		turnLabel = new JLabel("Turn: " + currentPlayer);
		turnLabel.setFont(new Font("Narkisim", Font.PLAIN, 24));
		turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerPanel.add(turnLabel);

		JPanel roundScorePanel = new JPanel();
		add(roundScorePanel, "cell 0 1 3 1,alignx center,aligny center");

		roundScoreLabel = new JLabel("Round Score: ");
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
			public void actionPerformed(ActionEvent event) {
				
				die1.roll();
				die2.roll();
				die3.roll();

                int sum = die1.getFace() + die2.getFace() + die3.getFace();
                String terribleRoll = "Ouch. 6 6 6. You just lost all your points.\nNow it's ";
                String badRoll = "Sorry! You rolled a " + sum + " and lost your turn.\nNow it's ";
                
                if (sum == 10 || sum == 11)
                {
                	setCurrentPlayer(currentGame.nextTurn());
                    updateTurnLabel(currentPlayer);
                    updateRoundScoreLabel(0);
                    showRoll(die1.getFace(), die2.getFace(), die3.getFace());
                    JOptionPane.showMessageDialog(null, badRoll + currentPlayer + "'s turn." );// pop up showing next turn
                }
                else if (sum == 18)
                {
                	currentGame.resetScore();
                    setCurrentPlayer(currentGame.nextTurn());
                    updateTurnLabel(currentPlayer);
                    updateRoundScoreLabel(0);
                    showRoll(die1.getFace(), die2.getFace(), die3.getFace());
                    JOptionPane.showMessageDialog(null, terribleRoll + currentPlayer + "'s turn." );// pop up showing next turn
                }
                else if (sum == 3)
                {
                    currentGame.updateRoundScore(multiplier * 18);
                	updateRoundScoreLabel(currentGame.getRoundScore());
                }
                else if (die1.getFace() == die2.getFace() && die2.getFace() == die3.getFace())
                {
                	currentGame.updateRoundScore(multiplier * sum);
                	updateRoundScoreLabel(currentGame.getRoundScore());
                }
                else
                {
                	currentGame.updateRoundScore(sum);
                	updateRoundScoreLabel(currentGame.getRoundScore());
                }
				
				showRoll(die1.getFace(), die2.getFace(), die3.getFace());
			}
		});
		
		holdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String hold = "Hold!\nNow it's ";
				// check win condition
				int total = currentGame.getTotalScore(currentPlayer) + currentGame.getRoundScore();
				
				if(total >= Actions.SCORE_THRESHOLD){
					// go to win screen
					String results = currentGame.getWinner();
					endGame(results);
				}
				else{
					setCurrentPlayer(currentGame.hold());
                	updateTurnLabel(currentPlayer);
                	updateRoundScoreLabel(0);
                	JOptionPane.showMessageDialog(null, hold + currentPlayer + "'s turn." );// pop up showing next turn
                }
			}
			
		});
	}

	/**
	 * updates the dice display to show the new values
	 * @param value1 the first die value
	 * @param value2 the 2nd die value
	 * @param value3 the 3rd die value
	 */
	public void showRoll(int value1, int value2, int value3) {
		diePanel1.showValue(value1);
		diePanel2.showValue(value2);
		diePanel3.showValue(value3);
	}
	
	/**
	 * ends the game and transitions to the game over screen
	 * @param results the final results of the game
	 */
	public void endGame(String results){
		JPanel grandparent = (JPanel) this.getParent().getParent();

		GameOverPanel endPanel = new GameOverPanel(results, currentPlayer);
		grandparent.add(endPanel);
		cards = (CardLayout) (grandparent.getLayout());
		cards.next(grandparent);
	}
	
	/**
	 * updates the text of the turn label with a new player
	 * @param newPlayer the new label text
	 */
	public void updateTurnLabel(String newPlayer){
		turnLabel.setText("Turn: " + newPlayer);
	}
	
	/**
	 * updates the round score label with the new value
	 * @param score the new text of the round score label
	 */
	public void updateRoundScoreLabel(int score){
		roundScoreLabel.setText("Round Score: " + score);
	}

	
	/**
	 * updates the UI to reflect a change in turn
	 * @param player the new player whose turn should be reflected
	 */
	public void setCurrentPlayer(String player){
		((GameScreen) this.getParent()).updatePlayerScore(this.currentPlayer, currentGame.getTotalScore(this.currentPlayer));
        this.currentPlayer = player;
        ((GameScreen) this.getParent()).updatePlayerBorder(player);
	}
	
}
