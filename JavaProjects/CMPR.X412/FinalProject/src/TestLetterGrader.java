/**
 * 
 */

/**
 * @author AaronHo
 *
 */
public class TestLetterGrader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test if there are two valid arguments, then create object
		// if not give right message and exit
		LetterGrader letterGrader = new LetterGrader(args[0], args[1]);

		// Reads score and stores data in member variables
		letterGrader.readScore();

		//
		letterGrader.calcLetterGrade();

		letterGrader.printGrade();

		letterGrader.displayAverages();
	}

}
