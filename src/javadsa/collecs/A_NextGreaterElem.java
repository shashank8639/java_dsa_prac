package javadsa.collecs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

//Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x,
//is the first greater element on right side of x in the array. Elements for which no greater element exist, 
//consider next greater element as -1.
//
//Sample Input
//5
//3  8  1  2  0
//Sample Output
//8 -1  2 -1 -1
public class A_NextGreaterElem {

	public static void main(String[] args) {

		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(731,949,325,578, 655, 648, 774,351));
		
		System.out.println(input);
		System.out.println("==================================");
		
		ArrayList<Integer> output = nextGreaterElem(input);
		System.out.println(output);
		
	}

	private static ArrayList<Integer> nextGreaterElem(ArrayList<Integer> input) {
		if(input==null || input.isEmpty()) return input;
		
		int n = input.size();
		ArrayList<Integer> output = new ArrayList<Integer>(Collections.nCopies(n, 0));
		Stack<Integer> stack = new Stack<>();
		
		for(int i=n-1; i >= 0; i--) {
			
			if(stack.isEmpty()) {
				output.set(i, -1);
				stack.push(input.get(i));
			} else {
				while(!stack.isEmpty() && input.get(i) >= stack.peek()) stack.pop();
				
				if(stack.isEmpty()) {
					output.set(i, -1);
					stack.push(input.get(i));
				} else {
					output.set(i, stack.peek());
					stack.push(input.get(i));
				}
			}
		}
		
		return output;
	}

}
