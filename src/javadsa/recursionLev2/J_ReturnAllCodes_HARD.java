package javadsa.recursionLev2;

import java.util.ArrayList;
import java.util.List;

public class J_ReturnAllCodes_HARD {

	public static void main(String[] args) {

		String str = "1123";
		String[] ans = getCodes(str);
		for(String v: ans)
			System.out.print(v+", ");
	}

	private static String[] getCodes(String str) {
		if(str==null || str.length()==0)
			return new String[0];
		
		List<String> res = new ArrayList<String>();
		getAlphabets(str, 0, "", res);
		
		return res.toArray(new String[0]);
	}

	private static void getAlphabets(String str, int ind, String current, List<String> res) {
		if(ind==str.length()) {
			res.add(current);
			return;
		}
		
		int one = str.charAt(ind)-'0';
		if(one > 0 && one <= 9)
			getAlphabets(str, ind+1, current+(char)('a'+one-1), res);
		
		if(ind+1 < str.length()) {
			int two = Integer.parseInt(str.substring(ind, ind+2));
			if(two >= 10 && two <= 26)
				getAlphabets(str, ind+2, current+(char)('a'+two-1), res);
		}
	}

}
