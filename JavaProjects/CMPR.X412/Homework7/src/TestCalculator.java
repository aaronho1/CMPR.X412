
/**
 * 
 */

/**
 * @author AaronHo
 *
 */
public class TestCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OOPCalculator calc = new OOPCalculator();

		while (calc.askCalcChoice() != 5) { // it will set choice
////			calc. askTwoValues (); //it will set two values
////			calc.displayResults(); //do calc, display result
//			// and wait on press enter key
//
			System.out.print(calc.askCalcChoice());
		}
//			calc.displayBye(); //thanks the user for using and waits for press enter key
	} // end main
}
