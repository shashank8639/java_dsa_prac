package javadsa.collecs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//You are given with an integer k and an array of integers that contain numbers in random order. You have to 
//find k largest numbers from given array. You need to save them in an array and return it.
//
//Note:
//1. Time complexity should be O(n * logk) and space complexity should not be more than O(k).
//2. Order of elements in the output is not important.

public class B_KLargestElems {

	public static void main(String[] args) {

		int[] arr = {5, 9, 7, 10, 8, 11, 4, 12, 6};
		ArrayList<Integer> ans = findKLargestElems(arr, 4);
		if(ans!=null)
			System.out.println(ans);
	}

	private static ArrayList<Integer> findKLargestElems(int[] arr, int k) {
		if(arr==null) return null;
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		for(int i: arr)
			pq.add(i);
		
		for(int i=0; i < k; i++)
			output.add(pq.poll());
		
		return output;
	}

}
