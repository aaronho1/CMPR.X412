
//Import exception and scanner classes
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author AaronHo
 * 
 * 
 *         This is the solution for the Midterm Assignment
 * 
 *         All solutions have been put in this class and are handled through
 *         methods
 * 
 * @author aaronho1
 * @version 1.0
 * @since 04-26-2021
 *
 */
public class Calculator {

	// getUserChoice method
	/**
	 * @param Scanner getInput
	 * 
	 *                Program will display calculator menu of 5 calculator
	 *                functions. It will ask user to give their choice. It will trap
	 *                all possible errors and then return the result when correct
	 *                input is provided before exiting the method.
	 * 
	 * @exception InputMismatchException e thrown
	 * @return int choice
	 **/
	public static int getUserChoice(Scanner getInput) {

		int choice = 0; // store user choice
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		System.out.printf("Welcome to Aaron Ho's Handy Calculator\n\n");

		// Display menu items
		System.out.printf("\t1. Addition\n");
		System.out.printf("\t2. Subtraction\n");
		System.out.printf("\t3. Multiplication\n");
		System.out.printf("\t4. Division\n");
		System.out.printf("\t5. Exit\n");

		// Prompt for user choice
		System.out.printf("\n\nWhat would you like to do? ");

		// Loop until user makes valid input
		do {
			try {

				// Store user input into choice variable
				choice = getInput.nextInt();

				// If user inputs a number higher than 5 or lower than 1, ask them to try again
				if (choice > 5 || choice < 1) {
					System.out.printf("You have not entered a number between 1 and 5, please re-enter your choice: ");

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
				System.out.printf("You have entered an invalid choice, please re-enter your choice: ");

				// Clear buffer
				getInput.nextLine();

			}
		} while (repeat);

		// Formatting by adding two new lines
		System.out.printf("\n\n");

		// return user choice
		return choice;

	} // end of getUserChoice

	// doAddition method
	/**
	 * @param Scanner getInput, float[] floatInput
	 * 
	 *                Program will take the array of floats and assign the user
	 *                input to the array. The program will then add the values of
	 *                the array together to produce the result. It will trap all
	 *                possible errors and then return the added result when correct
	 *                input is provided before exiting the method.
	 * 
	 * @exception InputMismatchException e thrown if invalid input
	 * @return float result
	 **/
	public static float doAddition(Scanner getInput, float[] floatInput) {
		float result = 0; // store the result of the calculation
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// Prompt for user input
		System.out.printf("Please enter two floats to add separated by a space: ");

		// Loop until user makes valid input
		do {
			try {

				// Store user input into float variables
				for (int i = 0; i < floatInput.length; i++) {
					floatInput[i] = getInput.nextFloat();

					// Calculate addition by adding floats to the result
					result += floatInput[i];
				}

				// do not repeat if input is valid
				repeat = false;

			}

			// Catch any exceptions like InputMismatchException
			catch (InputMismatchException e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered invalid floats please re-enter: ");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();
			}
		} while (repeat);

		// Return calculated result
		return result;
	} // end of doAddition

	// doSubtraction method
	/**
	 * @param Scanner getInput, float[] floatInput
	 * 
	 *                Program will take the array of floats and assign the user
	 *                input to the array. The program will then subtract the values
	 *                of the array together in order of input to produce the result.
	 *                It will trap all possible errors and then return the
	 *                subtracted result when correct input is provided before
	 *                exiting the method.
	 * 
	 * @exception InputMismatchException e thrown if invalid input
	 * @return float result
	 **/
	public static float doSubtraction(Scanner getInput, float[] floatInput) {
		float result = 0; // store the result of the calculation
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// Prompt for user input
		System.out.printf("Please enter two floats to subtract separated by a space: ");

		// Loop until user makes valid input
		do {
			try {

				// Store user input into float variables
				for (int i = 0; i < floatInput.length; i++) {

					floatInput[i] = getInput.nextFloat();
				}

				// Calculate subtraction by subtracting first element from second
				result = floatInput[0] - floatInput[1];

				// do not repeat if input is valid
				repeat = false;

			}

			// Catch any exceptions like InputMismatchException
			catch (InputMismatchException e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered invalid floats please re-enter: ");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();
			}
		} while (repeat);

		// Return calculated result
		return result;
	} // end of doSubtraction

	// doMultiplication method
	/**
	 * @param Scanner getInput, float[] floatInput
	 * 
	 *                Program will take the array of floats and assign the user
	 *                input to the array. The program will then multiply the values
	 *                of the array together to produce the result. It will trap all
	 *                possible errors and then return the multiplied result when
	 *                correct input is provided before exiting the method.
	 * 
	 * @exception InputMismatchException e thrown if invalid input
	 * @return float result
	 **/
	public static float doMultiplication(Scanner getInput, float[] floatInput) {
		float result = 0; // store the result of the calculation
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// Prompt for user input
		System.out.printf("Please enter two floats to multiply separated by a space: ");

		// Loop until user makes valid input
		do {
			try {

				// Store user input into float variables
				for (int i = 0; i < floatInput.length; i++) {
					floatInput[i] = getInput.nextFloat();
				}

				// Calculate subtraction by subtracting first element from second
				result = floatInput[0] * floatInput[1];

				// do not repeat if input is valid
				repeat = false;

			}

			// Catch any exceptions like InputMismatchException
			catch (InputMismatchException e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered invalid floats please re-enter: ");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();
			}
		} while (repeat);

		// Return calculated result
		return result;
	} // end of doMultiplication

	// doDivision method
	/**
	 * @param Scanner getInput, float[] floatInput
	 * 
	 *                Program will take the array of floats and assign the user
	 *                input to the array. The program will then divide the values of
	 *                the array together in order of input to produce the result. It
	 *                will trap all possible errors and then return the divided
	 *                result when correct input is provided before exiting the
	 *                method.
	 * 
	 * @exception InputMismatchException e thrown if invalid input
	 * @return float result
	 **/
	public static float doDivision(Scanner getInput, float[] floatInput) {
		float result = 0; // store the result of the calculation
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// Prompt for user input
		System.out.printf("Please enter two floats to divide separated by a space: ");

		// Loop until user makes valid input
		do {
			try {

				// Store user input into float variables
				for (int i = 0; i < floatInput.length; i++) {
					floatInput[i] = getInput.nextFloat();
				}

				// test to see if user makes divisible by 0 error
				if (floatInput[1] == 0) {

					// if user attempts to divide by 0, throw ArithmeticException
					throw new ArithmeticException();

				} else {

					// Calculate subtraction by subtracting first element from second
					result = floatInput[0] / floatInput[1];

					// do not repeat if input is valid
					repeat = false;
				}

			}

			// Catch invalid inputs like characters or strings
			catch (InputMismatchException e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered invalid floats please re-enter: ");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();

				// Catch division errors like division by zero
			} catch (ArithmeticException ex) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You can't divide by zero please re-enter both floats: ");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();
			}
		} while (repeat);

		// Return calculated result
		return result;
	} // end of doDivision

