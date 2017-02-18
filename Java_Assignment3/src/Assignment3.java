/*score: 9 + 1(extra credit)
comments: good job! Keep going!
*/
import java.util.Arrays;

/**
 * Created by Rose on 1/27/17.
 * Assignment for your lecture 3. Please finish all the questions under
 * 'Assignment'. Please try to think the extra credit questions. The deadline
 * of this assignment is 02/04/2017 23:59 PST. Please feel free to contact me
 * for any questions. Please write your comments about this assignment in the
 * end.
 */


public class Assignment3 {
	/**
	 *  Given an array, reverse the elements within this array and print the result
	 *  eg, given{1,2,3,4}, print{4,3,2,1}
	 */
	public void reverseArray(int[] nums) {                        //correct

		if(nums==null || nums.length==0){
			System.out.println("The string is empty");
		}
		else if(nums.length!=0){
			int len =nums.length; //finding the length of the array
			int[] temp = new int[len]; //initializing an array to store the reversed values
			for( int j =0;j<len;j++){  //starting a loop to reverse the array
				temp[j] = nums[len-1-j]; //in the first iteration:temp[0] will hold the value of temp[3] (j = 0 & len-1-j = 4-1-0 = 3) 				   	
			}     	
			System.out.println("The array after reversing is " +Arrays.toString(temp));
		}
	}


	/**
	 *  Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
	 *  Assume the integer do not contain any leading zero, except the number 0 itself.
	 *  The digits are stored such that the most significant digit is at the head of the array.
	 *  eg, given {1,2,9}, reutrn{1,3,0}.
	 */
	public int[] plusOne(int[] digits) {           //wrong: try the input of {6}, {9,9}...and see the result

		if(digits==null || digits.length==0){ //Checking if the array is null
			System.out.println("The array is empty"); 
			return new int[0];
		}
		else if(digits!=null){
			char[] arrayOutput = new char[digits.length]; //Create an array to store the final output
			StringBuilder str = new StringBuilder(); //Create a string builder to append the values in the array
			for(int num : digits){ //Loop through the digits array
				str.append(num); //Start appending each value in the digits array
			}
			int output = Integer.parseInt(str.toString()); //convert the string builder to a string and then convert it to an integer
			if(output>=0){ //Confirming that the number is positive
				int finalOutput = output+1; //Once converted to an integer, 1 can be added to it
				arrayOutput = String.valueOf(finalOutput).toCharArray(); //Convert the integer to a string and pass it to a character array
				System.out.print("The array output after addition is ");
				System.out.println(Arrays.toString(arrayOutput)); //Print the array output
			}
			else
			{
				System.out.println("The number is a negative number"); //If the number is negative, print this
			}
		}	
		return digits;			
	}

	/**
	 *  Write a program that takes an integer as input and returns all the primes between 1 and that integer(inclusive).
	 *  eg, input is 18, you should return{2,3,5,7,11,13,17}    */
	public int[] generatePrimes(int n) {                     //correct, but for the last line"return null", you should return new int[0]

		//Tried to attempt this question even though you had mentioned in the email that its okay to skip this question
		if(n==0 ||n==1){
			System.out.println("The numbers 0 and 1 are not prime");
		}
		else if(n>=2) {
			System.out.print("{"); 
			for(int i=2;i<=n;i++){					
				if(isPrime(i)){	//Call to a method-isPrime to check if the number is prime or not
					if(i==n){
						System.out.print(+i +"}"); //if it is the last digit, print the number and the closing bracket
						System.out.println();
					} else	
						System.out.print(+i +","); //else print the number and comma
					continue;		
				}		
				else
					if(i==n){
						System.out.print("}"); //if it is the last digit, print the number and the closing bracket
						System.out.println();
					}
					else
						continue; //if not prime continue with the next number till the number itself
			}
		}
		return null;	
	}

	public static boolean isPrime(int n) { //method to check if a number is prime or not
		boolean isPrime = true;	//set default condition to true
		for(int i =2;i<n;i++){					 
			if(n % i ==0){ //check if the reminder is zero or not
				isPrime = false; //if zero, it is not a prime number
				break;
			}
			else
				continue; //else, continue to check the number with i++
		}
		return isPrime;							
	}

