import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author AaronHo
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

				if (getInput.hasNextInt()) {
					choice = getInput.nextInt();
					if (choice > 5 || choice < 1) {
						// If user inputs a number higher than 5 or lower than 1, ask them to try again
						System.out
								.printf("You have not entered a number between 1 and 5, please re-enter your choice: ");

						// User will repeat and enter another input
						repeat = true;
					} else {
						// if input is within range, user will not repeat and exit loop
						repeat = false;
					}

				} else {
					charChoice = Character.toUpperCase(getInput.next().charAt(0));

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

					// if user input does not match any of the menu selections, throw error
					// exception
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
	}

	public float[] askTwoValues() {

		do {
//			switch (choice)
//			case 

			// Prompt for user input
			System.out.printf("Please enter two floats to add separated by a space: ");
			try {

				// Store user input into float variables
				for (int i = 0; i < floatInput.length; i++) {
					floatInput[i] = getInput.nextFloat();
				}

			}
			// Catch invalid inputs like characters or strings
			catch (InputMismatchException e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered invalid floats please re-enter: ");

				// Clear buffer
				getInput.nextLine();

				// Catch division errors like division by zero
			} catch (ArithmeticException ex) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You can't divide by zero please re-enter both floats: ");

				// Clear buffer
				getInput.nextLine();
			} catch (Exception e) {
				// Tell user that they made an invalid input
				System.out.printf("Invalid input. Please try again.");

				// Clear buffer
				getInput.nextLine();

			} finally {
				getInput.close();
			}
		} while (repeat);

		// Return user input
		return floatInput;
	}

	public void displayResults() {
	}

	public void displayBye() {
	}

	public String ToString() {
		String userChoice;

		switch (choice) {
		case 1:
			userChoice = "Addition";
			break;
		case 2:
			userChoice = "Subtraction";
			break;
		case 3:
			userChoice = "Multiplication";
			break;
		case 4:
			userChoice = "Division";
			break;
		default:
			userChoice = "None selected";
			break;
		}

		return "\nFloat 1: " + floatInput[0] + "\nFloat 2: " + floatInput[1] + "\nChoice: " + userChoice;

	}

}
