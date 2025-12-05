/**
 * This program creates and runs a math trick with a random number. 
 *
 * @author Garrison Winters
 * @version 12-4-2025
 * 
 * This Math trick and many more can be found at: http://www.pleacher.com/handley/puzzles/mtricks.html
 *
 */

public class MathTrick {
	
	/**
	 * 
	 ******  DO NOT USE ARRAYS AT ALL,  AND DO NOT CONVERT NUMBERS TO STRING UNTIL STEP 7 ******
	 *
	 */
	
	// Step 1) Create a random 3-digit (100-999) number where the first and last digits differ by more than one
	// Hint: Use Math.random() to create number in the correct range
	// 		 Use modulus to find the last digit and divide by 100 for the first digit.
	//		 Calculate the difference; which method can you use so it doesn't matter how the numbers are subtracted?
	// 		 While the difference between the digits is less than 2, create a new random number and try again

	public static int getRandomNum() 
	{	int num = 0;
		int firstDigit = 0;
		int lastDigit = 0;

		// complete the method		
        while (Math.abs(lastDigit-firstDigit) < 2)
        {
            num = (int) (Math.random() * (900)) + 100;
            firstDigit = num / 100;
            lastDigit = num % 10;
        }

		return num;
	}

	// Steps 2 & 4) Reverse the digits of a number
	// Hint: to reverse a number without converting it to a String:
	//		Create a new variable to store the reversed number
	//		while the original number > 0.
	//		For each digit, multiply the new variable by 10 (to make room for the new digit). 
	//		Then, add the last digit (remember modulus?) to the new variable.
	//		Divide the original number by 10 to eliminate the last digit.
	//	        Ex: 584--> (0 x 10) + 4 = 4 ; 58--> (4 x 10) + 8 = 48; 5-->(48 x 10) + 5 = 485

	public static int reverseDigits (int num) {
	
		// complete the method
        int reversedNum = 0;
        
        while (num > 0)
        {
            reversedNum *= 10;
            reversedNum += (num % 10);
            num /= 10;
        }
        
        return reversedNum;    
	}
	
	// Step 7) Replace characters in a String according to the chart.
	// Hint: Loop through the String and "replace" the numbers with the corresponding letter.
	public static String replaceLtr(String str)
	{
	    String ret = "";
        String temp;

        for (int i = 0; i < str.length(); i++) {
            temp = str.substring(i, (i + 1));
            
            if (temp.equals("0")) {
                ret += "Y";
            } else if (temp.equals("1")) {
                ret += "M";
            } else if (temp.equals("2")) {
                ret += "P";
            } else if (temp.equals("3")) {
                ret += "L";
            } else if (temp.equals("4")) {
                ret += "R";
            } else if (temp.equals("5")) {
                ret += "O";
            } else if (temp.equals("6")) {
                ret += "F";
            } else if (temp.equals("7")) {
                ret += "A";
            } else if (temp.equals("8")) {
                ret += "I";
            } else {
                ret += "B";
            }
        }

        return ret;
    }
	
	// Step 8) Reverse the letters in a String
	// Hint: start with an empty String variable 
	//		 Loop through the original word.   
	//		 Add one letter at a time to the new variable using concatenation and .substring().
	public static String reverseString(String str) {
		String ret = "";

        for (int i = str.length()-1; i >= 0; i--)
        {
            ret += str.substring(i, (i + 1));
        }
        
        return ret;
	}
		
	public static void main(String[] args) 
	{
//		1.	Generate a random 3-digit number so that the first and third digits differ by more than one.
		int num1 = getRandomNum();
        System.out.println("1. The starting number: " + num1);
//		2.	Reverse the digits to form a second number.
        int num2 = reverseDigits(num1);
        System.out.println("2. The reversed number: " + num2);
//		3.	Subtract the smaller number from the larger one.
        int diff = Math.abs(num1 - num2);
        System.out.println("3. The difference is: " + diff);
//		4.	In the result you got in step 3, reverse the digits. Add it to that number.
        diff += reverseDigits(diff);
        System.out.println("4. The reversed number added to the difference: " + diff);
//		5.	Multiply by one million.
        diff *= 1000000;
        System.out.println("5. Number x one million: " + diff);
//		6.	Subtract 733,361,573.
        diff -= 733361573;
//		7.	Convert the number to a string to replace the numbers with letters.
// 				Ex: String str = String.valueOf(myNumber);
//			Then, replace each of the digits in your answer with the corresponding letter using the table in the instructions.
        String str = String.valueOf(diff);
        System.out.println("6. Number subtracted and converted to String: " + str);
        
        String changedStr = replaceLtr(str);
        System.out.println("7. Replaced string: " + changedStr);
//		8.	Reverse the letters in the string to read your message backward.
        String reversedStr = reverseString(changedStr);
        System.out.println("8. Reversed string: " + reversedStr);
	} // end main
} // end class
