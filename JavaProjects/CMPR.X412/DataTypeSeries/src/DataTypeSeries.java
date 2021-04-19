/**
 * 
 */

/**
 * @author Aaron Ho
 * aaronho1
 * CMPR.X412.(827) Java Programming for Beginners
 * Homework 2 
 */

import java.util.Scanner;
public class DataTypeSeries {

	/**
	 * @param args
	 */
	// Here you write the complete code for exercise# 2_1
		public static void onePrintArea() {
			
			//use only one print statement instead of one print and one println statements to show the same output (“The area is: xxxx.xx”).
			int radius = 2;
			double area;
			final double pi = 3.142;
			area= pi * radius * radius;
			
			System.out.printf("The area is: " + area + "\n");
		}

		// Here you write the complete code for exercise# 2_2
		public static void userInputPi() {
			//...instead of hard-coding the value of PI in the program, get the value of PI from the user as well.
			
			int radius;
			double area;
			double pi;
						
			Scanner readInput = new Scanner(System.in);
			//extra line feed
			System.out.println();
			System.out.print("Enter the radius: ");
			radius = readInput.nextInt();

			System.out.print("Enter pi: ");
			pi = readInput.nextDouble();
			
			area= pi * radius * radius;
			System.out.print("The area is: ");
			System.out.println(area);

			
		}
		
		// Here you write the complete code for exercise# 2_3
		public static void radiusByte()
		{
			//extra line feed
			double area;
			final double pi = 3.142;
			Scanner readInput = new Scanner(System.in);
			System.out.println();
			System.out.print("Enter the radius: ");
			byte newRadius = readInput.nextByte();
			area= pi * newRadius * newRadius;
			System.out.print("The area is: ");
			System.out.println(area);
			//extra line feed
			System.out.println();
			System.out.print("What is your first name?: ");
			char yourInitial = readInput.next().charAt(0);
			System.out.println("Hello Mr. " + yourInitial + ".");
			//the input buffer will still have enter character '\n'
			// so that needs to be cleaned.
			//You can do that by using .nextLine() method.
			readInput.nextLine();
		}
		
		public static void userInputFormatSpecifiers() {
			Scanner readInput = new Scanner(System.in);
			//Declare four variables (decide on data type):First Name, Last Name, City, and Zip
			String firstName;
			String lastName;
			String city;
			int zip;
			
			System.out.println();
			System.out.printf("5185 is fun course.\n\n");
			System.out.printf("First Name \tLast Name\tCity\n");
			System.out.printf("-----------\t---------\t---\n");
			System.out.printf("Bill       \tClinton  \tHarlem\n");
			System.out.printf("\n");
		
			
			System.out.println();
			System.out.printf("How do you print double quotes?\n");
			System.out.printf("Who said\"Test Scores Can Be Used ....\"\n");
			System.out.println();

			//Ask user for the values for these variables and display them instead of using the hardcoded name like Bill Clinton Harlem
			System.out.print("Please enter your first name: ");
			firstName = readInput.next();
			System.out.print("Please enter your last name: ");
			lastName = readInput.next();
			System.out.print("Please enter your city: ");
			city = readInput.next();
			System.out.print("Please enter your zip code: ");
			zip = readInput.nextInt();
			System.out.println();

			//Add a column for zip code as well
			System.out.printf("First Name \tLast Name\tCity    \tZip Code\n");
			System.out.printf("-----------\t---------\t---     \t----\n");
			System.out.printf("%s         \t%s       \t%s     \t%d\n",firstName,lastName,city,zip);

		}

		
		////more exercises more methods
		
		public static void main(String[] args) {

			// now call these methods
			onePrintArea(); 
			userInputPi(); 
			radiusByte();
			userInputFormatSpecifiers();  
		}

}
