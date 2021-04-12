import java.util.Scanner;

public class Week2Demos {
//commandline
//java helloworld 50 60
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int radius = 2;
//		double area;
//		final double pi = 3.142;
//		area = pi * radius * radius;
//		System.out.print("The area is: ");
//		System.out.println(area);

//		int radius;
//		double area;
//		final double pi = 3.142;
//		Scanner readInput = new Scanner(System.in);
//		System.out.print("Enter the radius: ");
//		radius = readInput.nextInt();
//		area = pi * radius * radius;
//		System.out.print("The area is: ");
//		System.out.println(area);

//		byte radius;
//		double area;
//		final double pi = 3.142;
//		byte myChar = 'A';
//		Scanner readInput = new Scanner(System.in);
//		System.out.print("Enter the radius: ");
//		radius = readInput.nextByte();
//		area = pi * radius * radius;
//		System.out.print("The area is: ");
//		System.out.println(area);
//		System.out.print("The character value is: ");
//		System.out.print(myChar);
//		System.out.println("The character value is: " + myChar);

//		System.out.printf("5185 is fun course");
//		System.out.printf("\rHello Student");
//		System.out.printf("\nHello World\n");
//		System.out.printf("\n");
//		System.out.printf("First Name \tLast Name\tCity\n");
//		System.out.printf("----------- \t---------\t---\n");
//		System.out.printf("Bill        \tClinton  \tHarlem\n");
//		System.out.printf("\n\n");
//		System.out.printf("Who said\"Test Scores Can Be Used ....\"\n");

//		byte myChar = 'A';
//		byte myNumber = 65;
//		String myString = "Hello how are you";
//		System.out.printf("The myChar with %%c is     : %c \n", myChar);
//		System.out.printf("The myChar with %%d is     : %d \n", myChar);
//		System.out.printf("The myNumber with %%d is   : %d \n", myNumber);
//		System.out.printf("The myNumber with %%c is   : %c \n", myNumber);
//		System.out.printf("myChar with %%c is: %c, myNumber with %%d is: %d\n", myChar, myNumber);
//		System.out.printf("myChar with %%d is: %d, myNumber with %%c is: %c\n", myChar, myNumber);
//		System.out.printf("%s\n", myString);

		short numberOfStudents = 11; //default store as integer
		int presidentsSalaray = 400000;
		long numberOfStars = 100000;
		Scanner readInput = new Scanner(System.in);
		System.out.printf("Number of starts in our Milkyway: %d\n\n", numberOfStars);
		numberOfStars = 1000000000000L; // without L is error force it to be Long. long value in long place
		System.out.printf("Number of starts in our Universe: %d\n",
		numberOfStars);System.out.printf("Please enter number of students and presidents salary\n", numberOfStars);numberOfStudents =
		 readInput.nextShort();presidentsSalaray=readInput.nextInt();System.out.printf("Number of students: " + numberOfStudents);
		 System.out.printf("President's Salary + Bonus: " + presidentsSalaray * 1.25);

//		int yourAge;
//		
//		System.out.print("Please enter your age: ");
//		Scanner readInput = new Scanner(System.in);
//		yourAge = readInput.nextInt();
//		
//		if (yourAge < 13) {
//			System.out.printf("You are a kid\n");
//		}
//		else if (yourAge > 19)
//		{
//			System.out.printf("You are an adult\n");
//		}
//		else
//		{
//			System.out.println("You are a teenager");
//		}
	}

}
