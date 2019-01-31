package rpg;

import java.util.Scanner;
import java.util.Random;

/**
 * Driver for rpg package. This is a three room text based rpg. The user interacts with objects
 *  in the game in order to complete a quest and win the game.
 * @author Emily Carlson
 * May 8, 2018
 */

public class RpgDriver {
	Help help;
	
	/**
	 * Uses an enumeration to print the help function of the game.
	 */
	public static void printHelp() {
		System.out.println("    Game Help\nAll objects that you can interact with are surrounded\n"
				+ "by * *. For example, you could interact with a *book*. Similarly,\ndirections "
				+ "in which you can travel are surrounded by # #.\nFor example, you could travel "
				+ "#north#.\n");
		
		System.out.println("    General Information");
		System.out.println(Help.help + ": Displays this help screen with all possible commands.");
		System.out.println(Help.health + " hero: Displays current health of your character.");
		System.out.println(Help.health + " <monster>: Displays current health of a monster.");
		System.out.println(Help.inventory + ": Displays everything you are carrying.\n");
		
		System.out.println("    Interacting with the World");
		System.out.println(Help.look + " room: Gives description of the area you are in. Will always\n"
				+ "    show the directions in which you can travel.");
		System.out.println(Help.look + " <object>: Gives a description of an object.");
		System.out.println(Help.get + " <object>: Pick up an object and add it to your inventory.");
		System.out.println(Help.eat + " <object>: Eat an object in your inventory.");
		System.out.println(Help.north + ": Go to the area north of you.");
		System.out.println(Help.south + ": Go to the area south of you.\n");
		
		System.out.println("    Combat");
		System.out.println(Help.kill + " <monster>: Attack a monster with a close range weapon.");
		System.out.println(Help.cast + " <spellname>: Attack a monster with a spell.");
		
		
	}

