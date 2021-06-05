//Designate this as part of the Grader package
package Grader;

//Import collection and exception classes
import java.io.IOException;
import java.util.ArrayList;

/**
 * This is part of the solution for the Final project
 * 
 * This is an interface used to implement interface methods into the class that
 * implements the interface. This interface contains a number of methods that do
 * not return values and instead alter the value of variables in the implemented
 * class.
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-17-2021
 *
 */
public interface IGrader {
	// readScore method
	/**
	 * @param no input
	 * 
	 *           This overrides the readScore method from the IGrader interface.
	 *           This will read the data from the input file and instantiate an
	 *           object from the Student class by passing the student name for each
	 *           student in the file. This will also add test scores to the
	 *           appropriate arrays.
	 * 
	 * @exception IOException e, Exception e
	 * @return no return
	 **/
	public void readScore();

	// calcLetterGrade method
	/**
	 * @param no input
	 * 
	 *           This overrides the calcLetterGrade method from the IGrader
	 *           interface. This will calculate the letter grade from the test score
	 *           from each student. This will store the calculated letter grade into
	 *           each student.
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public void calcLetterGrade();

	// calcAverages method
	/**
	 * @param ArrayList<Integer> testScores
	 * 
	 *                           This overrides the calcAverages method from the
	 *                           IGrader interface. This will calculate overall
	 *                           average, minimum and maximum for each test score.
	 *                           It will then add that to the appropriate array
	 *                           list.
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	void calcAverages(ArrayList<Integer> testScores);

	// printGrade method
	/**
	 * @param no input
	 * 
	 *           This overrides the printGrade method from the IGrader interface.
	 *           This will first sort the studentScore array alphabetically. Then it
	 *           will print the student name along with their letter grade to an
	 *           output file.
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public void printGrade();

	// displayAverages method
	/**
	 * @param no input
	 * 
	 *           This overrides the displayAverages method from the IGrader
	 *           interface. This will display the averages, minimums and maximums of
	 *           each test score from the class.
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public void displayAverages();

	// doCleanup method
	/**
	 * @param no input
	 * 
	 *           This overrides the doCleanup method from the IGrader interface.
	 *           This will close files and other resources.
	 * 
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public void doCleanup();

}// end of interface IGrader
