package rpg;

/**
 * Room1 Class. Prints different outputs depending on which boolean variables are true.
 * @author Emily Carlson
 * May 8, 2018
 */

public class Room1 implements Room{
	private boolean questComplete = false;
	private boolean woman = true;
	
	/**
	 * Constructor for Room1 with no parameters.
	 */
	public Room1() {
		super();
	}

	/**
	 * Checks if questComplete is true.
	 * @return questComplete
	 */
	public boolean isQuestComplete() {
		return questComplete;
	}

	/**
	 * Set method for questComplete.
	 * @param questComplete
	 */
	public void setQuestComplete(boolean questComplete) {
		this.questComplete = questComplete;
	}

	/**
	 * Checks if woman is true.
	 * @return woman
	 */
	public boolean isWoman() {
		return woman;
	}

	/**
	 * Set method for woman.
	 * @param woman
	 */
	public void setWoman(boolean woman) {
		this.woman = woman;
	}
	
	/**
	 * Prints a line of text.
	 */
	public void northExit() {
		System.out.println("You walk to the #north#, swim across the pond and cross to the other\n"
				+ "side of the waterfall...\n");
	}

	/**
	 * Prints a line of text.
	 */
	public void roomLook() {
		System.out.println("You are in a meadow. To the #north# you see a large pond with \n"
				+ "a waterfall at its head. A few yards away an old *woman* sits\non a large rock.\n");
		
	}
	
	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void womanLook() {
		// Determines if woman is true and prints the appropriate text.
		if(woman) {
			System.out.println("Hello adventurer! To the #north# beyond the waterfall there is\n"
					+ "a great monster. If you defeat the monster you will win eternal\nfame! "
					+ "I'll give you this sword to help you on your way. Be sure to\nbring back "
					+ "proof of having defeated the beast!\n");
		} else {
			// Determines if questComplete is true and prints the appropriate text.
			if(questComplete) {
				System.out.println("Congratulations! You have defeated the monster and won eternal\n"
						+ "fame! Forevermore will the people of this land sing your praise!\n");
			} else {
				System.out.println("Go #north# and defeat the monster! Be sure to bring back proof of\n"
					+ "having defeated the beast!\n");
			}
		}
	}
}
