import java.util.Scanner;

/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This is the driver class for Assignment 1.
 * Student Name: Thomas Stanley
 * Student Number: 41037136  
 * Section #: 301
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD. 
 * 
 */
public class Assign1 {

	/**
	 * This method displays a menu to be used in main
	 */
	static void displayMenu() {
		System.out.println("Please select one of the following: ");
		System.out.println("1: Add item to inventory: ");
		System.out.println("2: Display item inventory: ");
		System.out.println("3: Buy item(s): ");
		System.out.println("4: Sell item(s): ");
		System.out.println("5: To Exit");
	}
	/**
	 * Main displays a menu to the user and created a Scanner object for use in the project.
	 * @param args Are the Arguments used in main class
	 */
	public static void main(String[] args) {
		//creating Scanner object, Inventory object, and loop variables
		Scanner keyboard = new Scanner(System.in);
		boolean loop=true;
		Inventory inv = new Inventory();
		//start of loop
		while(loop==true) {
			displayMenu();
			//try catch for exception handling
			try {
				int option = keyboard.nextInt();
				//switch case for menu routing
				switch(option) {
				case 1:
					inv.addItem(keyboard);
					break;
				case 2:
					inv.toString();
					break;
				case 3:
					inv.updateQuantity(keyboard, true);
					break;
				case 4:
					inv.updateQuantity(keyboard, false);
					break;
				case 5:
					System.out.println("Exiting...");
					keyboard.close();
					loop=false;
					break;
				default:
					System.out.println("Please enter valid menu option");
				}
			//invalid entries are met with a message
			}catch(Exception e) {
			System.out.println("*****Invalid Input*****");
			keyboard.nextLine();
		    }
		}

	}

}
