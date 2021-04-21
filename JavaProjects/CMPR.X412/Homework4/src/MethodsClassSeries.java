/**
 * 
 */

/**
 * This is the solution for Homework #4
 * 
 * All solutions have been put in one place as multiple classes are currently
 * not necessarily right now and can be handled through methods
 * 
 * 
 * @author aaronho1
 * @version 1.0
 * @since 04-19-2021
 *
 */
public class MethodsClassSeries {

	// Homework 4.1
	/**
	 * @param no parameter
	 * 
	 *           A loop is given and and currently asked to determine how many times
	 *           a certain phrase will be printed based on the order of he increment
	 *           operators
	 * 
	 * @exception no exception thrown
	 * @return no return value
	 **/
	public static void countLoop() {
		// 4.1.a
		int i = 0;
		while (i++ < 10) {
			System.out.println("Hello World: " + i);
		}
		// This loop has the counter increment set to i++
		// This post increment operator will execute this loop
		// 10 times

		// 4.1.b
		i = 0;
		while (++i < 10) {
			System.out.println("Hello World: " + i);
		}
		// This loop has a counter increment set to ++i
		// This loop will be executed for a total of
		// 9 times

		// 4.1.c
		while (++i < 10) {
			System.out.println("Hello World: " + i);
		}
		// This loop will be executed after 4.1.b
		// i is not reinitialized
		// This loop will be executed 0 times

	}

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

	public static void printWhileLoopBox() {

		int h = 0; // Declare and initialize horizontal counter variable to 0
		int v = 0; // Declare and initialize vertical counter variable to 0

		System.out.println("Using while loop: ");

		while (v < 10) // Loop and increment vertical counter variable 10 times
		{
			while (h++ < 20 && v == 0) // Loop and increment horizontal counter variable 20 times
			{
				System.out.printf("-");

			}
			System.out.printf("\n");

			v++; // increment vertical counter variable to begin new line

			while (v < 9) // Loop through vertical counter variable 9 times to print middle lines
			{
				h = 0; // reset horizontal counter variable to 0
				System.out.printf("|");

				while (h < 18) // Loop and increment horizontal counter variable 18 times to fill out middle
								// lines with blank space
				{
					System.out.printf(" ");
					h++;
				}

				System.out.printf("|");

				v++; // increment vertical counter variable to begin new line
				System.out.printf("\n");
			}

			h = 0;// reset horizontal counter variable to 0

			while (h++ < 20 && v == 9) // Loop and increment horizontal counter variable 20 times
			{
				System.out.printf("-");
			}
		}

	} // end of printWhileLoopBox

	public static void main(String[] args) {
		// Homework 4.1
//		countLoop();

		// Homework 4.2
		printBox();
		printWhileLoopBox();
	}

}
