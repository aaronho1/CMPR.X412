
/**
 * 
 */

/**
 * This is the solution for Homework #6
 * 
 * All solutions have been put in this class and are
 * handled through methods
 * 
 * 
 * @author aaronho1
 * @version 2.0
 * @since 04-24-2021
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserChoiceTwoFloats {
	// Homework 6.1
	/**
	 * @param Scanner getInput
	 * 
	 *                Program will display menu of 5 items. It will ask user to give
	 *                their choice. It will trap all possible errors and then return
	 *                the result when correct input is provided before exiting the
	 *                program.
	 * 
	 * @exception InputMismatchException
	 * @return choice
	 **/
	public static int getUserChoice(Scanner getInput) {

		int choice = 0; // store user menu choice
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		System.out.printf("Welcome to sorting program\n\n");

		// Display menu items
		System.out.printf("\t1. Title\n");
		System.out.printf("\t2. Rank\n");
		System.out.printf("\t3. Date\n");
		System.out.printf("\t4. Stars\n");
		System.out.printf("\t5. Likes\n");

		System.out.printf("\n\n");

		// Loop until user makes valid input
		do {
			try {
				// Prompt for user choice
				System.out.printf("Enter your choice between 1 and 5 only: ");

				// Store user input into choice variable
				choice = getInput.nextInt();

				// If user inputs a number higher than 5 or lower than 1, ask them to try again
				if (choice > 5 || choice < 1) {
					System.out.printf("You have not entered a number between 1 and 5. Try again.\n");

					// User will repeat and enter another input
					repeat = true;
				} else {

					// if input is within range, user will not repeat and exit loop
					repeat = false;
				}

			}
			// Catch any exceptions like InputMismatchException
			catch (InputMismatchException e) {
				// Tell the user they made an invalid choice and to try again
				System.out.printf("You have entered an invalid choice. Try again.\n");

				// Clear buffer
				getInput.nextLine();

			}
		} while (repeat);

		// return user choice
		return choice;

	} // end of getUserChoice

	// Homework 6.2
	/**
	 * @param Scanner getInput, float[] floatInput
	 * 
	 *                Program will prompt user to enter 2 floats. If values inputed
	 *                are correct, then return the inputed two values. If user
	 *                enters characters instead of numbers or if they enter invalid
	 *                numbers then the program will display the error message and
	 *                ask the user to re-enter correct values again. It only exits
	 *                when the correct input is received and returned.
	 * 
	 * @exception InputMismatchException
	 * @return floatInput
	 **/
	public static float[] getTwoFloats(Scanner getInput, float[] floatInput) {
//			float[] floatInput; // store user float input
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// create scanner object for user input
//			Scanner getInput = new Scanner(System.in);

		System.out.printf("Welcome to bonus get two floats program\n\n");

		// Loop until user makes valid input
		do {
			try {
				// Prompt for user choice
				System.out.printf("Enter two floats separated by a space: ");

				// Store user input into float variables
				for (int i = 0; i < floatInput.length; i++) {
					floatInput[i] = getInput.nextFloat();
				}

				// do not repeat if input is valid
				repeat = false;

			}

			// Catch any exceptions like InputMismatchException
			catch (InputMismatchException e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered an invalid input. Try again.\n");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();
			}
		} while (repeat);

		// return the valid float inputs
		return floatInput;

	}// end of getTwoFloats

	/**
	 * Main
	 * 
	 * @param args : not used in this program
	 * 
	 *             Homework 6.3 calls both the methods from Homework 6.1 and 6.2
	 *             into it. The main method will call and print the return value
	 *             from the getUserChoice and getTwoFloats methods.
	 * 
	 *             For Homework 6.1, all important codes are written and returned
	 *             from the getUserChoice method.
	 * 
	 *             For Homework 6.2, all important codes are written and returned
	 *             from the getTwoFloats method.
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 */
	public static void main(String[] args) {
		float[] floatInput = new float[2]; // store user float input

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		// Homework 6.1
		System.out.printf("\nYou entered valid choice %d\nThank you for giving your choice\n\n\n",
				getUserChoice(getInput));

		// Homework 6.2
		floatInput = getTwoFloats(getInput, floatInput);
		System.out.printf("You entered %4.2f and %4.2f successfully!\n\n\tPress enter key to continue ...",
				floatInput[0], floatInput[1]);
	}

}
