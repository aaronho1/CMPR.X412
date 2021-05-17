
// import IO classes
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

/**
 * @author AaronHo
 * 
 * 
 *         This is the solution for Homework 9
 * 
 *         All required methods and variables for Homework 9 have been placed in
 *         the Exercise5 class. This class implements I/O concepts to process
 *         input files and create and write to output files. Method solutions
 *         have been placed in the Main method.
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-08-2021
 *
 */
public class Exercise5 {

	// processCLArguments method
	/**
	 * @param String [] args
	 * 
	 *               This will process the args String input and print the input and
	 *               output file names. All error handling is handled within this
	 *               method. Program will exit after processing the args input.
	 * 
	 * @exception FileNotFoundException e, Exception e
	 * @return no return
	 **/
	public static void processCLArguments(String[] args) {

		try {
			// If command args contains less than 2 strings, display these messages
			if (args.length < 3) {
				System.out.printf("Usage: java Exercise5 inputFile outputFile\n\n");

				// If the arguments contains input and output file names, it will display the
				// message like this
				System.out.printf("Input will be read from: %s" + "\nOutput will be written into: %s\n\n",
						args[0].isEmpty() ? "input_final.txt" : args[0],
						args[1].isEmpty() ? "output_final.txt" : args[1]);

			}
			// If the length of args is greater than 2, throw FileNotFoundException
			// exception
			else {
				throw new FileNotFoundException();
			}

		}
		// Start with more specific to more general
		catch (FileNotFoundException e) {
			// Tell user that no input and output files have been found
			System.out.println("No input output files found\n\n");
		} catch (Exception e) {
			// Tell user that they made an invalid input
			System.out.printf("Error found: %s\n\n", e.getMessage());

		}
	} // end of processCLArguments

	// processInputOutputFiles method
	/**
	 * @param String [] args
	 * 
	 *               This will process the args String input and then format and
	 *               print the content in the input file to the console. The content
	 *               will also be formatted and written to the output file. All
	 *               error handling is handled within this method. Program will exit
	 *               after processing the args input.
	 * 
	 * @exception FileNotFoundException e, IOException e, Exception e
	 * @return no return
	 **/
	public static void processInputOutputFiles(String[] args) {

		// Create a count variable for the number of students or lines in
		// input file
		int studentCount = 0;

		// Create string variable to hold input lines
		String s;

		try {

			// Create instance of BufferedReader to print to console
			BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

			// display output to the screen
			while ((s = bufferedReader.readLine()) != null) {
				// print to console
				System.out.printf("Student #: " + ++studentCount + " " + s + "\n");

			}

			// Close BufferedReader
			bufferedReader.close();

			// write to output by creating new FileReader and BufferedReader
			BufferedReader bufferedReaderOutput = new BufferedReader(new FileReader(args[0]));

			// Instantiate StreamTokenizer to read from stream
			StreamTokenizer parseInput = new StreamTokenizer(bufferedReaderOutput);

			// Include commas to be used as delimitters
			parseInput.whitespaceChars(',', ',');

			// Remove white space as delimitters and treat as words
			parseInput.wordChars(' ', ' ');

			// create output file to write to
			PrintWriter outputText = new PrintWriter(
					new FileOutputStream(args[1].isEmpty() ? "output_final.txt" : args[1]), true);

			// Create nextToken to hold token values from stream
			int nextToken;

			// Loop through token stream to modify and write output to disk
			// until end of the file
			do {

				// Store the next token in the stream into variable
				nextToken = parseInput.nextToken();

				{
					// If the stream is not at the end of the line and the next token is a word
					// write the word
					if (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_WORD) {

						// Begin a new line after the first line
						if (parseInput.lineno() > 1) {
							outputText.write("\n");
						}

						// Write the string portion of the token stream
						outputText.write("Student #" + parseInput.lineno() + " is: " + "\"" + parseInput.sval + "\""
								+ " whose raw scores are:");

					}
					// If the stream is not at the end of the line and the next token is a number
					// write the number
					else if (nextToken != StreamTokenizer.TT_EOL && nextToken == StreamTokenizer.TT_NUMBER) {

						// Store the number input into a integer
						int integerToken = (int) parseInput.nval;

						// write the integer portion of the token stream
						outputText.write("  " + integerToken + ":");

					}

				}

			} while (nextToken != StreamTokenizer.TT_EOF);

			// Close BufferedReader
			outputText.close();

		} // Start with more specific to more general
		catch (FileNotFoundException e) {
			// Tell user that no input and output files have been found
			System.out.println("No input output files found");

			// Exit if file is not found
			System.exit(-1);
		} catch (IOException e) {
			// Tell user that an error was found
			System.out.printf("I/O error was found: " + e.getMessage());

			// Exit when error was found
			System.exit(-1);
		} catch (Exception e) {
			// Tell user that an error was found
			System.out.printf("Error was found.");

			// Exit if file is not found
			System.exit(-1);

		}

	}// end of processInputOutputFiles

