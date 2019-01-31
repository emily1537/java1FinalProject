package rpg;

/**
 * Room2 Class. Prints different outputs depending on which boolean variables are true.
 * @author Emily Carlson
 * May 8, 2018
 */

public class Room2 implements Room{
	private boolean flower = true;
	private boolean flowerPicked = false;
	private boolean spellbook = true;
	
	/**
	 * Constructor for Room2 with no parameters.
	 */
	public Room2() {
		super();
	}

	/**
	 * Checks if flower is true.
	 * @return flower
	 */
	public boolean isFlower() {
		return flower;
	}

	/**
	 * Set method for flower.
	 * @param flower
	 */
	public void setFlower(boolean flower) {
		this.flower = flower;
	}
	
	/**
	 * Checks if isFlowerPicked is true.
	 * @return flowerPicked
	 */
	public boolean isFlowerPicked() {
		return flowerPicked;
	}

	/**
	 * Set method for flowerPicked.
	 * @param flowerPicked
	 */
	public void setFlowerPicked(boolean flowerPicked) {
		this.flowerPicked = flowerPicked;
	}

	/**
	 * Checks if spellbook is true.
	 * @return spellbook
	 */
	public boolean isSpellbook() {
		return spellbook;
	}

	/**
	 * Set method for spellbook.
	 * @param spellbook
	 */
	public void setSpellbook(boolean spellbook) {
		this.spellbook = spellbook;
	}
	
	/**
	 * Prints text and alters flowerPicked based on which variables are true.
	 */
	public void flowerGet() {
		// Determines if flowerPicked is true and prints the appropriate text. Also changes 
		// flowerPicked to true if it is false.
		if(!flowerPicked) {
			System.out.println("You pick the *flower* and as you look at it you wonder if\n"
					+ "something would happen if you ate it.\n");
			flowerPicked = true;
		} else {
			System.out.println("You have already picked the *flower*!\n");
		}
	}

	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void flowerLook() {
		// Determines if flowerPicked is true and prints the appropriate text.
		if(!flowerPicked) {
			System.out.println("The *flower* brilliant shade of blue with four petals.\n"
					+ "Maybe you should pick it to get a better look.\n");
		} else {
			// Determines if flower is true and prints the appropriate text.
			if(flower) {
				System.out.println("You look at the beautiful blue *flower* in your bag and\n"
						+ "wonder what might happen if you eat it.\n");
			} 
			System.out.println("You have eaten the flower!\n");
		}
		
	}
	
	/**
	 * Prints a line of text.
	 */
	public void northExit() {
		System.out.println("You walk further into the foggy canyon.\n");
	}
	
	/**
	 * Prints a line of text depending on which variables are true.
	 */
	public void roomLook() {
		// Determines if flower is true and prints the appropriate text.
		if(flower) {
			System.out.println("You are in a foggy canyon that continues to the #north#. On the\n"
					+ "ground you see a lone *flower* and a large *book*. To the\n#south# is the"
					+ " waterfall from which you came.\n");
		} else {
			System.out.println("You are in a foggy canyon that continues to the #north#. On the\n"
					+ "ground you see a large *book*. To the #south# is the waterfall\n"
					+ "from which you came.\n");

		}
		
	}
	
	/**
	 * Prints a line of text.
	 */
	public void southExit() {
		System.out.println("You walk back through the waterfall.\n");
	}
	
	/**
	 * Prints text and alters spellbook based on which variables are true.
	 */
	public void spellbookLook() {
		// Determines if spellbook is true and prints the appropriate text. Also changes 
		// spellbook to false if it is true.
		if(spellbook) {
			System.out.println("The *book* is huge and bound in old worn leather. As you reach\n"
					+ "out to touch it, the *book* comes alive and opens to a page of its choice.\n"
					+ "With trepidation you read the chosen page and are filled with ancient knowledge.\n\n"
					+ "You have learned the *lightning* spell! It only does 1 damage but can be used\n"
					+ "at a distance!\n");
				spellbook = false;
		} else {
			System.out.println("The *book* lays on ground refusing to open once more.\n");
		}
	}
	
	/**
	 * Prints a line of text.
	 */
	public void spellbookGet() {
		System.out.println("Oof! The *book* is rather heavy! Maybe it's better left where it is.\n");
	}
	
	

}
