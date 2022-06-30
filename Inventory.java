import java.util.Scanner;

/**
 * Inventory class handles methods involving inventory mechanics, such as adding, buying, selling
 * and displaying items.
 * @author Thomas Stanley
 *
 */
public class Inventory{
	//creating array of FoodItem objects
	private FoodItem[] inventory;
	private int numItems;
	
	/**
	 * Constructor for Inventory class
	 */
	public Inventory() {
		inventory = new FoodItem[20];
		numItems=0;
	}
	
	/**
	 * Adds an item to the array depending on the FoodItem type.
	 * @param keyboard is Scanner object
	 * @return returns a boolean value
	 */
	public boolean addItem(Scanner keyboard) {

		System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p), or cheese(c)?: ");
		String option = keyboard.next();
		
		//start of menu
		switch(option) {
		case "f": 
			for(int i =0;i<inventory.length;i++) {
			if(inventory[i]==null) {
				inventory[i]=new Fruit();
				System.out.println("Enter the code for the item: ");
				int itemCode=keyboard.nextInt();
				alreadyExists(itemCode);
				if(alreadyExists(itemCode)!=-1) {
					System.out.println("Item code already exists");
					break;
				}else {
				inventory[i].itemCode=itemCode;
				inventory[i].addItem(keyboard);
				break;
				}
				}
			}
			break;
			
			case "v": 
			for(int i =0;i<inventory.length;i++) {
			if(inventory[i]==null) {
				inventory[i]=new Vegetable();
				System.out.println("Enter the code for the item: ");
				int itemCode=keyboard.nextInt();
				alreadyExists(itemCode);
				if(alreadyExists(itemCode)!=-1) {
					System.out.println("Item code already exists");
					break;
				}else {
				inventory[i].itemCode=itemCode;
				inventory[i].addItem(keyboard);
				break;
					}
				}
			}
			break;
			
			case "p":
		    for(int i =0;i<inventory.length;i++) {
		    if(inventory[i]==null) {
		    	inventory[i]=new Preserve();
		    	System.out.println("Enter the code for the item: ");
				int itemCode=keyboard.nextInt();
				alreadyExists(itemCode);
				if(alreadyExists(itemCode)!=-1) {
					System.out.println("Item code already exists");
					break;
				}else {
				inventory[i].itemCode=itemCode;
		    	inventory[i].addItem(keyboard);
		    	break;
		    		}
		    	}
		    }
		    break;
		    
			case "c":
			for(int i =0;i<inventory.length;i++) {
			if(inventory[i]==null) {
				inventory[i]=new Cheese();
				System.out.println("Enter the code for the item: ");
				int itemCode=keyboard.nextInt();
				alreadyExists(itemCode);
				if(alreadyExists(itemCode)!=-1) {
					System.out.println("Item code already exists");
					break;
				}else {
					inventory[i].itemCode=itemCode;
				    inventory[i].addItem(keyboard);
				    break;
				    }
				 }
			}
			//error message is displayed on incorrect entry
		    default:
		    	System.out.println("Please enter valid item type, (f), (v), (p), or (c): ");
			}
		return true;
	}
	/**
	 * Checks if the given item code already exists in the array. Prevents duplicate entries.
	 * @param itemCode is the item code of of the FoodItem
	 * @return returns the index of the array in which the item code matches.
	 */
	public int alreadyExists(int itemCode) {
		
		for(int i =0; i<inventory.length;i++) {
			try {
			if(inventory[i].itemCode==itemCode) {
				return i;
			}
			}catch(NullPointerException NPE) {
				
			}
		}
		return -1;
	}
	
	/**
	 * Displays each entered item in the array. Only prints entries with an item code
	 */
	@Override
	public String toString() {
		System.out.println("Inventory\n");
		try {
		for(int i =0; i<inventory.length;i++) {
			if(inventory[i].itemCode!=0) {
			System.out.print(inventory[i].toString());
			}
			}
			}catch(NullPointerException NPE) {
				
			}
		return "";
	}
	/**
	 * Raises and lowers the itemQuantityInStock value of any given element in array, given an item code.
	 * Checks to see if buy amount or sell amount is less than 0.
	 * @param keyboard Scanner object
	 * @param buyOrSell If true, item is bought, if false item is sold.
	 * @return returns boolean value
	 */
	public boolean updateQuantity(Scanner keyboard, boolean buyOrSell) {
		int codeInput;
		System.out.println("Enter valid item code: ");
		codeInput=keyboard.nextInt();
		alreadyExists(codeInput);
		//if true, item is bought
		if(buyOrSell==true) {
			if(alreadyExists(codeInput)!=-1) {
				System.out.println("Enter valid quantity to buy: ");
				int buyAmount = keyboard.nextInt();
						if(buyAmount<=0) {
							System.out.println("Invalid Quantity\nError could not buy item...");
						}
				inventory[alreadyExists(codeInput)].updateItem(buyAmount,true);
				}else {
					System.out.println("Code not found in inventory...\nError...Code could not buy item");
				}
			//if false, item is sold
		}else if(buyOrSell==false) {
			if(alreadyExists(codeInput)!=-1) {
				System.out.println("Enter valid quantity to sell: ");
				int sellAmount = keyboard.nextInt();
						if(sellAmount<=0) {
							System.out.println("Invalid Quantity...\nError could not sell item");
						}
				inventory[alreadyExists(codeInput)].updateItem(sellAmount,false);
				}else {
					System.out.println("Code not found in inventory...\nError...could not sell item");
				}
		}
		return false;
	}
}
