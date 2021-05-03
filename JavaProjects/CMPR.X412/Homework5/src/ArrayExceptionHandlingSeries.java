
/**
 * 
 */

/**
 * This is the solution for Homework #5
 * 
 * All solutions have been put in this class and are
 * handled through methods
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 04-22-2021
 *
 */

import java.util.Scanner;

public class ArrayExceptionHandlingSeries {

	// Homework 5.1
	/**
	 * @param no parameter
	 * 
	 *           Program will display menu of 5 items. It will ask user to give
	 *           their choice. It will trap all possible errors and then print the
	 *           result when correct input is provided before exiting the program.
	 * 
	 * @exception Exception e thrown
	 * @return no return value
	 **/
	public static void validateMenuOrder() {

		int choice = 0; // store user menu choice
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

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
			catch (Exception e) {
				// Tell the user they made an invalid choice and to try again
				System.out.printf("You have entered an invalid choice. Try again.\n");

				// Clear buffer
				getInput.nextLine();

			}
		} while (repeat);

		// Print the valid input
		System.out.printf("\nYou entered valid choice %d\nThank you for giving your choice\n\n", choice);

	} // end of getMenuOrder

	// Homework 5.2
	/**
	 * @param no parameter
	 * 
	 *           Program will prompt user to enter 2 floats. If values inputed are
	 *           correct, then display the inputed two values. If user enters
	 *           characters instead of numbers or if they enter invalid numbers then
	 *           the program will display the error message and ask the user to
	 *           re-enter correct values again. It only exits when the correct input
	 *           is received and displayed.
	 * 
	 * @exception Exception e thrown
	 * @return no return value
	 **/
	public static void validateTwoFloats() {
		float firstInput = 0, secondInput = 0; // store user float input
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		System.out.printf("Welcome to get two floats program\n\n");

		// Loop until user makes valid input
		do {
			try {
				// Prompt for user choice
				System.out.printf("Enter two floats separated by a space: ");

				// Store user input into float variables
				firstInput = getInput.nextFloat();
				secondInput = getInput.nextFloat();

				// do not repeat if input is valid
				repeat = false;

			}

			// Catch any exceptions like InputMismatchException
			catch (Exception e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered an invalid input. Try again.\n");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();
			}
		} while (repeat);

		// Print the valid input
		System.out.printf("\nYou entered two valid floats: %4.1f and %4.1f\nThank you for giving two floats\n\n",
				firstInput, secondInput);

	}// end of getTwoFloats

	// Homework 5.3
	/**
	 * @param no parameter
	 * 
	 *           Given a integer array of 7 temperatures of the week, user will
	 *           print the daily temperatures, minimum, maximum and average
	 *           temperatures
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void printForecast() {

		// Declare and initialize variables
		int weeklyTemp[] = { 69, 70, 71, 68, 66, 71, 70 };
		int i, max = 0, min = 0;
		float total = 0, average;

		// Loop through weeklyTemp array
		for (i = 0; i < weeklyTemp.length; i++) {
			// Print out the daily temperature
			System.out.printf("The temperature on day %d was %d:\n", i + 1, weeklyTemp[i]);

			// Compare each temperature to find max
			max = (weeklyTemp[i] > max) ? weeklyTemp[i] : max;

			// store day 1 first then compare to other temperatures to find min
			min = (i == 0) ? weeklyTemp[i] : (weeklyTemp[i] < min) ? weeklyTemp[i] : min;

			// Find total temperature for the week
			total += weeklyTemp[i];
		}

		// Calculate average
		average = total / weeklyTemp.length;

		// Print Minimum, Maximum, and average temperatures for the week
		System.out.printf("\nThe Minimum temperature is: %d\n", min);
		System.out.printf("The Maximum temperature is: %d\n", max);
		System.out.printf("The average temperature for the week is: %7.5f\n", average);
		System.out.printf("\nThank you for using my homework #5 solution");

	}

	/**
	 * Main
	 * 
	 * @param args : not used in this program
	 * 
	 *             For Homework #5.1 all important codes for this program is written
	 *             in the validateMenuOrder method.
	 *
	 *             For Homework #5.2 all important codes for this program is written
	 *             in the validateTwoFloats method.
	 * 
	 *             For Homework #5.3 all important codes for this program is written
	 *             in the printForecast method.
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 */
	public static void main(String[] args) {
		// Homework 5.1
		validateMenuOrder();

		// Homework 5.2
		validateTwoFloats();

		// Homework 5.3
		printForecast();
	}

}
