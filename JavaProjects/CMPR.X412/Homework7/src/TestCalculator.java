
/**
 * @author AaronHo
 * 
 * 
 *         This is part of the solution for Homework 7
 * 
 *         The OOPCalculator is instantiated here and the classes are called
 *         through the object. This is to demonstrate the capabilities of the
 *         OOPCalculator class.
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-02-2021
 *
 */
public class TestCalculator {

	// main method
	/**
	 * @param args not used
	 * 
	 *             This will instantiate the OOPCalculator class and call the
	 *             methods to display the menu, calculate the user input and display
	 *             the results
	 * 
	 * @exception no exception
	 * @return no return value
	 **/
	public static void main(String[] args) {
		// Create an instance of OOPCalculator
		OOPCalculator calc = new OOPCalculator();

		while (calc.askCalcChoice() != 5) { // it will set choice
			calc.askTwoValues(); // it will set two values
			calc.displayResults(); // do calc, display result
			calc.askToContinue(); // wait on press enter key
		}
		calc.displayBye(); // thanks the user for using and ends program
	} // end main
} // end of TestCalculator
