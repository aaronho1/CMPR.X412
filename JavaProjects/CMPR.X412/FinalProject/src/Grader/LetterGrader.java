//Designate this as part of the Grader package
package Grader;

//Import exception, file, reader and collection classes
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Student class
 * 
 * This is the Student class that will be instantiated to store information
 * about the students and their test scores. This is part of the solution for
 * the Final project
 * 
 * All required methods and variables for the Student are placed here. Upon
 * instantiation, an object from the Student class will be created and store the
 * name of the student from the input file and their test scores. The class also
 * contains getter and setter methods to store and retrieve the letter grade of
 * the student.
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-17-2021
 *
 */
class Student implements Comparable<Student> {
	// Class variables
	// Can only access through getter and setter
	private String studentName;
	private LinkedList<Integer> studentScores;
	private char letterGrade;

	// Student() constructor
	/**
	 * @param no input
	 * 
	 *           The empty default constructor for Student. This will run when a
	 *           Student object is instantiated
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public Student() {

	}// end of Student constructor

	// Student(String studentName) constructor
	/**
	 * @param String studentName
	 * 
	 *               The overloaded constructor for Student. This will run when a
	 *               Student object is instantiated and will take an input of a
	 *               string. The string inputed will be assigned to the name
	 *               variable of the Student object.
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public Student(String studentName) {
		this.studentName = studentName;
		studentScores = new LinkedList<Integer>();
	}// end of Student(String studentName) constructor

	// getLetterGrade getter method
	/**
	 * @param no input
	 * 
	 *           This method will return the letter grade of the student.
	 * 
	 * @exception no exception
	 * @return char letterGrade
	 **/
	public char getLetterGrade() {
		return letterGrade;
	}// end of getLetterGrade getter method

	// setLetterGrade setter method
	/**
	 * @param no input
	 * 
	 *           This method will set the letter grade of the student.
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public void setLetterGrade(char letterGrade) {
		this.letterGrade = letterGrade;
	}// end of setLetterGrade setter method

	// getStudentName getter method
	/**
	 * @param no input
	 * 
	 *           This method will return the name of the student.
	 * 
	 * @exception no exception
	 * @return String studentName
	 **/
	public String getStudentName() {
		return studentName;
	}// end of getStudentName getter method

	// getStudentScores getter method
	/**
	 * @param no input
	 * 
	 *           This method will return the array of test scores of the student.
	 * 
	 * @exception no exception
	 * @return LinkedList<Integer> studentScores
	 **/
	public LinkedList<Integer> getStudentScores() {
		return studentScores;
	}// end of getStudentScores getter method

	// loadStudentScores method
	/**
	 * @param int score
	 * 
	 *            This method will store the scores from the input file into the
	 *            specific student. This is so that each student will contain their
	 *            own test score data.
	 * 
	 * @exception Exception e
	 * @return no return
	 **/
	public void loadStudentScores(int score) {
		try {

			// Loop through token stream to modify and write output to disk
			// until end of the file
			studentScores.add(score);

		} catch (Exception e) {
			// Tell user that an error was found
			System.out.printf("Error was found: " + e.getMessage());

			// Exit if file is not found
			System.exit(-1);

		}
	}// end of loadStudentScores method

	// compareTo method
	/**
	 * @param Student o
	 * 
	 *                This method overrides the inherited compareTo method with that
	 *                of the Student object so that the Comparator interface can be
	 *                used to order the array of students alphabetically.
	 * 
	 * @exception no exception
	 * @return int compareTo()
	 **/
	@Override
	public int compareTo(Student o) {

		// Return the studentName compared to the passed object's studentName
		// This is to order the students alphabetically
		return this.studentName.compareTo(o.studentName);

	}// end of compareTo method
}// end of Student class

//
/**
 * LetterGrader class
 * 
 * This is part of the solution for the Final project
 * 
 * This is an public class that does most of the work in reading input data,
 * calculating grades and class averages and then printing the output in disk
 * file and to console.
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-17-2021
 *
 */
