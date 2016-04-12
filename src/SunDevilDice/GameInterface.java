package SunDevilDice;

public interface GameInterface {
	
	public void addPlayer(String name);
	
	public void addAI();
	
	public void begin();
	
	public int getTotalScore(String player);
	
	public int getRoundScore();

}