	/**
	 *  Assume you have a method isSubstring which checks if one word is a substring of another.
	 *  Given two strings, s1 and s2, write a program to check if s2 is a rotation of s1, using only one call
	 *  to isSubstring
	 *  eg, "pineapple" is a rotation of "neapplepi"
	 */
	public boolean isRotation(String s1, String s2) {         //correct
		if(s1.length() !=s2.length()){ //If the 2 strings are not equal, there is no need to check rotation
			System.out.println("The 2 strings are of different lengths");
			return false;
		}
		else {
			String comboString = s1 + s1; //combine the original strings Eg:pine to pinepine.This helps to check if there is a rotation
			if(isSubstring(comboString,s2)==true){ //check if rotation method return true
				System.out.println("The string " +s2 +" is a rotation of " +s1);
				return true;
			}
			else {
				System.out.println("The string " +s2 +" is not a rotation of " +s1);	
				return false;
			}	
		}
	}

	public static boolean isSubstring(String s1,String s2) {
		if(s2==null ||s2.length()==0) return true;
		if(s1==null ||s1.length()==0) return false;
		if(s1.contains(s2)){ //check if the string s1 i.e. combostring contains s2, if so, return true
			return true;
		}
		return false;

	}

	/**
	 *  Given two strings, write a method to decide if one is a permutation of the other
	 *  hint: the comparison is case sensitive and whitespace is significant
	 */
	public boolean isPermutation(String s1, String s2) {            //correct

		char[] a1 = s1.toCharArray(); //Create an array to store the first string
		char[] a2 = s2.toCharArray(); //Create an array to store the second string
		
		if(s1.length()==0 && s2.length()==0){
			System.out.println("The strings are empty");
		}
		else if(s1.length()!=0 && s2.length()!=0){
		if(s1.length()!=s2.length()){ //If the string lengths are not equal, no need to proceed
			System.out.println("The length of the 2 strings are not equal");
			return false;
		}
		else{
			Arrays.sort(a1); //Sort the first array
			Arrays.sort(a2); //Sort the second string in the array
		}
		if(Arrays.equals(a1, a2)){ //If the 2 sorted arrays have the same characters, then print
			System.out.println("The 2 strings are a permutation of the other");
			return true;
		}
		else 
			System.out.println("The 2 strings are not permutation of each other");
		}
		return false;  		
	}

	/**
	 *  Write a program to implement encoding and decoding string. The rule is simple: encode successive
	 *  repeated characters by the repetition count and the character. For example, the input of encoding()
	 *  is "aaaabcccaa", you should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee". Assume
	 *  the string to be encoded consists of letters of the alphabet, with no digits, and the string to be
	 *  decoded is a valid encoding.
	 */
	public String encoding(String s) {               //correct

		StringBuilder str = new StringBuilder(); //Create a string builder to append the count with the character	
		int count=0; //Set counter to zero
		char prev = s.charAt(0); //Set prev to the character at 0
		char curr; //Declare the current variable

		for(int i=0;i<s.length();i++){ //loop through the array
			if(Character.isLetter(s.charAt(i))){ //confirming that the string to be encoded consists of alphabets alone
				curr = s.charAt(i);	//Assign the current character to the i th value
				if(curr==prev){	//Check if the current character is equal to the previous, the same in the first case
					count += 1; //Increment the counter to 1, if it is equal		
					if(i==s.length()-1){ //Meanwhile, also check if it is the end of the string
						System.out.println("The encoded string is " +str.append(count).append(curr));	//If so, print the count and the curr character
					}
					continue;
				}
				else {
					str.append(count).append(prev);	//If curr !=prev, append count and prev
					prev = curr; //Set the prev value to curr value
					count=1; //Set the counter back to 1, so that it starts counting again for a new character
					if(i==s.length()-1){ //if while checking, we find that it is the end of the string
						System.out.println("The encoded string is " +str.append(count).append(curr)); //print the count and curr value
					}
				}		
			}
			else 
				System.out.println("The string to be decoded contains digits");
		}
		return s;
	}