	/**
	 * Main method for the game. Allows user to interact with objects in the game by entering
	 * commands.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean exitLoop = false;
		Hero hero = new Hero();
		Inventory inventory = new Inventory();
		Monster monster = new Monster();
		String responsePart1 = "default";
		String responsePart2 = "default";
		Room1 room1 = new Room1();
		Room2 room2 = new Room2();
		Room3 room3 = new Room3();
		int roomNum = 1;
		
		System.out.println("You have heard of a great quest in the woods and have set off for\n"
				+ "fame. You come upon a meadow in the wood. To the #north# you see\na large pond with " 
				+ "a waterfall at its head. A few yards away an\nold *woman* sits on a large rock.\n");
		System.out.println("You may type 'help' at any time for a full list of commands.\n");
		
		// Do while loop that loops until the quest is completed.
		do {
			// Determines which room the user is in.
			switch(roomNum) {
				case 1:
					// Loops until user leaves room1 or the quest is completed.
					do {
						
						responsePart1 = input.next();
						if(!responsePart1.equals("help") & !responsePart1.equals("north") & 
								!responsePart1.equals("south") & !responsePart1.equals("inventory")) {
							responsePart2 = input.next();
						}
						input.nextLine();
						
						// Determines the appropriate response based on the first part of user input for
						// room 1.
						switch(responsePart1) {
							case "health":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is health.
								switch(responsePart2) {
									case "hero":
										hero.healthComm();
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
								break;
							case "help":
								printHelp();
								break;
							case "inventory":
								inventory.inventoryComm();
								break;
							case "look":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is look.
								switch(responsePart2) {
									case "room":
										room1.roomLook();
										break;
									case "woman":
										room1.womanLook();
										
										// Determines if quest is complete and ends program if true.
										if(!room1.isQuestComplete()) {
											// Determines if user has already looked at the woman once
											// and outputs appropriately.
											if(room1.isWoman()) {
												inventory.setInventory("sword");
												System.out.println("Sword (2 damage per turn) added "
														+ "to inventory.\n");
												room1.setWoman(false);
											}
										} else {
											exitLoop = true;
											break;
										}
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
								break;
							case "north":
								// Determines if user has interacted with the woman and gotten the quest
								// and allows user to move to room2 if the user has gotten the quest.
								if(room1.isWoman()) {
									System.out.println("You have not yet gotten the quest! Maybe you "
											+ "should talk\nto the old *woman* first.");
								} else {
									room1.northExit();
									roomNum = 2;
									room2.roomLook();
								}
								break;
							default:
								System.out.println("Invalid command. You may type 'help' at "
										+ "any time for\n a full list of commands.\n");
								break;
						}	
					} while(roomNum == 1 & !exitLoop);
					break;
					
				case 2:
					// Loops until user leaves room2 or the quest is completed.
					do {
						responsePart1 = input.next();
						if(!responsePart1.equals("help") & !responsePart1.equals("north") & 
								!responsePart1.equals("south") & !responsePart1.equals("inventory")) {
							responsePart2 = input.next();
						}
						input.nextLine();
						
						// Determines the appropriate response based on the first part of user input for
						// room 2.
						switch(responsePart1) {
							case "eat":
								// Determines if user has flower in inventory and outputs appropriately.
								if(inventory.checkInventory("flower")) {
									hero.eatFlower();
									inventory.eatFlower();
								} else {
									System.out.println("You don't have a flower in your inventory!\n");
								}
								break;
							case "get":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is get.
								switch(responsePart2) {
									case "book":
										room2.spellbookGet();
										break;
									case "flower":
										room2.flowerGet();
										// Determines if user has already picked the flower or not and
										// outputs appropriately.
										if(room2.isFlower()) {	
											inventory.setInventory("flower");
											System.out.println("Flower added to inventory.\n");
											room2.setFlower(false);
										} 
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
								break;
							case "health":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is health.
								switch(responsePart2) {
									case "hero":
										hero.healthComm();
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
								break;
							case "help":
								printHelp();
								break;
							case "inventory":
								inventory.inventoryComm();
								break;
							case "look":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is look.
								switch(responsePart2) {	
									case "book":
										room2.spellbookLook();
										hero.setKnowSpell(true);
										break;
									case "flower":
										room2.flowerLook();
										break;
									case "room":
										room2.roomLook();
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
								break;
							case "north":
								room2.northExit();
								roomNum = 3;
								room3.roomLook();
								break;
							case "south":
								room2.southExit();
								roomNum = 1;
								room1.roomLook();
								break;
							default:
								System.out.println("Invalid command. You may type 'help' at "
										+ "any time for\n a full list of commands.\n");
								break;
						}						

					} while(roomNum == 2 & !exitLoop);
					break;
					
				case 3:
					// Loops until user leaves room3, the quest is completed or the hero dies.
					do {
						responsePart1 = input.next();
						if(!responsePart1.equals("help") & !responsePart1.equals("north") & 
								!responsePart1.equals("south") & !responsePart1.equals("inventory")) {
							responsePart2 = input.next();
						}
						input.nextLine();
						
						// Determines the appropriate response based on the first part of user input for
						// room 3.
						switch(responsePart1) {
							case "eat":
								// Determines if user has flower in inventory and outputs appropriately.
								if(inventory.checkInventory("flower")) {
									hero.eatFlower();
									inventory.eatFlower();
								}
								break;
							case "cast":
								hero.castSpell();
								
								// Determines if hero knows spell and responds appropriately.
								if(hero.isKnowSpell()) {
									// Determines if monster is far away and responds appropriately.
									if(room3.isMonsterFar()) {
										monster.hitPoints -= 1;
										System.out.println("The *monster* charges you angered by "
												+ "your attack!\n");
										
										// Determines if monster is dead.
										if(monster.getHitPoints() <= 0) {
											room3.setMonster(false);
											System.out.println("You have defeated the monster! The *monster* "
													+ "lays dead at your feet.\nIts huge *horns* protruding "
													+ "from its head.\n");
											break;
										}
										
										room3.setMonsterFar(false);
									} else {
										monster.hitPoints -= 1;
										
										hero.healthComm();
										monster.healthComm();
										
										// Determines if monster is dead.
										if(monster.getHitPoints() <= 0) {
											room3.setMonster(false);
											System.out.println("You have defeated the monster! The *monster* "
													+ "lays dead at your feet.\nIts huge *horns* protruding "
													+ "from its head.\n");
											break;
										}
										
										System.out.println("The monster attacks slashing you with its claws!");
										Random random = new Random();
										int randomNum = random.nextInt(10 - 1 + 1) + 1;
										
										// Monster attack. Determines if the attack is critical strike.
										if(randomNum < 10) {
											hero.hitPoints -= monster.attackPoints;
										} else {
											hero.hitPoints -= (monster.attackPoints + 1);
											System.out.println("Critical Strike! The monster does 1 extra "
													+ "damage.\n");
										}
										
										// Determines if hero is dead and ends program if true.
										if(hero.getHitPoints() <= 0) {
											
											System.out.println("The *monster* has killed you and you have "
													+ "failed the quest!\n");
											exitLoop = true;
											break;
										}
										
									}
									hero.healthComm();
									monster.healthComm();
								}
								break;
							case "get":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is get.
								switch(responsePart2) {
									case "horns":
										room3.hornsGet();
										// Determines if monster still has horns and the monster is dead.
										if(room3.isHorns() & !room3.isMonster()) {	
											inventory.setInventory("horns");
											room3.setHorns(false);
											room1.setQuestComplete(true);
											System.out.println("Horns added to inventory.\n");
										} 
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
								break;
							case "health":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is health.
								switch(responsePart2) {
									case "hero":
										hero.healthComm();
										break;
									case "monster":
										monster.healthComm();
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
							case "help":
								printHelp();
								break;
							case "inventory":
								inventory.inventoryComm();
								break;
							case "kill":
								room3.setMonsterFar(false);
								System.out.println("You attack the monster wielding your sword!");
								Random random = new Random();
								int randomNum1 = random.nextInt(10 - 1 + 1) + 1;
									
								// Hero attack. Determines if the attack is critical strike.
								if(randomNum1 < 7) {
									monster.hitPoints -= hero.attackPoints;
								} else {
									monster.hitPoints -= (hero.attackPoints + 1);
									System.out.println("Critical Strike! One extra damage dealt.\n");
								}
								
								// Determines if monster is dead.	
								if(monster.getHitPoints() <= 0) {
									room3.setMonster(false);
									System.out.println("You have defeated the monster! The *monster* "
											+ "lays dead at your feet.\nIts huge *horns* protruding "
											+ "from its head.\n");
										break;
								}
									
								hero.healthComm();
								monster.healthComm();
									
								System.out.println("The monster attacks slashing you with its claws!");
								int randomNum2 = random.nextInt(10 - 1 + 1) + 1;
									
								// Monster attack. Determines if the attack is critical strike.
								if(randomNum2 < 10) {
									hero.hitPoints -= monster.attackPoints;
								} else {
									hero.hitPoints -= (monster.attackPoints + 1);
									System.out.println("Critical Strike! The monster does 1 extra "
											+ "damage.\n");
								}
								
								// Determines if hero is dead and ends program if true.
								if(hero.getHitPoints() <= 0) {	
									System.out.println("The *monster* has killed you and you have "
											+ "failed the quest!\n");
									exitLoop = true;
									break;
								}
									
								hero.healthComm();
								monster.healthComm();
								
								break;
							case "look":
								// Determines appropriate response based on the second part of user input
								// when the first part of user input is look.
								switch(responsePart2) {
									case "flower":
										room2.flowerLook();
										break;
									case "horns":
										room3.hornsLook();
										break;
									case "monster":
										room3.monsterLook();
										break;
									case "room":
										room3.roomLook();
										break;
									default:
										System.out.println("Invalid command. You may type 'help' at "
												+ "any time for\n a full list of commands.\n");
										break;
								}
								break;
							case "south":
								room3.southExit();
								roomNum = 2;
								room2.roomLook();
								break;
							default:
								System.out.println("Invalid command. You may type 'help' at "
										+ "any time for\n a full list of commands.\n");
								break;
						}
					} while(roomNum == 3 & !exitLoop);
					break;
			}
		} while(!exitLoop);
	}
}

