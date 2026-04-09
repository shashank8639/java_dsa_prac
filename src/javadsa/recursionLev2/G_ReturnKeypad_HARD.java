package javadsa.recursionLev2;

import java.util.ArrayList;
import java.util.List;

//Given an integer n, using phone keypad find out all the possible strings that can be made using 
//digits of input n.
//
//Return empty string for numbers 0 and 1.
//
//Note :
//1. The order of strings are not important.
//2. Input and output has already been managed for you. You just have to populate the output array 
//and return the count of elements populated in the output array.
public class G_ReturnKeypad_HARD {
	
	private static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {

		int n = 23;
		String[] ans = returnKeypad(n);
		for(String k: ans)
			System.out.print(k+", ");
		
		System.out.println("\n=================================");
		n = 568;
		ans = returnKeypad(n);
		for(String k: ans)
			System.out.print(k+", ");
		System.out.println("\n=================================");
		n = 508;
		ans = returnKeypad(n);
		for(String k: ans)
			System.out.print(k+", ");
	}

	private static String[] returnKeypad(int n) {
		if(n==0 || n==1)
			return new String[0];
		
		List<String> res = new ArrayList<String>();
		helper(n+"", 0, "", res);
		
		return res.toArray(new String[0]);
	}

	private static void helper(String nums, int ind, String current, List<String> res) {
		if(ind==nums.length()) {
			res.add(current);
			return;
		}
		
		int digit = nums.charAt(ind)-'0';
		String word = keypad[digit];
		if(digit < 0 || digit > 9 || word.length()==0)
			return;
		
		for(int i=0; i < word.length(); i++)
			helper(nums, ind+1, current+word.charAt(i), res);
		
	}

}
