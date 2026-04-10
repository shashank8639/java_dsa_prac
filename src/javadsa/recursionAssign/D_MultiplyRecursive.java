package javadsa.recursionAssign;

public class D_MultiplyRecursive {

	public static void main(String[] args) {

		int ans = multiplyNos(3, 5);
		System.out.println("3 * 5: "+ ans);
		
		ans = multiplyNos(6, 7);
		System.out.println("6 * 7: "+ ans);
	}

	private static int multiplyNos(int m, int n) {
		if(n==0) return 0;
		
		int ans = m;
		ans += multiplyNos(m, n-1);
		
		return ans;
	}

}
