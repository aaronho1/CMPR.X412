package testproject;

//Import exception and scanner classes
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author AaronHo
 * 
 * 
 *         This is the solution for Homework 7
 * 
 *         All required methods and variables for the OOPCalculator program have
 *         been placed here. This class converts the solution from the Midterm
 *         assignment into a class based program using knowledge of objected
 *         oriented programming techniques. This class can then be instantiated
 *         into an object in main. To see how this class was implemented, please
 *         go to TestCalculator.java to see how this class was instantiated and
 *         how the methods were called.
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-02-2021
 *
 */

public class OOPCalculator {
	// create scanner object for user input
	private Scanner getInput = new Scanner(System.in);

	// store user int choice
	private int choice;

	// store user character choice
	private int charChoice;

	// store variable to continue looping or not if given invalid answer
	private boolean repeat = true;

	// store user float input
	private float[] floatInput = new float[2];

	// create string variable to hold action
	String action = new String();

	// askCalcChoice method
	/**
	 * @param no input
	 * 
	 *           Program will display calculator menu of 5 calculator functions. It
	 *           will ask user to give their choice. It will trap all possible
	 *           errors and then return the result when correct input is provided
	 *           before exiting the method.
	 * 
	 * @exception InputMismatchException e, Exception e
	 * @return int choice
	 **/
	public int askCalcChoice() {
		// store possible menu character selections for comparison later on
		final char[][] menuSelection = { { 'A', 'S', 'M', 'D', 'X' } };

		// reset user choice input
		choice = 0;

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

				// check if user has entered an integer
				if (getInput.hasNextInt()) {

					// assign choice variable to integer input
					choice = getInput.nextInt();

					// If user inputs a number higher than 5 or lower than 1, ask them to try again
					if (choice > 5 || choice < 1) {

						System.out
								.printf("You have not entered a number between 1 and 5, please re-enter your choice: ");

						// User will repeat and enter another input
						repeat = true;

						// reset user choice input
						choice = 0;
					} else {
						// if input is within range, user will not repeat and exit loop
						repeat = false;
					}

				} else {
					// store strictly one character into charChoice
					charChoice = Character.toUpperCase(getInput.next(".").charAt(0));

					// loop through menu selection array
					for (int i = 0; i < menuSelection[0].length; i++) {

						// if inputed character matches a character in the array, assign it to class
						// static variable
						if (charChoice == menuSelection[0][i]) {

							// assign to class variable
							choice = i + 1;

							// if input is matches a menu result, exit both loops
							repeat = false;

						}
					}

					// if user input does not match any of the menu selections,
					// throw error exception
					if (choice == 0) {
						// throw InputMisMatchException
						throw new InputMismatchException();
					}

				}

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

		// Formatting by adding two new lines
		System.out.printf("\n\n");

		// return user choice
		return choice;
	} // end of askCalcChoice

	// askTwoValues method
	/**
	 * @param no input
	 * 
	 *           Program will take the array of floats and assign the user input to
	 *           the array. Based on the user choice in the menu, it will ask for
	 *           the floats accordingly. It will trap all possible errors and will
	 *           exit the method when correct input is provided.
	 * 
	 * @exception InputMismatchException e, Exception e
	 * @return no return value
	 **/
	public void askTwoValues() {
		// assign user action to action variable for valid prompt
		switch (choice) {
		case 1:
			action = "add";
			break;
		case 2:
			action = "subtract";
			break;
		case 3:
			action = "multiply";
			break;
		case 4:
			action = "divide";
			break;
		}

		// Prompt for user input
		System.out.printf("Please enter two floats to " + action + " separated by a space: ");

		do {

			try {

				// Store user input into float variables
				for (int i = 0; i < floatInput.length; i++) {
					floatInput[i] = getInput.nextFloat();

					// throw divide by 0 exception if second integer inputed is 0 and user choice is
					// to divide
					if (choice == 4 && i == 1 && floatInput[i] == 0) {
						throw new ArithmeticException();
					} else {
						// do not repeat if input is valid
						repeat = false;
					}
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
			} catch (Exception e) {
				// Tell user that they made an invalid input
				System.out.printf("Invalid input. Please try again.");

				// repeat if input is invalid
				repeat = true;

				// Clear buffer
				getInput.nextLine();

			}
		} while (repeat);
	} // end of askTwoValues

	// displayResults method
	/**
	 * @param no input
	 * 
	 *           Program will take the array of floats and calculate the result
	 *           based on the user choice in the menu. It will trap all possible
	 *           errors and will exit the method after displaying output.
	 * 
	 * @exception Exception e
	 * @return no return value
	 **/
	public void displayResults() {
		// store the result of the calculation
		float calculatedResult = 0;

		try {

			// depending on user choice, calculate and display the result
			switch (choice) {
			case 1:
				// Calculate by adding floats together
				calculatedResult = floatInput[0] + floatInput[1];

				// Print the result
				System.out.printf("Result of adding %4.2f and %4.2f is %4.2f.\n\n", floatInput[0], floatInput[1],
						calculatedResult);
				break;
			case 2:

				// Calculate by subtracting first element from second
				calculatedResult = floatInput[0] - floatInput[1];

				// Print the result
				System.out.printf("Result of subtracting %4.2f from %4.2f is %4.2f.\n\n", floatInput[1], floatInput[0],
						calculatedResult);
				break;
			case 3:
				// Calculate by multiplying floats together
				calculatedResult = floatInput[0] * floatInput[1];

				// Print the result
				System.out.printf("Result of multiplying %4.2f and %4.2f is %4.2f.\n\n", floatInput[0], floatInput[1],
						calculatedResult);
				break;
			case 4:
				// Calculate by dividing first element from second
				calculatedResult = floatInput[0] / floatInput[1];

				// Print the result
				System.out.printf("Result of dividing %4.2f by %4.2f is %4.2f.\n\n", floatInput[0], floatInput[1],
						calculatedResult);
				break;
			}
		} catch (Exception e) {
			// Tell user that they were unable to make the computation
			System.out.printf("Unable to display results. Please try again ...");
		}
	} // end of displayResults

	// askToContinue method
	/**
	 * @param no input
	 * 
	 *           Program will prompt user to press enter key to continue. It will
	 *           trap all possible errors and upon valid input, will exit the method
	 *           and re-display the calculator menu
	 * 
	 * @exception NoSuchElementException e, Exception e
	 * @return no return value
	 **/
	public void askToContinue() {
		// boolean variable to control entry and exit form "enter to continue" loop
		boolean enterKeyRepeat = true;

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

			} catch (Exception e) {
				// Tell user that they were unable to make the computation
				System.out.printf("Unable to continue. Please try again ...");
			}
		}
	} // end of askToContinue

	// displayBye method
	/**
	 * @param no input
	 * 
	 *           This will print the goodbye message upon the user selecting 'X' or
	 *           5 in the calculator menu. The program will then end following this
	 *           method.
	 * 
	 * @exception no exception
	 * @return no return value
	 **/
	public void displayBye() {
		// Print the goodbye message
		System.out.printf("Thank you for using Aaron Ho's Handy Calculator");
	} // end of displayBye

	// ToString method
	/**
	 * @param no input
	 * 
	 *           This will explicitly define ToString so that if it is called, it
	 *           will return information about the object state
	 * 
	 * @exception no exception
	 * @return no return value
	 **/
	public String ToString() {

		// return current information about object members
		return "\nFloat 1: " + floatInput[0] + "\nFloat 2: " + floatInput[1] + "\nChoice: " + action;

	} // end of ToString

} // end of OOPCalculator
