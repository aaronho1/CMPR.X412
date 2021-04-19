/**
 * 
 */

/**
 * @author AaronHo
 *
 */

public class Week3Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Compound operators +=
//		int N1, N2;
//		N1 = 10;N2 = 3;
//////		N1 = N1 + N2;
//////		N1+=N2; //add N2 to the old value of N1 and then assign it to N1 as new value
//////		N1-= N2;
//////		N1 /= N2;
//////		N1 *= N2;
////		N1 *= N2+5; // N1 = N1 * N2 + 5
////		N1 = N1 * (N2 + 5);
////		System.out.println(N1);
////		
////		N1 = N1 + N2; N1  += N2;
////		N1 = N1+1; N1+=N2; N1++; // all three are equivalent
//		
//		N1 = 9;
////		N1++;
//		System.out.println(N1++);
//		System.out.println(N1);
//
//		N1 = 9;
//		
////		++N1;
//		System.out.println(++N1);
//		System.out.println(N1);

//		int Num; loop = 8; count = 15; 
//		Num = +loop++; 
//		System.out.printf("Num = %d, loop = %d\n", Num, loop); 
//		Num = ++Num; 
//		System.out.printf("Num = %d, loop = %d\n", Num, loop); Num = count++ + loop; System.out.printf("Num = %d, loop = %d\n", Num, loop); Num = --count + --loop; System.out.printf("Num = %d, loop = %d\n", Num, loop); Num = loop + -Num; System.out.printf("Num = %d, loop = %d\n", Num, loop); 

//		int n1 = 3, n2 = 2, n3 = 2; 
//		if ((n1 * 5 * 3) - (4 * n2 * n3) - (14 * 2) >= 0) 
//			System.out.printf("It is true\n"); 
//		else 
//			System.out.printf("It is false\n"); 

		// given an age, determine if the person is a teenager
//		int age;
//		Scanner getInput = new Scanner (System.in);
//		age = getInput

		// inding a teenager
//		 age = 15; 
//		// get the age from user 
//		if (age >= 13) if (age <= 19)
//			System.out.printf("Your are a teenager\n"); 
//		// Can be Re-write: 
//		if (age > 12) if (age < 20) 
//			System.out.printf("Your are a teenager\n"); 
//		// or like this by combining with logical operator 
//		if (age > 12 && age < 20) 
//				System.out.printf("Your are a teenager\n"); 

//		int score;
//		Scanner getInput = new Scanner (System.in);
//		System.out.println("Enter you score: ");
//		
//		score = getInput.nextInt();
//		// nested if else (else if) is more efficent than all ifs
//		//all ifs will evaluate all lines
//		//else if will test the line ,if it fails, it will go down to the next line
//		//if a line has already been tested, it will move on to the next line
//		if (score >= 90)
//		{
//			System.out.println("You have a grade of A");
//		}
//		else if (score >= 90)
//		{
//			System.out.println("You have a grade of A");
//		}
//		else if (score >= 90)
//		{
//			System.out.println("You have a grade of A");
//		}
//		else if (score >= 90)
//		{
//			System.out.println("You have a grade of A");
//		}
//		else if (score >= 90)
//		{
//			System.out.println("You have a grade of A");
//		}

		// write a calculator program --shhhh! This is not all of your midterm I
//		float firstN; float secondN; char op; 
//		Scanner readInput = new Scanner(System.in); 
//		System.out .printf("Type a number, operator, number -- Separate by a space: "); 
//		firstN = readInput.nextInt(); 
//		op = readInput.next().charAt(0); 
//		secondN = readInput.nextInt(); 
//		if (op == '+') 
//			System.out.printf("%5.2f + %5.2f = %5.2f", firstN, secondN, firstN + secondN); 
//		else if (op == '-') 
//			System.out.printf("%5.2f - %5.2f = %5.2f", firstN, secondN,firstN - secondN); 
//		else if (op == '*') 
//				System.out.printf("%5.2f * %5.2f = %5.2f", firstN, secondN,firstN 
//		* secondN); 
//		else if (op == '/') 
//			System.out.printf("%5.2f / %5.2f = %5.2f", firstN, secondN,firstN / secondN); 
//		else if (op == '%') 
//			System.out.printf("%5.2f %% %5.2f = %d", firstN, secondN, (int) firstN % (int) secondN); 
//		else System.out.printf("Unknown operator"); 
//		
//		System.out.printf("\n\n");

		//
//		switch (op) {
//		case '+':
//			System.out.printf("%5.2f + %5.2f = %5.2f\n", firstN, secondN, firstN + secondN); 
//		break;
//		case '-':
//			System.out.printf("%5.2f - %5.2f = %5.2f\\n", firstN, secondN,firstN - secondN); break;
//		case '*':
//				System.out.printf("%5.2f * %5.2f = %5.2f\\n", firstN, secondN,firstN 
//		* secondN); break;
//		case '/':
//			System.out.printf("%5.2f / %5.2f = %5.2f\\n", firstN, secondN,firstN / secondN); break;
//		case '%':
//			System.out.printf("%5.2f %% %5.2f = %d\\n", firstN, secondN, (int) firstN % (int) secondN); break;
//		default: System.out.printf("Unknown operator"); 
//		}
//		System.out.printf("\n\n");

//		int age;
//		Scanner getInput = new Scanner (System.in);
//		age = getInput.nextInt();
//		switch (age)
//		{
//		case 13:
//		case 14:
//		case 15:
//		case 16:
//		case 17:
//		case 18:
//		case 19: System.out.printf("Your are a teenager\n"); 
//		default: System.out.printf("Your are not a teenager\n"); 
		// ternary/conditional operator ?:
//		int max, a = 10, b = 20; // get value for a and b from user 
//		if (a > b) { max = a; } 
//		else { max = b; } max = (a > b) ? a : b; 
//		
//		// what is the value of max? 
//		
//		max = (a > b)? a:b;

//		int a = 0;
//		while (a++<10)
//		{
//			System.out.println("Hello World");
//		}

		// start for ---------------
		int j = 0;
		while (j < 20) {
			System.out.printf("-");
			j++;
		}
		System.out.println();
		int k = 0;
		while (k < 8) {
			// then | |
			j = 0;
			System.out.printf("|");
			while (j < 18) {
				System.out.printf(" ");
				j++;
			}
			System.out.printf("|");
			System.out.println();
			k++;
		} // finally last ---------------
		j = 0;
		while (j < 20) {
			System.out.printf("-");
			j++;
		}
	}

}
