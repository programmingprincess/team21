package SunDevilDice;

import java.util.Random;
/** 
 * Class that returns random number 1-6
 * Simulates die roll
 * */
public class Die implements DieInterface {
	private Random randomNumberGenerator;
	private int face;
	
	public Die(){
		randomNumberGenerator = new Random();
	}
	
	public int roll(){
		face = randomNumberGenerator.nextInt(6) + 1;		
		return face; //returns new random roll
	}
	
	public int getFace(){
		return face; //returns most recent roll
	}
}
