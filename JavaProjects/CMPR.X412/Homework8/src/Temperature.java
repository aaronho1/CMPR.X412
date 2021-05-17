import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author AaronHo
 *
 */
public class Temperature {
	private static int[] weeklyTemp = new int[7];

	public static void getTemperatures() {
		boolean repeat = true; // store variable to continue looping or not if given invalid answer

		// create scanner object for user input
		Scanner getInput = new Scanner(System.in);

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

	}

	public static void printTemperatures() {

		// print temperatures
		for (int i = 0; i < weeklyTemp.length; i++) {
			System.out.printf("\nThe temperature on day %d " + "was %d: ", i + 1, weeklyTemp[i]);

		}

		System.out.printf("\n\n");
	}

	public static int getMax() {
		int max = 0;

		// Loop through weeklyTemp array
		for (int i = 0; i < weeklyTemp.length; i++) {

			// Compare each temperature to find max
			max = (weeklyTemp[i] > max) ? weeklyTemp[i] : max;
		}

		// return max variable
		return max;

	}

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
	}

	public static int getAverage() {

		int average = 0, total = 0;

		// Loop through weeklyTemp array
		for (int i = 0; i < weeklyTemp.length; i++) {

			// Find total temperature for the week
			total += weeklyTemp[i];
		}

		// return average by dividing by the length
		return total / weeklyTemp.length;
	}

	public static void printStatistics() {

		// print min, max, average
		System.out.printf("The Minimum temperature is: %d\n", getMin());
		System.out.printf("The Maximum temperature is: %d\n", getMax());
		System.out.println("The average temperage for the week is: " + getAverage());
	}
}
