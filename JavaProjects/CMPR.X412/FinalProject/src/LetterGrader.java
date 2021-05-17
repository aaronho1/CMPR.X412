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
 * 
 */

/**
 * @author AaronHo
 *
 */

class Student implements Comparable<Student> {
	// Class variables that would be instantiated
	// Can only access through getter and setter
	private String studentName;
	private LinkedList<Integer> studentScores;
	private char letterGrade;

	// Student() empty constructor
	public Student() {

	}

	// getLetterGrade method
	/**
	 * @return the letterGrade
	 */
	public char getLetterGrade() {
		return letterGrade;
	}

	// setLetterGrade method
	/**
	 * @param letterGrade the letterGrade to set
	 */
	public void setLetterGrade(char letterGrade) {
		this.letterGrade = letterGrade;
	}

	// Overloaded Student constructor
	public Student(String studentName) {
		this.studentName = studentName;
		studentScores = new LinkedList<Integer>();
	}

	// getStudentName method
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	// getStudentScores method
	/**
	 * @return the studentScores
	 */
	public LinkedList<Integer> getStudentScores() {
		return studentScores;
	}

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
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.studentName.compareTo(o.studentName);
	}
}

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

	// default constructor
	public LetterGrader() {

	}

	// overload constructor
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Override
	public void readScore() {
		// Create string variable to hold input lines
		String s;

		// Create nextToken to hold token values from stream
		int nextToken;

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
						studentScore.add(student);
						System.out.printf("\n");
					}

					// Create a new Student by passing the name to the constructor
					student = new Student(parseInput.sval);

					// Initialize classScoreCounter to 1
					classScoreCounter = 1;

					// Write the string portion of the token stream
					System.out.printf("Student #" + parseInput.lineno() + " is: " + "\"" + parseInput.sval + "\""
							+ " whose raw scores are:");

				}
				// If the stream is not at the end of the line and the next token is a number
				// write the number
				else if (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_NUMBER) {

					// Store the number input into a integer
					int integerInput = (int) parseInput.nval;

					student.loadStudentScores(integerInput);

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

					++classScoreCounter;

					// write the integer portion of the token stream
					System.out.printf("  " + integerInput + ":");

				} else if (nextToken == StreamTokenizer.TT_EOF) {
					// Add the student to the array of students
					studentScore.add(student);
				}
			} while (nextToken != StreamTokenizer.TT_EOF);

		} catch (IOException e) {
			e.getMessage();
		}
	}

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

	}

	@Override
	public void calcAverages(ArrayList<Integer> testScores) {
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

	}

	@Override
	public void printGrade() {
		// Sort the collection of students by their first name
		Collections.sort(studentScore);

		// TODO Auto-generated method stub
		for (int studentIndex = 0; studentIndex < studentScore.size(); ++studentIndex) {
			outputText.printf("%-25s %s\n", studentScore.get(studentIndex).getStudentName() + ":",
					studentScore.get(studentIndex).getLetterGrade());

		}

	}

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

		System.out.printf("\n\nAverage:\t %7.2f", averageScores.get(0));

	}

	@Override
	public void doCleanup() {
		// TODO Auto-generated method stub

	}

}
