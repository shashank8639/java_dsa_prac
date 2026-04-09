package javadsa.recursionLev2;

import java.util.ArrayList;
import java.util.List;

//Given an array A of size n and an integer K, return all subsets of A which sum to K.
//
//Subsets are of length varying from 0 to n, that contain elements of the array. But the order
//of elements should remain same as in the input array.
//
//Sample Input :
//9 
//5 12 3 17 1 18 15 3 17 
//6
//Sample Output :
//3 3
//5 1
public class I_ReturnSubsetsToSumK {

	public static void main(String[] args) {

		int[] a = {5, 12, 3, 17, 1, 18, 15, 3, 17};
		int[][] ans = returnSubsetsSumK(a, 6);
		for(int i=0; i < ans.length; i++) {
			for(int j=0; j < ans[i].length; j++)
				System.out.print(ans[i][j]+", ");
			System.out.println();
		}
	}

	private static int[][] returnSubsetsSumK(int[] a, int k) {
		if(a==null || a.length==0)
			return new int[0][];
		
		List<ArrayList<Integer>> res = new ArrayList<>();
		helper(a, k,0, new ArrayList<Integer>(), res, 0);
		
		int[][] ans = new int[res.size()][];
		for(int i=0; i < ans.length; i++) {
			ans[i] = new int[res.get(i).size()];
			for(int j=0; j < ans[i].length; j++)
				ans[i][j] = res.get(i).get(j);
		}
		
		return ans;
	}

	private static void helper(int[] a, int k, int ind, ArrayList<Integer> current, List<ArrayList<Integer>> res, int currentSum) {
		
		if(currentSum==k) {
			res.add(new ArrayList<>(current));
		}
		if(ind==a.length || currentSum > k)
			return;
		
		for(int i=ind; i < a.length; i++) {
			current.add(a[i]);
			helper(a, k, i+1, current, res, currentSum+a[i]);
			current.remove(current.size()-1);
		}
		
	}

}
