package SunDevilDice;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;

public class MainWindow {

	private JFrame frmSunDevilDice;
	private JPanel mainPanel;
	private GameScreen gameScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmSunDevilDice.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSunDevilDice = new JFrame();
		frmSunDevilDice.setTitle("Sun Devil Dice");
		frmSunDevilDice.setBounds(100, 100, 640, 640);
		frmSunDevilDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSunDevilDice.getContentPane().setLayout(new BorderLayout(0, 0));

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		frmSunDevilDice.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new CardLayout(0, 0));

		SetupScreen setupScreen = new SetupScreen();
		mainPanel.add(setupScreen, "setup");

		setupScreen.startButton.addActionListener(new ActionListener() {
			// handles start button clicks
			public void actionPerformed(ActionEvent event) {
				if (setupScreen.playerList.size() > 0) {
					gameScreen = new GameScreen(setupScreen.playerList);
					mainPanel.add(gameScreen, "game");
					CardLayout cards = (CardLayout) (mainPanel.getLayout());
					cards.show(mainPanel, "game");
				}
			}
		});

		setupScreen.addAiButton.addActionListener(new ActionListener() {
			// handles add AI button clicks
			public void actionPerformed(ActionEvent event) {

			}
		});
	}

}
