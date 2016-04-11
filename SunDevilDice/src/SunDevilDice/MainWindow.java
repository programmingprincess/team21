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
		frmSunDevilDice.setBounds(100, 100, 640, 480);
		frmSunDevilDice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSunDevilDice.getContentPane().setLayout(new BorderLayout(0, 0));

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		frmSunDevilDice.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new CardLayout(0, 0));

		SetupScreen setupScreen = new SetupScreen();
		mainPanel.add(setupScreen, "name_10768559503125");

		GameScreen gameScreen = new GameScreen();
		mainPanel.add(gameScreen, "name_10775296814969");

		setupScreen.startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cards = (CardLayout) (mainPanel.getLayout());
				cards.next(mainPanel);
			}
		});
	}

}
