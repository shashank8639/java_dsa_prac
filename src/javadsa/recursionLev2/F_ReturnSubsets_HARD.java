package javadsa.recursionLev2;

import java.util.ArrayList;
import java.util.List;

//Given an integer array (of length n), find and return all the subsets of input array.
//
//NOTE- Subsets are of length varying from 0 to n, that contain elements of the array. 
//But the order of elements should remain same as in the input array.
//
//Sample Input:
//3
//15 20 12
//Sample Output:
//[] (this just represents an empty array, don't worry about the square brackets)
//12 || 20 || 20 12 || 15 || 15 12 || 15 20 || 15 20 12 

public class F_ReturnSubsets_HARD {

	public static void main(String[] args) {

		int[] a = {15, 20, 12};
		int[][] ans = returnSubsets(a);
		for(int i=0; i < ans.length; i++) {
			for(int j=0; j < ans[i].length; j++)
				System.out.print(ans[i][j]+" ");
			System.out.print("|| ");
		}
		System.out.println("\n====================");
		int[] b = {5, 7};
		int[][] b_ans = returnSubsets(b);
		for(int i=0; i < b_ans.length; i++) {
			for(int j=0; j < b_ans[i].length; j++)
				System.out.print(b_ans[i][j]+" ");
			System.out.println("|| ");
		}
	}

	private static int[][] returnSubsets(int[] a) {
		if(a==null)
			return new int[][] {};
			
		List<ArrayList<Integer>> res = new ArrayList<>();
		helper(a, 0, new ArrayList<Integer>(), res);
		
		int[][] ans = new int[res.size()][];
		for(int i=0; i < ans.length; i++) {
			ans[i] = new int[res.get(i).size()];
			for(int j=0; j < ans[i].length; j++)
				ans[i][j] = res.get(i).get(j);
		}
		return ans;
	}

	private static void helper(int[] a, int ind, ArrayList<Integer> current, List<ArrayList<Integer>> res) {
		if(ind==a.length) {
			res.add(new ArrayList<Integer>(current));
			return;
		}
		helper(a, ind+1, current, res);
		current.add(a[ind]);
		helper(a, ind+1, current, res);
		current.remove(current.size()-1);
	}

}