	// printResponse method
	/**
	 * @param no param
	 * 
	 *           This will print the response to question 9.3 in homework 9 :
	 *           "Research on how to give the command line arguments in your class
	 *           file using Eclipse."
	 * 
	 * @exception no exception
	 * @return no return
	 **/
	public static void printResponse() {
		System.out.printf("\n\na) You can supply input parameters to your application before your \r\n"
				+ "program starts by running through the command window in Windows or through the\r\n"
				+ "terminal window in MAC. You can first compile your java program by first typing\r\n"
				+ "'javac' followed by your class name. To run your java program, you will type 'java'\r\n"
				+ "followed by the class name and then followed by your input parameters separated by a space.\r\n"
				+ "These parameters will be stored within the args parameter in your main method. They will be \r\n"
				+ "parsed by space by default. For example, typing 'java FirstProgram Hello World! will parse\r\n"
				+ "the 'Hello World!' input into args[0] = Hello and args[1] = World!.Be sure when you are compiling\r\n"
				+ "and running your program, you are doing so in the correct directory of the class file in the command\r\n"
				+ "prompt.\r\n" + "\r\n"
				+ "Within editors such as Eclipse, you can edit the Properties settings of the class or enable the program\r\n"
				+ "to run with configurations. In Eclipse, go to the Properties of the class that you are running and select \r\n"
				+ "Run/Debug Settings. By creating or editing an existing launch configuration setting and then going to the \r\n"
				+ "Arguments tab, you can set the input parameters that you would like to pass as arguments into Main. Run with\r\n"
				+ "configurations allows you to do the same thing and you can configure your launch settings with the input parameters\r\n"
				+ "that you want to pass before the program runs. Like running it from the command prompt, the parameters will \r\n"
				+ "parsed and stored in the args parameter in your main method where you can call the args array to return the input\r\n"
				+ "parameters that you want. \r\n" + "\r\n"
				+ "b)You can process these arguments in your program by just calling args parameter as any other array type variable.\r\n"
				+ "By calling args[] with the appropriate index, you can get the arguments in which you have passed as input parameters. \r\n"
				+ "Those values can be then used to for functions such as database access and user security access.For I/O type parameters, with the \r\n"
				+ "appropriate placement of the input files, the names of the input and output files can be defined as arguments in the program. From there, you \r\n"
				+ "can use the File and FileReader classes to process those files, and instantiate the Scanner or BufferedReader + StringTokenizer/StreamTokenizer \r\n"
				+ "classes to read the files. ");
	} // end of printResponse method

	/**
	 * Main
	 * 
	 * @param args
	 * 
	 *             For Homework #9.1 all important codes for this program is written
	 *             in processCLArguments method.
	 *
	 *             For Homework #9.2 all important codes for this program is written
	 *             in the processInputOutputFiles method.
	 * 
	 *             For Homework #9.3 all important codes for this program is written
	 *             in the printResponse method
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 */
	public static void main(String[] args) {
		// Solution for Homework 9.1
		processCLArguments(args);

		// Solution for Homework 9.2
		processInputOutputFiles(args);

		// Solution for Homework 9.3
		printResponse();
	}

}
