package javadsa.recursionAssign;

//Write a recursive function to convert a given string into the number it represents. That is input will 
//be a numeric string that contains only numbers, you need to convert the string into corresponding
//integer and return the answer.


public class E_CountZeros {

	public static void main(String[] args) {

		int n = 10101;
		int count = countZeros(n);
		System.out.println("No. of zero's: "+count);
		
		n = 204000;
		count = countZeros(n);
		System.out.println("No. of zero's: "+count);
	}

	private static int countZeros(int n) {
		if(n==0) return 1;
		
		int k = n/10;
		int c = 0;
		if(k!=0) {
			c = countZeros(k);
			if(n%10==0)
				c++;
		}
		return c;
	}

}
