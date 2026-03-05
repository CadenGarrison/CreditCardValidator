import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CreditCardValidator
	{
		static ArrayList<Long> creditCardNumbers = new ArrayList<Long>();
		static Scanner userInput = new Scanner(System.in);
		static Scanner userLongInput = new Scanner(System.in);
		static long[] digitArray = new long[16];
		static String[] wordDigitArray = new String[16];
		static int selection;
		static String wordNumber;
		static long doubledDigit;
		static String smallWordNumber;
		static Long newDoubledDigit;
		static long replacementDigit;
		static long[] miniArray = new long[2];
		static String[] miniWordDigitArray;
		static long counter;
		static int failCounter;
		static int validCounter;
		//static boolean result;
		static long primitivePersonalNumber;
		static Long personalNumber;
		
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
					System.out.println(" ");
					verifyNumbers(creditCardNumbers);
				}
			else if (selection ==2)
				{
					System.out.println("What is your number?");
					primitivePersonalNumber = userLongInput.nextLong();
					personalNumber = primitivePersonalNumber;
					verifyPersonalNumber(personalNumber);
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
		
		public static void verifyNumbers(ArrayList<Long> nums)
		{
			for (Long l: nums)
				{
					counter = 0;
					wordNumber = l.toString();
					wordDigitArray = wordNumber.split("");
					for (int i=0; i<wordDigitArray.length; i++)
					{
						digitArray[i] = Long.parseLong(wordDigitArray[i]);
					}
					for (int k=0; k<digitArray.length; k+=2)
					{
						doubledDigit = digitArray[k]*2;
						if (doubledDigit >= 10)
						{
							newDoubledDigit = doubledDigit;
							smallWordNumber = newDoubledDigit.toString();
							miniWordDigitArray = smallWordNumber.split("");
							for (int a=0; a<miniWordDigitArray.length; a++)
							{
								miniArray[a] = Long.parseLong(miniWordDigitArray[a]);
							}
							replacementDigit = miniArray[0] + miniArray[1];
							digitArray[k] = replacementDigit;
						}
						else
						{
						digitArray[k] = doubledDigit;
						}
						
					}
					for (int j=0; j<digitArray.length; j++)
					{
					counter += digitArray[j];
					}
					if (counter%10 == 0)
					{
						validCounter++;
						System.out.println(wordNumber + " is a valid number.");
					}
					else if (counter%10 != 0)
					{
						failCounter++;
						System.out.println(wordNumber + " is NOT a valid number.");
					}
					
				}
			System.out.println(" ");
			System.out.println("There were " + validCounter + " valid numbers and " + failCounter + " invalid numbers.");
		}
		
		public static void verifyPersonalNumber(Long num)
		{
			
				wordNumber = num.toString();
				wordDigitArray = wordNumber.split("");
				for (int i=0; i<wordDigitArray.length; i++)
				{
					digitArray[i] = Long.parseLong(wordDigitArray[i]);
				}
				for (int k=0; k<digitArray.length; k+=2)
				{
					doubledDigit = digitArray[k]*2;
					if (doubledDigit >= 10)
					{
						newDoubledDigit = doubledDigit;
						smallWordNumber = newDoubledDigit.toString();
						miniWordDigitArray = smallWordNumber.split("");
						for (int a=0; a<miniWordDigitArray.length; a++)
						{
							miniArray[a] = Long.parseLong(miniWordDigitArray[a]);
						}
						replacementDigit = miniArray[0] + miniArray[1];
						digitArray[k] = replacementDigit;
					}
					else
					{
					digitArray[k] = doubledDigit;
					}
					
				}
			
				for (int j=0; j<digitArray.length; j++)
				{
				counter+= digitArray[j];
				}
				if (counter%10 == 0)
				{
					System.out.println(personalNumber + " is a valid credit card number.");
				}
				else if (counter%10 != 0)
				{
					System.out.println(personalNumber + " is NOT a valid credit card number.");
				}
				else
				{
					System.out.println(personalNumber + " is NOT a valid credit card number.");
				}
				
		}
	}
