
//Import of Grader package
import Grader.LetterGrader;

/**
 * @author AaronHo
 * 
 *         TestLetterGrader class
 * 
 *         This is part of the solution for the Final project
 * 
 *         The LetterGrader class is instantiated here and the methods are
 *         called through the object. This is to demonstrate the capabilities of
 *         the LetterGrader class.
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-017-2021
 *
 */
public class TestLetterGrader {

	// main method
	/**
	 * @param input args
	 * 
	 *              This will instantiate the LetterGrader class and call the
	 *              methods to read the input files, calculate letter grade and
	 *              averages, minimum and maximum and print results to the console
	 *              and print the letter grade to the output disk file. All
	 *              exception handling is handled within the methods.
	 * 
	 * @exception no exception
	 * @return no return value
	 **/
	public static void main(String[] args) {
		// test if there are two valid arguments, then create object
		// if not give right message and exit
		LetterGrader letterGrader = new LetterGrader(args[0], args[1]);

		// Reads score and stores data in member variables
		letterGrader.readScore();

		// Determines letter grade and stores information
		letterGrader.calcLetterGrade();

		// Writes grade in output file
		letterGrader.printGrade();

		// Display the averages in console
		letterGrader.displayAverages();

		// Use it to close files and other resources
		letterGrader.doCleanup();

	}// end of Main

}// end of TestLetterGrader
