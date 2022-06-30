import java.util.Scanner;

/**
 * Vegetable class extends FoodItem class. Contains data and methods pertaining to vegetable object.
 * @author Thomas Stanley
 *
 */
public class Vegetable extends FoodItem{
	
	private String farmName;
	
	/**
	 * Constructor
	 */
	public Vegetable() {
		farmName="";
	}
	
	/**
	 * Takes user input for values from parent class, then from child class
	 */
	@Override
	public boolean addItem(Scanner keyboard) {
		if(super.addItem(keyboard)==true) {;
		System.out.println("Enter the name of the farm supplier: ");
		farmName=keyboard.nextLine();
		}
		return true;
	}
	
	/**
	 * Displays values from parent class, then value specific to child class
	 */
	@Override
	public String toString() {
		
		System.out.print(super.toString());
		return "Farm supplier: "+farmName+"\n";
	}
}
