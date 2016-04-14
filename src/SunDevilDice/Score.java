package SunDevilDice;

/**	
 *	The Score class calculates the total, round, and current roll scores
 *	by creating a Die object.
 */
public class Score {
	
	private int totalScore;
	private int roundScore;
	private int rollScore;
	private Die die;
	
	/**
	 * The Score constructor sets the total, round, and roll scores to zero,
	 * and creates a Die object in order to roll.
	 */
	public Score() {
		totalScore = 0;
		roundScore = 0;
		rollScore = 0;
		die = new Die();
	}
	
	/**
	 *  The setRollScore method sets the rollScore from the three dice from each roll.
	 */
	public void setRollScore() {
		int roll1 = die.roll();
		int roll2 = die.roll();
		int roll3 = die.roll();
		int scoreMultiplier = 3;
		int currentScore = roll1 + roll2 + roll3;
		
		// resets total score if rolled all 6s
		if(currentScore == 18) {
			totalScore = 0;
			rollScore = 0;
		}
		// special multiplier if rolled all 1s
		else if(currentScore == 3) {
			rollScore = (6 * 3) * scoreMultiplier;
		}
		// x3 multiplier if rolled 3-of-a-kind
		else if((roll1 == roll2) && (roll1 == roll3)) {
			rollScore = currentScore * scoreMultiplier;
		}
		else {
			rollScore = currentScore;
		}
	}
	
	/**
	 *  The setTotalScore method adds the roundScore to the totalScore.
	 */
	public void setTotalScore() { 
		totalScore += roundScore;
	}
	
	/**
	 * The setRoundScore method adds the rollScore to the roundScore.
	 */
	public void setRoundScore() {
		roundScore += rollScore;
	}

	/**
	 * The getTotalScore method returns the value of the totalScore.
	 * 
	 * @return totalScore	Accumulated score
	 */
	public int getTotalScore() {
		return totalScore;
	}
	
	/**
	 * The getRoundScore method returns the value of the roundScore.
	 * 
	 * @return roundScore	Score of the current round
	 */
	public int getRoundScore() {
		return roundScore;
	}
	
	/**
	 * The getRollScore method returns the value of the current roll.
	 * 
	 * @return rollScore	Score of the current roll
	 */
	public int getRollScore() {
		return rollScore;
	}
	
}
