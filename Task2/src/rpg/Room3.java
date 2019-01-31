package rpg;

/**
 * Room3 Class. Prints different outputs depending on which boolean variables are true.
 * @author Emily Carlson
 * May 8, 2018
 */


public class Room3 implements Room{
	private boolean horns = true;
	private boolean monster = true;
	private boolean monsterFar = true;

	
	/**
	 * Constructor for Room3 with no parameters.
	 */
	public Room3() {
		super();
	}


	/**
	 * Checks if horns is true.
	 * @return horns
	 */
	public boolean isHorns() {
		return horns;
	}


	/**
	 * Set method for horns.
	 * @param horns
	 */
	public void setHorns(boolean horns) {
		this.horns = horns;
	}


	/**
	 * Checks if monster is true.
	 * @return monster
	 */
	public boolean isMonster() {
		return monster;
	}


	/**
	 * Set method for monster.
	 * @param monster
	 */
	public void setMonster(boolean monster) {
		this.monster = monster;
	}
	

	/**
	 * Checks if monsterFar is true.
	 * @return monsterFar
	 */
	public boolean isMonsterFar() {
		return monsterFar;
	}


	/**
	 * Set method for monsterFar.
	 * @param monsterFar
	 */
	public void setMonsterFar(boolean monsterFar) {
		this.monsterFar = monsterFar;
	}

	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void hornsGet() {
		// Determines if monster is true and prints the appropriate text.
		if(monster) {
			System.out.println("Maybe you should kill the monster first before taking its horns!\n");
		} else {
			// Determines if horns is true and prints the appropriate text.
			if(horns) {
				System.out.println("You cut the horns off the *monster* as proof of its defeat.\n");
			} else {
				System.out.println("You already have the *horns* of the *monster*!\n");
			}
		}
	}

	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void hornsLook() {
		// Determines if horns is true and prints the appropriate text.
		if(horns) {
			System.out.println("Huge curling *horns* protrude from the *monster*'s head.\nMaybe "
					+ "they would be good proof that you have defeated the *monster*.\n");
		} else {
			System.out.println("The *horns* lie in your bag and should serve as suitable proof\n"
					+ "of the *monster*'s defeat!\n");
		}
	}
	
	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void monsterLook() {
		// Determines if monster is true and prints the appropriate text.
		if(monster) {
			System.out.println("You see a large hairy hulking *monster* with two huge *horns*.\n");
		} else{
			// Determines if horns is true and prints the appropriate text.
			if(horns) {
				System.out.println("The *monster* lays dead at your feet. Its huge *horns*\n"
						+ "protruding from its head.\n");
			} else{
				System.out.println("The defeated *monster* lays at your feet. Its head denuded\n"
						+ "of *horns*.\n");
			}
		}
	}
	
	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void roomLook() {
		// Determines if monsterFar is true and prints the appropriate text.
		if(monsterFar) {
			System.out.println("You are at the end of the foggy canyon. In the distance you see a\n"
					+ "great hulking *monster* with *horns*. To the #south# the\ncanyon continues.\n");
		} else {
			// Determines if monster is true and prints the appropriate text.
			if(monster) {
				System.out.println("You are at the end of the foggy canyon with a huge *monster*\n"
						+ "attacking you!\n");
			} else{
				// Determines if horns is true and prints the appropriate text.
				if(horns) {
					System.out.println("You are at the end of the foggy canyon with the dead\n"
							+ "*monster* with *horns* at your feet. To the #south#\n the canyon "
							+ "continues.\n");
				} else{
					System.out.println("You are at the end of the foggy canyon with the dead\n"
							+ "*monster* denuded of *horns* at your feet. To the #south#\nthe "
							+ "canyon continues.\n");
				}
			}
		}
	}
	
	/**
	 * Prints a line of text.
	 */
	public void southExit() {
		System.out.println("You walk back the way you came through the foggy canyon.\n");
	}

}
