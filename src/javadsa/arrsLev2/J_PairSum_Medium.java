package javadsa.arrsLev2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//You have been given an integer array/list(ARR) and a number X. Find and return the total number of pairs in the array/list which sum to X.
//
//Note:
//Given array/list can contain duplicate elements. 
//1 3 6 2 5 4 3 2 4
//7
//Sample Output 1:
//7
//2 8 10 5 -2 5
//10
//Sample Output 2:
//2
public class J_PairSum_Medium {

	public static void main(String[] args) {

		int[] a = { 2, 8, 10, 5, -2, 5 };
		int ans = pairSum(a, 10);
		System.out.println("No. of pair that sum to 10: " + ans);
		System.out.println("==================================");
		System.out.println("===========WIth HashMap(O(N))=============");
		
		ans = pairSumBetter(a, 10);
		System.out.println("No. of pair that sum to 10: " + ans);
	}

	private static int pairSumBetter(int[] a, int sum) {
		
		int n = a.length;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < n; i++)
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
		
		int count = 0;
		for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			int current = e.getKey();
			int complement = sum-current;
			
			if(complement < current) continue;
			
			if(map.containsKey(complement)) {
				if(current==complement) {
					int freq = e.getValue();
					count += (freq*(freq-1))/2;
				} else {
					count += e.getValue()*map.get(complement);
				}
			}
		}
		return count;
	}

	private static int pairSum(int[] a, int sum) {
		int n = a.length;
		if (n < 2)
			return 0;

		Arrays.sort(a);
		int count = 0;
		int left = 0, right = n - 1;
		while (left < right) {
			if (a[left] + a[right] < sum)
				left++;
			else if (a[left] + a[right] > sum)
				right--;
			else {
				if (a[left] == a[right]) {
					int freq = right - left + 1;
					count += (freq * (freq - 1)) / 2;
					break;
				}
				int leftVal = a[left];
				int l = left, r = right;
				int leftCount = 0, rightCount = 0;
				while (l <= right && a[l] == leftVal) {
					leftCount++;
					l++;
				}
				
				int rightVal = a[right];
				
				while (r >= left && a[r] == rightVal) {
					rightCount++;
					r--;
				}
				count += leftCount * rightCount;
				left = l;
				right = r;

			}
		}

		return count;
	}

}
