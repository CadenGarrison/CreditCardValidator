import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CreditCardValidator
	{
		static ArrayList<Long> creditCardNumbers = new ArrayList<Long>();
		static Scanner userInput = new Scanner(System.in);
		static long[] digitArray = new long[16];
		static String[] wordDigitArray = new String[16];
		static int selection;
		static String wordNumber;
		
		public static void main(String[] args)
		{
			try 
				{
					textFile();
				}
			catch (IOException exc)
				{
					System.out.println("An I/O error occurred: " + exc.getMessage());
				}
			
			System.out.println("Welcome to the credit card verifier. Would you like to (1) Verify the existing numbers or (2) Verify your own number?");
			selection = userInput.nextInt();
			if (selection == 1)
				{
					System.out.println("You are verifying the existing numbers.");
					verifyExistingNumbers();
				}
			else if (selection ==2)
				{
					System.out.println("You are verifying you own number.");
					verifyPersonalNumber();
				}
		}
		
		public static void textFile() throws IOException
		{
			Scanner numberList = new Scanner(new File("CreditCardNumbers.txt"));
			
			while (numberList.hasNext())
				{
					String numberWord = numberList.nextLine();
					long number= Long.parseLong(numberWord);
					creditCardNumbers.add(number);
				}
		}
		
		public static void verifyExistingNumbers()
		{
			for (Long l: creditCardNumbers)
				{
					l.toString();
					
				}
		}
		
		public static void verifyPersonalNumber()
		{
			
		}
	}
