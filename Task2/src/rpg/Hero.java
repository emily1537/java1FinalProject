package rpg;

import java.util.Random;

/**
 * Hero Class. Contains all variables and methods relating to the hero.
 * @author Emily Carlson
 * 8 May, 2018
 */

public class Hero extends Character {
	int attackPoints = 2;
	int hitPoints = 10;
	private boolean knowSpell = false;
	
	
	/**
	 * Constructor for Hero with no parameters.
	 */
	public Hero() {
		super();
	}



	/**
	 * Get method for attackPoints.
	 * @return attackPoints
	 */
	public double getAttackPoints() {
		return attackPoints;
	}


	/**
	 * Set method for attackPoints.
	 * @param attackPoints
	 */
	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}


	/**
	 * Get method for hitPoints.
	 * @return
	 */
	public double getHitPoints() {
		return hitPoints;
	}


	/**
	 * Set method for hitPoints.
	 * @param hitPoints
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	
	/**
	 * Checks if knowSpell is true.
	 * @return knowSpell
	 */
	public boolean isKnowSpell() {
		return knowSpell;
	}


	/**
	 * Set method for knowSpell.
	 * @param knowSpell
	 */
	public void setKnowSpell(boolean knowSpell) {
		this.knowSpell = knowSpell;
	}


	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void castSpell() {
		// Determines if knowSpell is true and prints the appropriate text.
		if(knowSpell) {
			System.out.println("You throw a lightning bolt at the *monster* doing 1 damage!\n");
		} else
			System.out.println("You don't know any spells!\n");
	}
	
	/**
	 * Generates a random number. Then prints text and alter variables based on the random number.
	 */
	public void eatFlower() {
		Random random = new Random();
		int randomNum = random.nextInt(10 - 1 + 1) + 1;
		
		// Prints text and alter variables based on the value of randomNum.
		if(randomNum < 8) {
			System.out.println("You eat the *flower* and gain 1 extra hitPoint!\n");
			hitPoints += 1;
		} else if(randomNum < 10) {
			System.out.println("You eat the *flower* and now your sword does 1 extra damage!\n");
			attackPoints += 1;
		} else {
			System.out.println("You eat the *flower* and nothing happens!\n");
		}
	}
	
	@Override
	/**
	 * Prints the current amount of hitPoints the hero has.
	 */
	public void healthComm() {
		System.out.println("You have " + hitPoints + " health.");
	}

}
