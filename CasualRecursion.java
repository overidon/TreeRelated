package main;

import java.util.Scanner;

public class CasualRecursion {

	
	// main driver method 
	public static void main(String[] args) {
		
		// there will be multiple test cases!
		int [] test0 = {7, 8, 9, 2, 4, 3, 0, 17, 14, 13, 209, -12, -17, 5, -4};
		
		int [] test1 = {-10, -20, 40, 30, 60, 5, 7, 8};
		
		// GOAL use the test cases in functions
		//      also use recursion and an index to help
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Please enter an integer below: \n");
		
		boolean result = false; 
		
		try {
			int num = sc.nextInt();
			
			System.out.println("The magicNum is: " + num);
			
			result = addsUp(num, test0);
		} catch (Exception e) {
			
			
		}
		
		System.out.println(String.format("It is %s that we found the magic number.", result));
		
	// end of the main method 
	}
	
	// Magic Number -> Can any of the values in the array add up to the magic number?
	// you can skip numbers, you can also add negative nubers
	// you just can't add the same number at the same index twice or more
	
	public static boolean addsUp(int magicNum, int [] arr ) {
		
		
		boolean iFoundIt = addsHelper(magicNum, arr, 0, 0);
		
		if ( iFoundIt ) {
			
			System.out.println("Yay!");
			
			return true;
		} 
		
		System.out.println(" OOofers I cannot find magic num oh well.");
		// TODO 
		return false;
	
	// end of the addUp method 
	}
	
	public static boolean addsHelper(int magicNum, int[]arr, int index, int total ) {
		
		System.out.println("... calculating.... total so far is: " + total);
		
		int L = arr.length; 
		
		// let's return true if we hit the goal! 
		if ( total == magicNum) {
			
			System.out.println("The magic number was found!");
			return true; 
		} 
		
		
		// when do we absolutely know we return false? 
		if ( index < 0 || index > L - 1) {
				
			return false;
		
		// end of the out of bounds check.. 
		}
		
		// since we're not out of bounds... let's see what's up! 
		int addMe = arr[index];
		
		// check to see if adding this number to the tree will yield a true result!
		if ( addsHelper(magicNum, arr, index + 1, total + addMe) ) return true; 
		
		// check to see if NOT adding this number to the tree will yield a true result
		if ( addsHelper(magicNum, arr, index + 1, total)) return true;
		
	
		
		return false;
		
	// end of the addsHelper method 
	}
	
	
	
// end of the LearnRecursion class 
}