public class LetterGrader implements IGrader {
	// Declare BufferedReader and PrintWriter objects for
	BufferedReader bufferedReader;
	PrintWriter outputText;

	// Message for users upon successful file read
	String message;

	// Array of StudentScore Objects
	ArrayList<Student> studentScore = new ArrayList<Student>();

	// Declare Student class
	Student student;

	// Declare arrays to hold scores for Q1, Q2, Q3, Q4, Mid1,Mid2, and Final
	ArrayList<Integer> quizOneScores = new ArrayList<Integer>();
	ArrayList<Integer> quizTwoScores = new ArrayList<Integer>();
	ArrayList<Integer> quizThreeScores = new ArrayList<Integer>();
	ArrayList<Integer> quizFourScores = new ArrayList<Integer>();
	ArrayList<Integer> midtermOneScores = new ArrayList<Integer>();
	ArrayList<Integer> midTermTwoScores = new ArrayList<Integer>();
	ArrayList<Integer> finalScores = new ArrayList<Integer>();

	// Declare Averages, Min and Max arrays to hold values
	ArrayList<Float> averageScores = new ArrayList<Float>();
	ArrayList<Integer> minimumScores = new ArrayList<Integer>();
	ArrayList<Integer> maximumScores = new ArrayList<Integer>();

