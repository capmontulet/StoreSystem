import java.util.Scanner;
/**
 * Parent object for store system.
 * @author Thomas Stanley
 *
 */
public class FoodItem {

	protected int itemCode;
	private String itemName;
	private float itemPrice;
	private int itemQuantityInStock;
	private float itemCost;
	
/**
 * Constructor
 */
	public FoodItem() {
		
	}
	
/**
 * Overloaded Constructor
 * @param itemCode Code of item
 * @param itemName Name of item
 * @param itemPrice Price of item
 * @param itemQuantityInStock Quantity in stock
 * @param itemCost Cost of item
 */
	public FoodItem(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost) {
		this.itemCode=itemCode;
		this.itemName=itemName;
		this.itemPrice=itemPrice;
		this.itemQuantityInStock=itemQuantityInStock;
		this.itemCost=itemCost;	
	}
/**
 * Takes user input for parameters of the class.
 * @param keyboard Scanner object
 * @return Returns boolean value
 */
	public boolean addItem(Scanner keyboard) {
		
		try {
		System.out.println("Enter the name for the item: ");
		itemName=keyboard.next();
		System.out.println("Enter the quantity for the item: ");
		itemQuantityInStock=keyboard.nextInt();
		System.out.println("Enter the cost of the item: ");
		itemCost=keyboard.nextFloat();
		System.out.println("Enter the sales price of the item: ");
		itemPrice=keyboard.nextFloat();
		keyboard.nextLine();
		}catch(Exception e) {
			System.out.println("Invalid entry");
			keyboard.nextLine();
			return false;
		}
		return true;
	}
	/**
	 * Displays parameters for parent class parameters
	 */
	@Override
	public String toString() {
		return"Item: "+itemCode+" "+itemName+" "+itemQuantityInStock+" Price: $"+itemPrice+" Cost: $"+itemCost+" .";
	}
	/**
	 * Checks to see if two item codes are the same
	 * @param item passed from inventory class.
	 * @return returns boolean value
	 */
	public boolean isEqual(FoodItem item) {
		
		
			if(item.itemCode==itemCode) {
				return true;
			}
			
		return false;
	}
	/**
	 * Reads a valid itemcode from scanner and returns true or false if successful
	 * @param keyboard Scanner object
	 * @return returns boolean object
	 */
	public boolean inputCode(Scanner keyboard) {
		
		System.out.println("Enter the code for the item: ");
		int itemCode=keyboard.nextInt();
		
		return false;
	}
	/**
	 * Changes the item stock with amount value pass from inventory class
	 * @param amount value passed from inventory
	 * @param buyOrSell Adds or minuses amount based on option
	 * @return returns boolean value
	 */
	public boolean updateItem(int amount, boolean buyOrSell) {
		
		if(buyOrSell==true) {
		itemQuantityInStock+=amount;
		}else if(buyOrSell==false) {
			if(itemQuantityInStock-amount<0) {
				System.out.println("Insufficient Stock in inventory...\nError could not sell item");
			}else {
				itemQuantityInStock-=amount;
			}
		}
		return true;
	}
}
