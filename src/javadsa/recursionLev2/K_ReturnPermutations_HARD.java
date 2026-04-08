package javadsa.recursionLev2;

import java.util.ArrayList;
import java.util.List;

public class K_ReturnPermutations_HARD {

	public static void main(String[] args) {

		String str = "abc";
		
		String[] ans = getPermutations(str);
		for(String s: ans)
			System.out.print(s+", ");
	}

	private static String[] getPermutations(String str) {
		if(str==null || str.length()==0)
			return new String[0];
		
		List<String> res = new ArrayList<String>();
		helper(str, "", res);
		
		return res.toArray(new String[0]);
	}

	private static void helper(String str, String prefix, List<String> res) {

		if(str.length()==0) {
			res.add(prefix);
		} else {
			for(int i=0; i < str.length(); i++)
				helper(str.substring(0, i)+str.substring(i+1, str.length()), prefix+str.charAt(i), res);
		}
	}

}
