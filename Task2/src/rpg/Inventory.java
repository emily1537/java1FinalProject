package rpg;

import java.util.ArrayList;

/**
 * Class Inventory. Stores items that the hero gets in the world.
 * @author Emily Carlson
 * 8 May, 2018
 */
public class Inventory extends Hero {
	private ArrayList<String> inventory = new ArrayList<String>();
	
	
	/**
	 * Constructor for Inventory with no parameters.
	 */
	public Inventory() {
		super();
	}

	/**
	 * Get Method for inventory.
	 * @return inventory
	 */
	public String getInventory() {
		return inventory.toString();
	}

	/**
	 * Set Method for inventory.
	 * @param arg0
	 */
	public void setInventory(String arg0) {
		this.inventory.add(arg0);
	}
	
	/**
	 * Checks the inventory ArrayList for a specified string.
	 * @param arg0
	 * @return boolean
	 */
	public boolean checkInventory(String arg0) {
		return inventory.contains(arg0);
	}

	/**
	 * Removes string "flower" from inventory ArrayList.
	 */
	public void eatFlower() {
		this.inventory.remove("flower");
	}

	/**
	 * Prints all items in inventory ArrayList.
	 */
	public void inventoryComm() {
		System.out.println("Inventory: ");
		for(int count = 0; count < inventory.size(); count++) {
			System.out.println(inventory.get(count) + " ");

		}
		System.out.println();
	}
}
