package javadsa.recursionAssign;

//Write a recursive function that returns the sum of the digits of a given integer.


public class C_SumOfDigits {

	public static void main(String[] args) {

		int n = 12345;
		int ans = sumOfNumDigit(n);
		System.out.println("ans: "+ans);
	}

	private static int sumOfNumDigit(int n) {
		if(n==0) return 0;
		
		int sum = n%10;
		sum += sumOfNumDigit(n/10);
		
		return sum;
	}

}
