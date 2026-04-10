package javadsa.recursionAssign;

//Write a recursive function to convert a given string into the number it represents. That is input will
//be a numeric string that contains only numbers, you need to convert the string into corresponding integer
//and return the answer.


public class F_String2Integer_MED {

	public static void main(String[] args) {

		String str = "000123";
		int ans = stringToInt(str);
		System.out.println(ans);
		System.out.println("======================");
		
		str = "1231";
		ans = stringToInt(str);
		System.out.println(ans);
	}

	private static int stringToInt(String str) {
		if(str==null || str.isEmpty()) return 0;
		
		int len = str.length();
		
		int digit = str.charAt(len-1)-'0';
		int ans = digit + 10*stringToInt(str.substring(0, len-1));
		
		return ans;
	}

}
