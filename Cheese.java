import java.util.Scanner;
/**
 * Cheese class extends FoodItem class. Contains data and methods pertaining to cheese object.
 * @author Thomas Stanley
 *
 */
public class Cheese extends FoodItem{

	private float cheeseWeight;
	
	/**
	 * constructor
	 */
	public Cheese(){
		cheeseWeight=0;
	}
	/**
	 * Displays values from parent class, then value specific to child class
	 */
	@Override
	public String toString() {
		System.out.print(super.toString());
		return "Cheese Weight: "+cheeseWeight+"\n";
	}
	
	/**
	 * Takes user input for values from parent class, then from child class
	 */
	@Override
	public boolean addItem(Scanner keyboard) {
		
		if(super.addItem(keyboard)==true) {;
		System.out.print("Enter weight of cheese in grams: ");
		cheeseWeight=keyboard.nextFloat();
		}
		return true;
	}
	
}
