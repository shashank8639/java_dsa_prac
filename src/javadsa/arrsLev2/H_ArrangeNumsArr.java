package javadsa.arrsLev2;

public class H_ArrangeNumsArr {

	public static void main(String[] args) {

		int n = 6;
		
		int[] a = new int[n];
		arrangeArr(a, n);
		for(int k: a)
			System.out.print(k+", ");
		System.out.println("\n==========================");
		n = 11;
		int[] b = new int[n];
		arrangeArr(b, n);
		for(int k: b)
			System.out.print(k+", ");
	}

	private static void arrangeArr(int[] a, int n) {
		if(n==0 || n==1)
			return;
		
		int index = 0;
		for(int odd = 1; odd <= n; odd+=2)
			a[index++] = odd;
		
		int evenStart = n%2==0 ? n : n-1;
		for(int even = evenStart; even >= 2; even-=2)
			a[index++] = even;
	}

}
