import java.util.Scanner;
/**
 * Preserve class extends FoodItem Class. Contains data and methods pertaining to preserve object.
 * @author Thomas Stanley
 *
 */
public class Preserve extends FoodItem {
	
	private int jarSize;
	
	/**
	 * constructor
	 */
	public Preserve() {
		jarSize=0;
	}
	/**
	 * Displays values from parent class, then value specific to child class
	 */
	@Override
	public String toString() {
		System.out.print(super.toString());
		return "Size: "+jarSize+"mL\n";
	}
	
	/**
	 * Takes user input for values from parent class, then from child class
	 */
	@Override
	public boolean addItem(Scanner keyboard) {
		super.addItem(keyboard);
		System.out.println("Enter the size of the jar in milliliters: ");
		jarSize=keyboard.nextInt();
		return true;
	}
	
}
