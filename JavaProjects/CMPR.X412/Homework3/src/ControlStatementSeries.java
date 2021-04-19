/**
 * 
 */

/**
 * @author AaronHo
 *aaronho1
 *Homework 3
 */

// import scanner utility package to be used
import java.util.Scanner;

public class ControlStatementSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Homework 3.1
		getUserAge();

		// Homework 3.2
		calculateInput();

		// Homework 3.3
		findMax();
	}

	public static void getUserAge() {
		/**
		 * Homework 3.1 Modify the program, so that it will print: a) “You are a kid” if
		 * the age is less than 13 b) “You are a teenager” if the age is between 13 and
		 * 19 c) “You are an adult” if greater than 19
		 */

		// initialize variables
		int yourAge; // create an integer variable to store the age

		// create readInput object to get user input
		Scanner readInput = new Scanner(System.in);

		// ask user for their age
		System.out.printf("How old are you?: ");

		// store the age into yourAge variable
		yourAge = readInput.nextInt();

		// print “You are an adult” if age is greater than 19
		if (yourAge > 19) {
			System.out.printf("You are an adult\n\n");
		}
		// print “You are a teenager” if the age is between 13 and 19
		else if (yourAge >= 13) {
			System.out.printf("You are a teenager\n\n");
		}
		// print “You are a kid” if the age is less than 13
		else if (yourAge < 13) {
			System.out.printf("You are a kid\n\n");
		}
	}

	public static void calculateInput() {
		/**
		 * Homework 3.2 Modify the above program, so that it will: a) Accept decimal
		 * numbers from the user instead of integers. b) Once the output is displayed,
		 * ask the user if they want to continue, if they say yes, then repeat the
		 * process
		 */

		// initialize variables
		// Modify to accept decimal numbers intead of integer
		double firstN; // to store the first number
		double secondN; // to store the second number
		char operator; // to store the operator
		char repeat; // to store Y/N user input to continue

		// create readInput object to get user input
		Scanner readInput = new Scanner(System.in);

		do {
			// print instructions for user to input first number, operator and second number
			System.out.printf("Type a number, operator, number --" + "separated by a space: ");

			// store the user input for first number
			firstN = readInput.nextDouble();

			operator = readInput.next().charAt(0);

			// store the user input for second number
			secondN = readInput.nextDouble();

			if (operator == '+') // print the addition of two numbers
			{
				System.out.printf("%f + %f = %f", firstN, secondN, firstN + secondN);
			} else if (operator == '-') // print subtraction of two numbers
			{
				System.out.printf("%f - %f = %f", firstN, secondN, firstN - secondN);
			} else if (operator == '*') // print multiplcation of two numbers
			{
				System.out.printf("%f * %f = %f", firstN, secondN, firstN * secondN);
			} else if (operator == '/') // print division of two numbers
			{
				System.out.printf("%f / %f = %f", firstN, secondN, firstN / secondN);
			} else if (operator == '%') // print remainder of two numbers
			{
				System.out.printf("%f %% %f = %f", firstN, secondN, firstN % secondN);
			} else // otherwise print "Unknown operator"
			{
				System.out.printf("Unknown operator");
			}

			System.out.printf("\n\n");

			// Prompt user if they want to continue
			System.out.printf("Do you want to continue (Y/N)? ");

			// store user response to continue or not
			repeat = readInput.next().charAt(0);

			System.out.printf("\n");

		} while (Character.toUpperCase(repeat) == 'Y'); // added toUpperCase to handle lowercase input

	}

	public static void findMax() {
		/**
		 * Homework 3.3 Re-write the above ternary operator code to find the max of
		 * three numbers, for example, a, b, and c. Bonus, declare a, b, and c as
		 * integer variable and ask the users to enter these three values instead of
		 * hard coding them. Also, ask the user to continue if they like to find max of
		 * another set of integers.
		 */

		int max, a, b, c; // get value for a and b from user
		char repeat;

		// create readInput object to get user input
		Scanner readInput = new Scanner(System.in);

		do {
			System.out.printf("Enter three integer numbers to find max of them--separated by a space:\n");
			a = readInput.nextInt();
			b = readInput.nextInt();
			c = readInput.nextInt();

			// using ternary operator
			max = (a > b && a > c) ? a : (c > a && c > b) ? c : b; // what is the value of max?
			System.out.printf("The Max is: %d", max);

			System.out.printf("\n\n");

			// Prompt user if they want to continue
			System.out.printf("Continue? Type 'y' for yes: ");

			// store user response to continue or not
			repeat = readInput.next().charAt(0);

		} while (Character.toLowerCase(repeat) == 'y');

		System.out.printf("Thank you for using my max program\n\nPress any key to continue . . .");
	}
}
