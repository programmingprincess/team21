package SunDevilDice;

import java.util.Random;
/** 
 * Class that returns random number 1-6
 * Simulates die roll
 * */
public class Die implements DieInterface {
	private Random randomNumberGenerator;
	private int face;
	
	/**
	 * constructs a Die object
	 */
	public Die(){
		face = -1; // initialize face outside of dice range
		randomNumberGenerator = new Random();
	}
	
	/**
	 * simulates a roll of a 6-sided die
	 * @return the result of the roll
	 */
	public int roll(){
		face = randomNumberGenerator.nextInt(6) + 1;		
		return face; //returns new random roll
	}
	
	/**
	 * returns the face of the last die roll
	 * @return the value of the last roll
	 */
	public int getFace(){
		return face; //returns most recent roll
	}
}