	// Main method
	/**
	 * @param args not used
	 * 
	 *             Variables created in the main are passed to static methods to
	 *             handle logic in a modular manner. The getUserChoice method will
	 *             return what the user wants to do and their valid input will
	 *             prompt the switch statement to calculate according to their
	 *             choice. The program will print the result from their valid inputs
	 *             and then prompt to press enter to continue. The program will
	 *             repeat until the user decides to input 5 to exit the program.
	 * 
	 * @exception IOException e thrown, all other exception handling is handled in
	 *                        other methods
	 * @return no return value
	 * 
	 */
	public static void main(String[] args) {
		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		// store user float input
		float[] floatInput = new float[2];

		// Store the calculated result of the user's inputs
		float calculatedResult;

		// boolean variable to control how often to display calculator menu until user
		// decides to exit
		boolean repeat = true;

		// boolean variable to control entry and exit form "enter to continue" loop
		boolean enterKeyRepeat = true;

		do {

			// Perform the action based on the user choice in the menu prompt
			switch (getUserChoice(getInput)) {

			case 1:
				// Store the result of doAddition method into calculatedResult variable
				calculatedResult = doAddition(getInput, floatInput);

				// Print the result
				System.out.printf("Result of adding %4.2f and %4.2f is %4.2f.\n\n", floatInput[0], floatInput[1],
						calculatedResult);

				// Repeat menu prompt again after valid input
				repeat = true;

				// Set enterRepeat to true to run loop for enter to continue
				enterKeyRepeat = true;
				break;
			case 2:
				// Store the result of doSubtraction method into calculatedResult variable
				calculatedResult = doSubtraction(getInput, floatInput);

				// Print the result
				System.out.printf("Result of subtracting %4.2f from %4.2f is %4.2f.\n\n", floatInput[0], floatInput[1],
						calculatedResult);

				// Repeat menu prompt again after valid input
				repeat = true;

				// Set enterRepeat to true to run loop for enter to continue
				enterKeyRepeat = true;
				break;
			case 3:
				// Store the result of doMultiplication method into calculatedResult variable
				calculatedResult = doMultiplication(getInput, floatInput);

				// Print the result
				System.out.printf("Result of multiplying %4.2f and %4.2f is %4.2f.\n\n", floatInput[0], floatInput[1],
						calculatedResult);

				// Repeat menu prompt again after valid input
				repeat = true;

				// Set enterRepeat to true to run loop for enter to continue
				enterKeyRepeat = true;
				break;
			case 4:
				// Store the result of doDivision method into calculatedResult variable
				calculatedResult = doDivision(getInput, floatInput);

				// Print the result
				System.out.printf("Result of dividing %4.2f by %4.2f is %4.2f.\n\n", floatInput[0], floatInput[1],
						calculatedResult);

				// Repeat menu prompt again after valid input
				repeat = true;

				// Set enterRepeat to true to run loop for enter to continue
				enterKeyRepeat = true;
				break;
			case 5:

				// Print the result
				System.out.printf("Thank you for using Aaron Ho's Handy Calculator");

				// Do not Repeat menu prompt again input, to exit program
				repeat = false;

				// Set to false to not prompt to press enter to continue
				enterKeyRepeat = false;
				break;
			}

			// Loop "press enter to continue" until user makes valid input
			while (enterKeyRepeat) {

				try {
					// Clear buffer
					getInput.nextLine();

					// Prompt user to press enter to continue
					System.out.printf("\nPress enter key to continue ....\n\n");

					// prompt user to press enter to continue
					getInput.nextLine();

					// Exit loop when valid input is made
					enterKeyRepeat = false;
				}
				// catch NoSuchElementException if line is not found
				catch (NoSuchElementException e) {

					// Tell user that they made an invalid input
					System.out.printf("Invalid input. Please try again.");

					// Continue loop when invalid input is made
					enterKeyRepeat = true;

				}
			}

			// Repeat the program until the user decides to exit
		} while (repeat);
	}// end of Main

}
