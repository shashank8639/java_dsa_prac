package javadsa.recursionLev2;

public class L_BinarySearch {

	public static void main(String[] args) {

		int a[] = { 2, 8, 13, 17, 21, 23, 27, 29};
		int key = 23;
		int index = binarySearch(a, key);
		System.out.println("key: "+key+" is at index: "+index);
	}

	private static int binarySearch(int[] a, int key) {
		int len = a.length;
		if(a==null || len==0)
			return -1;
		
		if(len==1 && a[0]==key)
			return 0;
		if(len==1)
			return -1;
		
		return getIndex(a, 0, len-1, key);
	}

	private static int getIndex(int[] a, int si, int ei, int key) {
		if(si > ei)
			return -1;
		
		int mid = si+(ei-si)/2;
		if(a[mid]==key)
			return mid;
		else if(a[mid]<key)
			return getIndex(a, mid+1, ei, key);
		else
			return getIndex(a, si, mid-1, key);
	}

}
