package javadsa.arrsLev2;

import java.util.Arrays;

//You have been given a random integer array/list(ARR) and a number X. Find and return the number
//		of triplets in the array/list which sum to X.
//Sample Input 1:
//1 2 3 4 5 6 7 
//12
//Sample Output 1:
//5
//Sample Input 2:
//7
//1 2 3 4 5 6 7 
//9
//2 -5 8 -6 0 5 10 11 -3
//10
//Sample Output 2:
//0
//5
//
// Explanation for Input 2:
//Since there doesn't exist any triplet with sum equal to 19 for the first query, we print 0.
//
//For the second query, we have 5 triplets in total that sum up to 10. They are, 
//(2, 8, 0), (2, 11, -3), (-5, 5, 10), (8, 5, -3) and (-6, 5, 11)
public class I_TripletSum_Med {

	public static void main(String[] args) {

			int[] a = {5, 5, 4, 4, 5, 4};
			int sum = 13;
			int tripletCount = findTriplet(a, sum);
			System.out.println("No. of triplets are: "+tripletCount);
			
			int[] b = {2, -5, 8, -6, 0, 5, 10, 11, -3};
			sum = 10;
			tripletCount = findTriplet(b, sum);
			System.out.println("No. of triplets are: "+tripletCount);
	}

	public static int findTriplet(int[] arr, int x) {
	    Arrays.sort(arr);  // O(n log n) - negligible compared to n?
	    int count = 0;
	    int n = arr.length;
	    
	    for (int i = 0; i < n - 2; i++) {
	        int left = i + 1;
	        int right = n - 1;
	        int target = x - arr[i];
	        
	        while (left < right) {
	            int sum = arr[left] + arr[right];
	            
	            if (sum < target) {
	                left++;
	            } else if (sum > target) {
	                right--;
	            } else {
	                // Efficient duplicate handling
	                if (arr[left] == arr[right]) {
	                    int freq = right - left + 1;
	                    count += (freq * (freq - 1)) / 2;
	                    break;
	                } else {
	                    int leftCount = 1;
	                    while (left + 1 < right && arr[left] == arr[left + 1]) {
	                        leftCount++;
	                        left++;
	                    }
	                    
	                    int rightCount = 1;
	                    while (right - 1 > left && arr[right] == arr[right - 1]) {
	                        rightCount++;
	                        right--;
	                    }
	                    
	                    count += leftCount * rightCount;
	                    left++;
	                    right--;
	                }
	            }
	        }
	    }
	    return count;
	}

}
