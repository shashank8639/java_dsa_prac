package javadsa.collecs;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers and numbers k and m, write a function that returns true if given array can be divided 
//into pairs such that the sum of every pair gives remainder m when divided by k.

//Constraints :
//	 1 <= N <= 10^4
//	 1 <= M < K <= 10^2
//	Sample Input :
//	4
//	2 1 5 7
//	9
//	3
//	Sample Output :
//	true
//	Explanation :
//	Pairs will be (2,1) and (5,7)
public class C_ValidPairs_Hard {

	public static void main(String[] args) {


		int[] arr = {92, 45, 35, 48, 25, 65};
		boolean ans = validPairs(arr, arr.length, 10, 0);
		check(ans);
		
		int[] arr2 = {92, 45, 35, 48, 25, 65, 97, 48};
		ans = validPairs(arr2, arr.length, 10, 0);
		check(ans);
		
	}

	private static boolean validPairs(int[] arr, int length, int k, int m) {
		if(arr==null) return true;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int target = m;
		
		for(int value: arr)
			map.put(value%k, map.getOrDefault(value%k, 0)+1);
		
		for(int num: arr) {
			int rem = num%k;
			int needed = (target-rem+k)%k;
			
			if(rem==needed) {
				if(map.get(rem)%2 != 0) return false;
			} else {
				int data = map.getOrDefault(needed, 0);
				if(!map.get(rem).equals(data))
					return false;
			}
		}
		
		return true;
	}

	private static void check(boolean ans) {

		if(ans)
			System.out.println("Pairs are valid: ");
		else
			System.out.println("Pairs are not valid");
	}

}