	public String decoding(String s) {
		int count = 0;
		StringBuilder str = new StringBuilder();
		for(int i=0;i<s.length();i++){ //Loop through the string of characters
			char c = s.charAt(i);
			if(Character.isDigit(c)){ //Loop to find out the digit
				count = count *10 +c - '0';
			}
			else 
				while(count>0){ //Keep appending the alphabet till the count value
					str.append(c);
					count--;

				}
		}
		System.out.println("The decoded string is "+str.toString());
		return str.toString();		
	}



	//Extra Credit
	/**
	 *Given an m x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
	 * For exmaple, given 1 2 3  , return 7 4 1
	 *                    4 5,6           8 5 2
	 *                    7,8,9           9 6 3
	 *tip: image could be a square or a rectangle.
	 */
	public static void rotate(int[][] matrix) {          //correct

		int r = matrix.length; //Find the number of rows
		int c = matrix[0].length; //Find the number of columns
		int[][] output = new int[c][r]; //create an array with rows and columns interchanged

		for(int i =0;i<c;i++) //Loop through to populate in the new array matrix with 1st row becoming 1st column etc
			for(int j=0;j<r;j++){
				output[i][j]=matrix[j][i];	
			}

		int n = r; //Let the number of rows in the new matrix be n
		for(int j=0;j<n/2;j++){  //It is till n/2 because if it is a 3x4 matrix,it becomes 4x3 and we need to loop only till <4/2 columns
			for(int i = 0;i<c;i++){ //Loop through to now swap the first and last columns
				int temp = output[i][j];
				output[i][j]=output[i][r-1-j];
				output[i][r-1-j]=temp;
			}
		}
		System.out.println(Arrays.deepToString(output)); //method to call the array
	}


	/**
	 *Given a string containing just the characters '(', ')', return the count of valid parentheses. If the
	 * intput is not valid, return -1. A valid parentheses is "()". For example, given "(())", return 2;
	 * given "(()))", return -1.
	 */
	public int countValidParentheses(String s) {                         //wrong: if s is ")(", you should return -1

		int par1 = 0; //set first open parentheses count to 0
		int par2 = 0; //set first close parentheses count to 0
		int count = 0;	//set a counter to store the final count

		/*wanted to add a code to check if the string contains only parentheses but not sure how to achieve it without regex
		and regex is not taught yet*/

		if(s.length()==0){ //To confirm that the string is not empty
			System.out.println("The string is empty");
		}
		else {
			for (int i=0;i<s.length();i++){ //loop through the string to search for "("
				if (s.charAt(i)=='('){
					par1++; //if "(" is found increment par
				} 
				else if (s.charAt(i)==')'){ //loop through the string to search for ")"
					par2+=1; //if ")" is found increment par
				}
			}
			if(par1==par2) { //check if we have equal number of parentheses
				count=par1; //if so, increment count to 1
				System.out.println("The count of the number of parentheses is " +count);
				return count;
			}
			else 
				count = -1;	//if equal number of parentheses is not found, return -1
			System.out.println("The parentheses is not complete and hence,the count is "+count);
			return count;
		}
		return count;
	}



	public static void main(String[] args) {	
		Assignment3 agn3 = new Assignment3();

		//reversing an array
		int[] numsArray = new int[]{1,2,3,4,5};		
		System.out.println("The array before reversing is " +Arrays.toString(numsArray));
		agn3.reverseArray(numsArray);

		//plusone to an array of numbers
		agn3.plusOne(numsArray);

		//generating prime numbers
		agn3.generatePrimes(19);

		//to check if a string is a rotation of another
		agn3.isRotation("pineapple","applepine");

		//to check if a string is a permutation of the other
		agn3.isPermutation("volcano "," canovol");

		//to encode and decode strings
		String s="aaabbcc";
		agn3.encoding(s);
		agn3.decoding("3a2b2c");

		//rotate matrix by 90 degree
		int[][] mat = {{1,2,3,4},{5,6,7,8}};
		rotate(mat);

		//count the number of valid parentheses
		agn3.countValidParentheses("(())()");
	}

}

/**
 * Write anything you think about this assignment here. Easy? Difficult? Too many questions? Less fun?
 * You could write any comments here
 */
