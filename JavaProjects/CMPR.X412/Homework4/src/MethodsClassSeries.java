
/**
 * 
 */

/**
 * This is the solution for Homework #4
 * 
 * All solutions have been put in this class and are
 * handled through methods
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 04-19-2021
 *
 */

import java.util.Scanner;

public class MethodsClassSeries {

	// Homework 4.1
	/**
	 * @param no parameter
	 * 
	 *           Loops are given and and currently asked to determine how many times
	 *           a certain phrase will be printed based on the order of the
	 *           increment operators
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void countLoop() {
		// 4.1.a
		System.out.printf("4.1.a)\nThis loop has the counter increment set to i++\r\n"
				+ "This post increment operator will execute this loop 10 times\n\n");

		// 4.1.b
		System.out.printf("4.1.b)\nThis loop has a counter increment set to ++i\r\n"
				+ "This loop will be executed for a total of 9 times\n\n");

		// 4.1.c
		System.out.printf("4.1.c)\nloop will be executed after 4.1.b\r\n" + "i is not reinitialized\r\n"
				+ "This loop will be executed 0 times\r\n\n");
	}// end of CountLoop

	// Homework 4.2
	/**
	 * @param no parameter
	 * 
	 *           A box made from dashes and vertical bars is printed with only the
	 *           println method
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void printBox() {
		System.out.println("Using brutal force: ");
		System.out.println("--------------------");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("|                  |");
		System.out.println("--------------------");
	} // end of printBox

	// Homework 4.2
	/**
	 * @param no parameter
	 * 
	 *           The box that was made from dashes and vertical bars is modified to
	 *           use while loops and nested while loops instead of using just the
	 *           println method
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void printWhileLoopBox() {

		int h = 0; // counts horizontal positioning
		int v = 0; // counts vertical positioning

		System.out.println("Using while loop: ");

		// Loop 10 times because the box is 10 lines tall
		while (v < 10) {

			// Loop and increment 20 times to print top line
			while (h++ < 20 && v == 0) {

				// print dashes
				System.out.printf("-");

			}

			// begin a new line after the printing top line
			System.out.printf("\n");

			// Loop and increment 8 times to print middle lines
			while (++v < 9) {
				// begin each new middle line with a vertical bar
				System.out.printf("|");

				// reset horizontal counter variable
				h = 0;

				// Loop and increment 18 times to fill out middle lines
				while (h++ < 18) {
					// fill out middle lines with blank space
					System.out.printf(" ");
				}

				// end each middle line with a vertical bar
				System.out.printf("|");

				// after end of each middle line, start a new line
				System.out.printf("\n");

			}

			// reset horizontal counter variable
			h = 0;

			while (h++ < 20 && v == 9) // Loop and increment 20 times to print bottom line
			{
				System.out.printf("-"); // print bottom line box with dashes
			}
		}
	} // end of printWhileLoopBox

	// Homework 4.3
	/**
	 * @param no parameter
	 * 
	 *           The box that was made from dashes and vertical bars with the while
	 *           loop is modified to use do while loops
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void printDoWhileLoopBox() {

		int h = 0; // counts horizontal positioning
		int v = 0; // counts vertical positioning

		System.out.println("Using do while loop: ");

		do {
			// Loop and increment 20 times to print top line
			if (h < 20 && v == 0) {
				// print dashes
				System.out.printf("-");

				// increment horizontal counter
				++h;
			}
			// Loop and increment 8 times to print middle lines
			else if (v > 0 && v < 9) {
				// print vertical bar
				System.out.printf("|");

				// loop 18 times to print spaces in the middle
				do {
					System.out.printf(" ");
				} while (++h < 18);

				// end each line with vertical bar and start new line
				System.out.printf("|\n");

				// increment vertical counter in preparation for new line
				++v;

				// reset horizontal counter
				h = 0;

			} else if (h < 20 && v == 9) {
				// print bottom line box with dashes
				System.out.printf("-");

				// increment horizontal counter
				++h;

			} else {

				// increment vertical counter
				++v;

				// begin a new line
				System.out.printf("\n");

				// reset horizontal counter
				h = 0;
			}
			// continue to loop 10 times because the box is 10 lines tall
		} while (v < 10);

	} // end of printDoWhileLoopBox

	// Homework 4.4
	/**
	 * @param no parameter
	 * 
	 *           The box that was made from dashes and vertical bars with the do
	 *           while loop is modified to use for loops now
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void printForLoopBox() {
		System.out.println("Using for loop: ");

		// loop 10 times because the box is 10 lines tall
		for (int v = 0; v < 10; v++) {

			// Loop and increment 20 times to print top line
			for (int h = 0; h < 20 && v == 0; ++h) {

				// print dashes
				System.out.printf("-");
			}

			// After top line, create a new line
			if (v == 1) {
				System.out.printf("\n");
			}

			// Loop and increment 8 times to print middle lines
			for (; v > 0 && v < 9; ++v) {

				// print vertical bar
				System.out.printf("|");

				// loop 18 times to print spaces in the middle
				for (int h = 0; h < 18; h++) {
					System.out.printf(" ");
				}

				// end each line with vertical bar and start new line
				System.out.printf("|\n");
			}
			// Loop and increment 20 times to print bottom line
			for (int h = 0; h < 20 && v == 9; ++h) {
				// print bottom line box with dashes
				System.out.printf("-");
			}
		}
	}// end of printForLoopBox

	// Homework 4.5
	/**
	 * @param no parameter
	 * 
	 *           The box that was made from dashes and vertical bars with the for
	 *           loop is modified to now take user input for height, width and
	 *           characters
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void printForLoopBoxInput() {
		System.out.println("\nUsing for loop with user input: ");

		int height, width;
		char horizontalChar, verticalChar;

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		// Get user requested height
		System.out.printf("Please enter the height of the box: ");
		height = getInput.nextInt();

		// Get user requested width
		System.out.printf("Please enter the width of the box: ");
		width = getInput.nextInt();

		// Get user requested height character
		System.out.printf("Please enter the height character for the box: ");
		verticalChar = getInput.next().charAt(0);

		// Get user requested width character
		System.out.printf("Please enter the width character for the box: ");
		horizontalChar = getInput.next().charAt(0);

		// loop height times
		for (int v = 0; v < height; v++) {
			// Loop width value to print horizontal top line
			for (int z = 0; z < width && v == 0; ++z) {
				// print horizontal variable input
				System.out.printf("%c", horizontalChar);
			}

			// After top line, create a new line
			if (v == 1) {
				System.out.printf("\n");
			}

			// Loop (height value - 1) times to print middle lines
			for (; v > 0 && v < (height - 1); ++v) {

				// print vertical variable input
				System.out.printf("%c", verticalChar);

				// loop (width value -2) times to print spaces in the middle
				for (int z = 0; z < (width - 2); z++) {
					System.out.printf(" ");
				}

				// end each line with vertical variable input and start new line
				System.out.printf("%c\n", verticalChar);
			}
			// Loop width to print bottom line
			for (int z = 0; z < width && v == (height - 1); ++z) {
				// print bottom line box with horizontal variable input
				System.out.printf("%c", horizontalChar);
			}
		}
	}// end of printForLoopBoxInput

	// Homework 4.6
	/**
	 * @param no parameter
	 * 
	 *           The box that was made from dashes and vertical bars and takes user
	 *           input for height, width and characters is modified to ask the user
	 *           if they want to continue
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/

	public static void printUserInputBox() {
		System.out.println("\nUsing for loop with user input and prompt to continue: ");

		int height, width;
		char horizontalChar, verticalChar, repeat;

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);
		do {
			// Get user requested height
			System.out.printf("\nPlease enter the height of the box: ");
			height = getInput.nextInt();

			// Get user requested width
			System.out.printf("Please enter the width of the box: ");
			width = getInput.nextInt();

			// Get user requested height character
			System.out.printf("Please enter the height character for the box: ");
			verticalChar = getInput.next().charAt(0);

			// Get user requested width character
			System.out.printf("Please enter the width character for the box: ");
			horizontalChar = getInput.next().charAt(0);

			// loop height times
			for (int v = 0; v < height; v++) {
				// Loop width value to print horizontal top line
				for (int z = 0; z < width && v == 0; ++z) {
					// print horizontal variable input
					System.out.printf("%c", horizontalChar);
				}

				// After top line, create a new line
				if (v == 1) {
					System.out.printf("\n");
				}

				// Loop (height value - 1) times to print middle lines
				for (; v > 0 && v < (height - 1); ++v) {

					// print vertical variable input
					System.out.printf("%c", verticalChar);

					// loop (width value -2) times to print spaces in the middle
					for (int z = 0; z < (width - 2); z++) {
						System.out.printf(" ");
					}

					// end each line with vertical variable input and start new line
					System.out.printf("%c\n", verticalChar);
				}
				// Loop width to print bottom line
				for (int z = 0; z < width && v == (height - 1); ++z) {
					// print bottom line box with horizontal variable input
					System.out.printf("%c", horizontalChar);
				}
			}
			// Prompt user if they want to continue
			System.out.printf("\nContinue? Type 'y' for yes: ");

			// store user response to continue or not
			repeat = getInput.next().charAt(0);

		} while (Character.toLowerCase(repeat) == 'y');

		System.out.printf("Thank you for using my box loop program\n\nPress any key to continue . . .");
	}// end of printUserInputBox

	/**
	 * Main
	 * 
	 * @param args : not used in this program
	 * 
	 *             For Homework #4.1 all important codes for this program is written
	 *             in countLoop method.
	 *
	 *             For Homework #4.2 all important codes for this program is written
	 *             in the printBox method and printWhileLoopBox method.
	 * 
	 *             For Homework #4.3 all important codes for this program is written
	 *             in the printDoWhileLoopBox method
	 * 
	 *             For Homework #4.4 all important codes for this program is written
	 *             in the printForLoopBox method.
	 * 
	 *             For Homework #4.5 all important codes for this program is written
	 *             in the printForLoopBoxInput method.
	 * 
	 *             For Homework #4.6 all important codes for this program is written
	 *             in the printUserInputBox method.
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 */

	public static void main(String[] args) {
		// Homework 4.1
		countLoop();

		// Homework 4.2
		printBox();
		printWhileLoopBox();

		// Homework 4.3
		printDoWhileLoopBox();

		// Homework 4.4
		printForLoopBox();

		// Homework 4.5
		printForLoopBoxInput();

		// Homework 4.6
		printUserInputBox();

	}// end of main

}
