
//Import exceptions and scanner classes
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author AaronHo
 * 
 * 
 *         This is the solution for Homework 8.
 * 
 *         All required solutions for 8.1 are stored in the getTemperatures,
 *         printTemperatures, and printStatistics methods. The printStatistics
 *         method calls the getMax, getMin and getAverage methods. All error
 *         handling is handled within the methods.
 * 
 * 
 *         All required solutions for 8.2 are handled in the drawBox method.
 *         This method will call the askBoxInfo ,drawHorizontalLine, and
 *         drawVerticalLine method.
 * 
 * @author aaronho1
 * @version 1.0
 * @since 05-05-2021
 *
 */

public class TemperatureBox {

	// Create class static variables about box and temperature
	private static int width;
	private static char verticalChar;
	private static int height;
	private static char horizontalChar;
	private static int[] weeklyTemp = new int[7];

	// getTemperatures method
	/**
	 * @param no input
	 * 
	 *           Program will prompt user to enter 7 temperatures. It will trap all
	 *           possible errors and then return the result when correct input is
	 *           provided before exiting the method.
	 * 
	 * @exception InputMismatchException e, Exception e
	 * @return no return value
	 */
	public static void getTemperatures() {
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		System.out.printf("Welcome to Aaron Ho's temperature program\n\n");

		// Prompt for user input
		System.out.printf("Please enter 7 temperatures separated by a space: ");

		// Loop until user makes valid input
		do {
			try {

				// Store user input into int array
				for (int i = 0; i < weeklyTemp.length; i++) {
					weeklyTemp[i] = getInput.nextInt();
				}

				// do not repeat if input is valid
				repeat = false;

			}

			// Catch any exceptions like InputMismatchException
			catch (InputMismatchException e) {
				// Tell the user they made an invalid input and to try again
				System.out.printf("You have entered invalid temperatures please re-enter: ");

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

	}// end of getTemperatures

	// printTemperatures method
	/**
	 * @param no input
	 * 
	 *           Program will print the temperatures with the according day. It will
	 *           return the result when correct input is calculated before exiting
	 *           the method.
	 * 
	 * @exception no exception
	 * @return no return value
	 */
	public static void printTemperatures() {

		// print temperatures
		for (int i = 0; i < weeklyTemp.length; i++) {
			System.out.printf("\nThe temperature on day %d " + "was %d: ", i + 1, weeklyTemp[i]);

		}

		// print two lines after making temperatures
		System.out.printf("\n\n");
	}// end of printTemperatures

	// getMax method
	/**
	 * @param no input
	 * 
	 *           Program will calculate the max of the given set of 7 temperatures.
	 *           It will return the result when correct input is calculated before
	 *           exiting the method.
	 * 
	 * @exception no exception
	 * @return return max variable value
	 */
	public static int getMax() {
		int max = 0;

		// Loop through weeklyTemp array
		for (int i = 0; i < weeklyTemp.length; i++) {

			// Compare each temperature to find max
			max = (weeklyTemp[i] > max) ? weeklyTemp[i] : max;
		}

		// return max variable
		return max;

	} // end of getMax

	// getMin method
	/**
	 * @param no input
	 * 
	 *           Program will calculate the min of the given set of 7 temperatures.
	 *           It will return the result when correct input is calculated before
	 *           exiting the method.
	 * 
	 * @exception no exception
	 * @return return min variable value
	 */
	public static int getMin() {

		int min = 0;

		// Loop through weeklyTemp array
		for (int i = 0; i < weeklyTemp.length; i++) {

			// store day 1 first then compare to other temperatures to find min
			min = (i == 0) ? weeklyTemp[i] : (weeklyTemp[i] < min) ? weeklyTemp[i] : min;

			// Find total temperature for the week
//		total += weeklyTemp[i];
		}

		return min;
	}// end of getMin

	// getAverage method
	/**
	 * @param no input
	 * 
	 *           Program will calculate the average of the given set of 7
	 *           temperatures. It will return the result when correct input is
	 *           calculated before exiting the method.
	 * 
	 * @exception no exception
	 * @return return average variable value
	 */
	public static int getAverage() {

		int average = 0, total = 0;

		// Loop through weeklyTemp array
		for (int i = 0; i < weeklyTemp.length; i++) {

			// Find total temperature for the week
			total += weeklyTemp[i];
		}

		// return average by dividing by the length
		return total / weeklyTemp.length;
	}// end of getAverage

	// printStatistics method
	/**
	 * @param no input
	 * 
	 *           Program will print the statistics of the calculations on the
	 *           temperature set. It will trap all possible errors and then return
	 *           the result when correct input is provided before exiting the
	 *           method.
	 * 
	 * @exception no exception
	 * @return no return
	 */
	public static void printStatistics() {

		// print min, max, average
		System.out.printf("The Minimum temperature is: %d\n", getMin());
		System.out.printf("The Maximum temperature is: %d\n", getMax());
		System.out.println("The average temperage for the week is: " + getAverage());

		System.out.printf("\n\n");
	}// end of printStatistics

	// askBoxInfo method
	/**
	 * @param no input
	 * 
	 *           This will ask the user on info about the box they want to draw. It
	 *           will exit the method when it is done asking for all the info about
	 *           the box
	 * 
	 * @exception InputMismatchException e, Exception e
	 * @return no return
	 */
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
	}// end of askBoxInfo

	// drawHorizontalLine method
	/**
	 * @param no input
	 * 
	 *           This will draw the horizontal line of the box. It will exit the
	 *           method when it is done printing the line.
	 * 
	 * @exception no exception
	 * @return verticalCounter variable
	 */
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

	}// end of drawHorizontalLine

	// drawVerticalLine method
	/**
	 * @param int verticalCounter
	 * 
	 *            This will draw the vertical line of the box. It will exit the
	 *            method when it is done printing the line.
	 * 
	 * @exception no exception
	 * @return no return
	 */
	public static void drawVerticalLine(int verticalCounter) {
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
	}// end of drawVerticalLine

	// drawBox method
	/**
	 * @param int verticalCounter
	 * 
	 *            This will draw the box. It will exit the method when it is done
	 *            printing the box and the user has not prompted to continue.
	 * 
	 * @exception InputMismatchException e, Exception e
	 * @return verticalCounter variable
	 */
	public static void drawBox() {
		// store variable to continue looping or not if given invalid answer
		boolean repeat = true;

		// create answer variable for looping
		char answer = 'y';

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

		System.out.printf("Welcome to Aaron Ho's box program\n\n");

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
	}// end of drawBox

	/**
	 * Main
	 * 
	 * @param args : not used in this program
	 * 
	 *             For Homework #8.1 all important codes for this program is written
	 *             in the getTemperatures,printTemperatures,printStatistics methods.
	 *
	 *             For Homework #8.2 all important codes for this program is written
	 *             in the drawBox method.
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 */
	public static void main(String[] args) {
		// Solution for 8.1
		getTemperatures();
		printTemperatures();
		printStatistics();

		// Solution for 8.2
		drawBox();
	}

}
