package javadsa.recursionAssign;

//Given k, find the geometric sum i.e.           |       Sample Input 1 :
//												 |       3
//1 + 1/2 + 1/4 + 1/8 + ... + 1/(2^k) 			 |       Sample Output 1 :
//Note :										 |       Explanation for Sample Input 1:
//using recursion.								 |       1+ 1/(2^1) + 1/(2^2) + 1/(2^3) = 1.87500


public class A_GeometricSum_MED {

	public static void main(String[] args) {

		int k = 3;
		double ans = geometricSum(k);
		System.out.println("for K: "+k+" ans: "+ans);
		
		k = 4;
		ans = geometricSum(k);
		System.out.println("for K: "+k+" ans: "+ans);
	}

	private static double geometricSum(int k) {
		if(k==0) return 1;
		
		double a = 1.0;
		for(int i=0; i < k; i++)
			a = a*2.0;
		
		double ans = geometricSum(k-1);
		ans = ans + 1/a;
		
		return ans;
	}

}
