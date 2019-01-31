package rpg;

/**
 * Monster Class. Contains all variables and methods relating to the monster.
 * @author Emily Carlson
 * 8 May, 2018
 */
public class Monster extends Character {
	int attackPoints = 2;
	int hitPoints = 10;
	
	
	/**
	 * Constructor for Monster with no parameters.
	 */
	public Monster() {
		super();
	}

	/**
	 * Get method for attackPoints.
	 * @return attackPoints
	 */
	public int getAttackPoints() {
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
	 * @return hitPoints.
	 */
	public int getHitPoints() {
		return hitPoints;
	}

	/**
	 * Set method for hitPoints.
	 * @param hitPoints
	 */
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	@Override
	/**
	 * Prints the current amount of hitPoints the monster has.
	 */
	public void healthComm() {
		System.out.println("The *monster* has " + hitPoints + " health.\n");
	}

}
	
	

	