	// LetterGrader() constructor
	/**
	 * @param no input
	 * 
	 *           The empty default constructor for LetterGrader. This will run when
	 *           a LetterGrader object is instantiated
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public LetterGrader() {

	}// end of LetterGrader constructor

	// LetterGrader() constructor
	/**
	 * @param String in, String out
	 * 
	 *               The overloaded constructor for LetterGrader. This will run when
	 *               a LetterGrader object is instantiated and create BufferedReader
	 *               and outputText objects for reading the input and writing to the
	 *               disk.
	 * 
	 * @exception FileNotFoundException e, Exception e
	 * @return no return
	 **/
	public LetterGrader(String in, String out) {
		try {

			// If command args contains less than 2 strings, display these messages
			if (in.isEmpty() == false && out.isEmpty() == false) {
				// Create instance of BufferedReader
				bufferedReader = new BufferedReader(new FileReader(in.isEmpty() ? "input_final.txt" : in));

				// create output file to write to
				outputText = new PrintWriter(new FileOutputStream(out.isEmpty() ? "output_final.txt" : out), true);

				// Write message for output
				message = "Letter grade has been calculated for students listed in input file " + in
						+ " and written to output file " + out;

			}
			// If the length of args is greater than 2, throw FileNotFoundException
			// exception
			else {
				throw new FileNotFoundException();
			}

		} catch (FileNotFoundException e) {
			// Print FileNotFoundException
			System.out.print("FileNotFound Exception thrown: " + e.getMessage() + "\n");

			// Exit System
			System.exit(-1);
		} catch (Exception e) {

			// Print Exception
			System.out.print("Exception thrown: " + e.getMessage() + "\n");

			// Exit System
			System.exit(-1);
		}
	}// end of LetterGrader constructor

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
	@Override
	public void readScore() {
		// Create string variable to hold input lines
		String s;

		// Create nextToken to hold token values from stream
		int nextToken;

		// counter to track which score to place in which approipriate test array
		int classScoreCounter = 1;

		try {
//			// display output to the screen
//			while ((s = bufferedReader.readLine()) != null) {
//				// print to console
//				System.out.printf(s);
//			}

			// Instantiate StreamTokenizer to read from stream
			StreamTokenizer parseInput = new StreamTokenizer(bufferedReader);

			// Include commas to be used as delimitters
			parseInput.whitespaceChars(',', ',');

			// Remove white space as delimitters and treat as words
			parseInput.wordChars(' ', ' ');

			// Loop through token stream to modify and write output to disk
			// until end of the file
			do {
				// Store the next token in the stream into variable
				nextToken = parseInput.nextToken();

				// If the stream is not at the end of the line and the next token is a word
				// write the word
				if (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_WORD) {

					// Begin a new line after the first line
					if (parseInput.lineno() > 1) {

						// Add the student to the array of students
						studentScore.add(student);
					}

					// Create a new Student by passing the name to the constructor
					student = new Student(parseInput.sval);

					// Initialize classScoreCounter to 1
					classScoreCounter = 1;

				}
				// If the stream is not at the end of the line and the next token is a number
				// write the number
				else if (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_NUMBER) {

					// Store the number input into a integer
					int integerInput = (int) parseInput.nval;

					// call the loadStudentScores method from the object created and load scores
					// into the object
					student.loadStudentScores(integerInput);

					// Depending on the counter, store the score into the appropriate test array
					switch (classScoreCounter) {
					case 1:
						quizOneScores.add(integerInput);
						break;
					case 2:
						quizTwoScores.add(integerInput);
						break;
					case 3:
						quizThreeScores.add(integerInput);
						break;
					case 4:
						quizFourScores.add(integerInput);
						break;
					case 5:
						midtermOneScores.add(integerInput);
						break;
					case 6:
						midTermTwoScores.add(integerInput);
						break;
					case 7:
						finalScores.add(integerInput);
						break;
					}

					// increment counter variable
					++classScoreCounter;

				} else if (nextToken == StreamTokenizer.TT_EOF) {
					// Add the student to the array of students
					studentScore.add(student);
				}
			} while (nextToken != StreamTokenizer.TT_EOF);
		}
		// Catch any exceptions like IOException
		catch (IOException e) {
			// Report on the error
			System.out.print("IO Exception thrown: " + e.getMessage() + "\n");

			// Exit program
			System.exit(-1);
		} catch (Exception e) {
			// Report on the error
			System.out.print("Exception thrown: " + e.getMessage() + "\n");

			// Exit program
			System.exit(-1);

		}
	}// end of readScore method

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
	@Override
	public void calcLetterGrade() {

		// Loop through the array of students to access scores
		for (int studentIndex = 0; studentIndex < studentScore.size(); ++studentIndex) {

			// Declare finalScore variable to hold the final score
			int finalScore = 0;

			// Loop through the student's scores
			for (int scoreIndex = 0; scoreIndex < studentScore.get(studentIndex).getStudentScores()
					.size(); ++scoreIndex) {

				// Depending on the index, we will calculate and add to the finalScore
				switch (scoreIndex) {
				// Calculate Quiz 1 weighted score and add to the final score
				case 0:
					finalScore += studentScore.get(studentIndex).getStudentScores().get(scoreIndex) * .10;
					break;
				// Calculate Quiz 2 weighted score and add to the final score
				case 1:
					finalScore += studentScore.get(studentIndex).getStudentScores().get(scoreIndex) * .10;
					break;
				// Calculate Quiz 3 weighted score and add to the final score
				case 2:
					finalScore += studentScore.get(studentIndex).getStudentScores().get(scoreIndex) * .10;
					break;
				// Calculate Quiz 4 weighted score and add to the final score
				case 3:
					finalScore += studentScore.get(studentIndex).getStudentScores().get(scoreIndex) * .10;
					break;
				// Calculate MidI weighted score and add to the final score
				case 4:
					finalScore += studentScore.get(studentIndex).getStudentScores().get(scoreIndex) * .20;
					break;
				// Calculate MidII weighted score and add to the final score
				case 5:
					finalScore += studentScore.get(studentIndex).getStudentScores().get(scoreIndex) * .15;
					break;
				// Calculate Final project weighted score and add to the final score
				case 6:
					finalScore += studentScore.get(studentIndex).getStudentScores().get(scoreIndex) * .25;
					break;
				}

				// Calculate and store the letter grade for the student into the instance
				if (finalScore >= 90) {
					// if the student's score is over 90
					studentScore.get(studentIndex).setLetterGrade('A');
				} else if (finalScore >= 80 && finalScore <= 89) {
					// if the student's score is between 80 and 89
					studentScore.get(studentIndex).setLetterGrade('B');
				} else if (finalScore >= 70 && finalScore <= 79) {
					// if the student's score is between 70 and 79
					studentScore.get(studentIndex).setLetterGrade('C');
				} else if (finalScore >= 60 && finalScore <= 69) {
					// if the student's score is between 60 and 69
					studentScore.get(studentIndex).setLetterGrade('D');
				} else if (finalScore <= 59) {
					// if the student's score is below 59
					studentScore.get(studentIndex).setLetterGrade('F');
				}
			}

		}

	}// end of calcLetterGrade method

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
	@Override
	public void calcAverages(ArrayList<Integer> testScores) {
		// Declare variables to store total, max and minimum for calculations and
		// storage into arrays
		float total = 0;
		int max = 0;
		int min = 0;

		// Calculate Averages
		for (int i = 0; i < testScores.size(); i++) {
			// Compare each quiz score to find max
			max = (testScores.get(i) > max) ? testScores.get(i) : max;

			// store and compare to other quiz scores to find min
			min = (i == 0) ? testScores.get(i) : (testScores.get(i) < min) ? testScores.get(i) : min;

			// Find total scores from all students
			total += testScores.get(i);
		}

		// Calculate average
		float average = total / testScores.size();

		// Add scores to the arrays
		averageScores.add(average);
		minimumScores.add(min);
		maximumScores.add(max);

	}// end of calcAverages method

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
	@Override
	public void printGrade() {
		// Sort the collection of students by their first name descending
		Collections.sort(studentScore);

		// Print the student name along with their letter grade
		for (int studentIndex = 0; studentIndex < studentScore.size(); ++studentIndex) {
			outputText.printf("%-25s %s\n", studentScore.get(studentIndex).getStudentName() + ":",
					studentScore.get(studentIndex).getLetterGrade());

		}

	}// end of printGrade method

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
	@Override
	public void displayAverages() {
		// Call calcAverages method for all test arrays
		calcAverages(quizOneScores);
		calcAverages(quizTwoScores);
		calcAverages(quizThreeScores);
		calcAverages(quizFourScores);
		calcAverages(midtermOneScores);
		calcAverages(midTermTwoScores);
		calcAverages(finalScores);

		// Print the message of the accepted input file and output file names
		System.out.println(message);

		// Print the class average, minimum and maximum for each test score
		System.out.println("\n\nHere is the class averages:");
		System.out.printf("%15s%9s%9s%9s%10s%10s%9s", "Q1", "Q2", "Q3", "Q4", "MidI", "MidII", "Final");

		// Print the average line first
		System.out.printf("\nAverage:");

		// loop through the list of averages and print
		for (int i = 0; i < averageScores.size(); ++i) {
			System.out.printf("%9.2f", averageScores.get(i));
		}

		// Print the minimum line next
		System.out.printf("\nMinimum:");

		// loop through the list of minimums and print
		for (int i = 0; i < minimumScores.size(); ++i) {
			System.out.printf("%9d", minimumScores.get(i));
		}

		// Print the maximum line next
		System.out.printf("\nMaximum:");

		// loop through the list of maximums and print
		for (int i = 0; i < maximumScores.size(); ++i) {
			System.out.printf("%9d", maximumScores.get(i));
		}

	}// end of displayAverages method

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
	@Override
	public void doCleanup() {
		// store variable to continue looping or not if given invalid answer
		boolean repeat = false;

		// loop through prompting until user makes valid input
		do {
			try {
				// Prompt user to press enter to continue
				System.out.printf("\n\n\nPress ENTER to continue ....\n\n");

				// Repeat user input
				System.in.read();

				// Close files and resources
				bufferedReader.close();
				outputText.close();

				// Exit loop when valid input is made
				repeat = false;
			} catch (IOException e) {
				// Tell user about the exception and prompt to try again
				System.out.print("IO Exception thrown: " + e.getMessage() + "\n");
				System.out.printf("Please try again");

				// Continue loop when invalid input is made
				repeat = true;
			} catch (Exception e) {
				// Tell user about the exception and prompt to try again
				System.out.print("Exception thrown: " + e.getMessage() + "\n");
				System.out.printf("Please try again");

				// Continue loop when invalid input is made
				repeat = true;
			}
		} while (repeat);

	}// end of doCleanup method

}// end of LetterGrader
