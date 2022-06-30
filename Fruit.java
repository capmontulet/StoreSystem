import java.util.Scanner;

/**
 * Class Fruit Extends FoodItem. Contains data and methods pertaining to fruit object.
 * @author Thomas Stanley
 *
 */
public class Fruit extends FoodItem{
	
	private String orchardName;
	
	/**
	 * Constructor
	 */
	public Fruit() {
		orchardName="";
	}
	/**
	 * Takes user input for values from parent class, then from child class
	 */
	@Override
	public boolean addItem(Scanner keyboard) {
		
		if(super.addItem(keyboard)==true) {
		System.out.println("Enter the name of the orchard supplier: ");
		orchardName=keyboard.nextLine();
		}
		return true;
		
	}
	/**
	 * Displays values from parent class, then value specific to child class
	 */
	@Override
	public String toString() {
		System.out.print(super.toString());
		return "Orchard supplier: "+orchardName+"\n";
		
	}
}