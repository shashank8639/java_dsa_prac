package javadsa.recursionAssign;

public class B_CheckPalindrome {

	public static void main(String[] args) {

		String str = "MADAM";
		boolean ans = isPalindrome(str);
		System.out.println(ans ? "Yes Palindrome": "Not a palindrome");
		
		str = "GAJA";
		ans = isPalindrome(str);
		System.out.println(ans ? "Yes Palindrome": "Not a palindrome");
	}
	
	public static boolean isPalindrome(String str) {
        // Write your code here.
		if(str==null) return true;

		return helper(str, 0, str.length()-1);
    }

	private static boolean helper(String str, int st, int end) {
		if(st >= end) return true;

		if(str.charAt(st) != str.charAt(end))
			return false;

		return helper(str, st+1, end-1);
	}

}
