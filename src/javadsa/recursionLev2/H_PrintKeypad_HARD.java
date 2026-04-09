package javadsa.recursionLev2;

public class H_PrintKeypad_HARD {

	private static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {


		int n = 23;
		printKeypad(n);
		System.out.println("\n=================================");
		n = 568;
		printKeypad(n);
		
		System.out.println("\n=================================");
	}

	private static void printKeypad(int n) {
		if(n==0 || n==1)
			System.out.println("Given value is 0 or 1");;
		
		helper(n+"", 0, "");
	
	}

	private static void helper(String nums, int ind, String current) {
		if(ind==nums.length()) {
			System.out.print(current+", ");;
			return;
		}
		
		int digit = nums.charAt(ind)-'0';
		if(digit < 0 || digit > 9 || keypad[digit].length()==0)
			return;
		
		String word = keypad[digit];
		for(int i=0; i < word.length(); i++)
			helper(nums, ind+1, current+word.charAt(i));
	}

}
