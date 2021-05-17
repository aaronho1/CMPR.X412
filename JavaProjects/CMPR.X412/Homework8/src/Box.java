import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author AaronHo
 *
 */
public class Box {

	// Create class static variables about box
	private static int width;
	private static char verticalChar;
	private static int height;
	private static char horizontalChar;

	public static void askBoxInfo() {
		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		// store variable to continue looping or not if given invalid answer
		boolean repeat = true;

		// Loop until user makes valid input
		do {
			try {
				// Get user requested height
				System.out.printf("\nPlease enter the height of the box: ");
				height = getInput.nextInt();

				// Get user requested width
				System.out.printf("\nPlease enter the width of the box: ");
				width = getInput.nextInt();

				// Get user requested height character
				System.out.printf("\nPlease enter the horizontal charcters to draw box: ");
				horizontalChar = getInput.next().charAt(0);

				// Get user requested width character
				System.out.printf("\nPlease enter the vertical charcters to draw box: ");
				verticalChar = getInput.next().charAt(0);

				// do not repeat if input is valid
				repeat = false;
			}
			// Catch any exceptions like InputMismatchException
			catch (InputMismatchException e) {
				// Tell the user they made an invalid choice and to try again
				System.out.printf("You have entered an invalid choice, please re-enter your choice: ");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();

			} catch (Exception e) {
				// Tell user that they made an invalid input
				System.out.printf("Invalid input. Please try again.");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();

			}
		} while (repeat);
//
//		// close scanner
//		getInput.close();
	}

	public static int drawHorizontalLine() {
		int verticalCounter = 0;

		// Loop width value to print horizontal top line
		for (int z = 0; z < width; ++z) {
			// print horizontal variable input
			System.out.printf("%c", horizontalChar);
		}

		// print a new line after creating horizontal line
		System.out.print("\n");

		// return value of verticalCounter to be used in next method
		return ++verticalCounter;

	}

	public static int drawVerticalLine(int verticalCounter) {
		// Loop (height value - 1) times to print middle lines
		for (; verticalCounter > 0 && verticalCounter < (height - 1); ++verticalCounter) {

			// print vertical variable input
			System.out.printf("%c", verticalChar);

			// loop (width value -2) times to print spaces in the middle
			for (int z = 0; z < (width - 2); z++) {
				System.out.printf(" ");
			}

			// end each line with vertical variable input and start new line
			System.out.printf("%c\n", verticalChar);
		}

		// return new value for verticalCounter
		return verticalCounter;
	}

	public static void drawBox() {
		// store variable to continue looping or not if given invalid answer
		boolean repeat = true;

		// create answer variable for looping
		char answer = 'y';

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		// Loop until user makes valid input 'n'
		do {
			// Ask user for info about the box they want to draw
			askBoxInfo();

			// Create the top horizontal line first
			// then pass return variable to draw vertical line
			drawVerticalLine(drawHorizontalLine());

			// finally draw the bottom horizontal line
			drawHorizontalLine();

			// Loop until user makes valid input
			do {
				try {
					// Prompt user if they want to continue
					System.out.print("\nContinue? Type 'y' for yes: ");

					// store user response to continue or not
					answer = getInput.next(".").charAt(0);

					// do not repeat if input is valid
					repeat = false;

				}
				// Catch any exceptions like InputMismatchException
				catch (InputMismatchException e) {
					// Tell the user they made an invalid choice and to try again
					System.out.printf("You have entered an invalid choice, please re-enter your choice: ");

					// repeat if input is invalid
					repeat = true;

					// Clear buffer
					getInput.nextLine();

				} catch (Exception e) {
					// Tell user that they made an invalid input
					System.out.printf("Invalid input. Please try again.");

					// repeat if input is invalid
					repeat = true;

					// Clear buffer
					getInput.nextLine();

				}
			} while (repeat);

		} while (Character.toLowerCase(answer) == 'y');

		// print goodbye message
		System.out.println("\n\nThank you for using my draw box program");
	}

}
