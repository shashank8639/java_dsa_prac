package javadsa.recursionAssign;

public class H_CheckAB_MED {

	public static void main(String[] args) {

		String str = "aaabb";
		boolean ans = checkAB(str);
		System.out.println("Yes it follow give rules: "+ans);
		
		str = "aaabbaabbaaabb";
		ans = checkABMachineCode(str);
		System.out.println("Is it followed rules: "+ans);
	}

	private static boolean checkAB(String str) {
		 // Handle null or empty string
		if(str==null || str.isEmpty()) return true;
		
		 // Must start with 'a'
		if(str.charAt(0)!='a') return false;
		
		return helper(str, 0);
	}

	private static boolean helper(String str, int ind) {
		int len = str.length();
		// Base case: reached end of string
		if(ind==len) return true;
		
		 // Current character must be 'a' (by rules, we never encounter standalone 'b')
		if(str.charAt(ind)!='a') return false;
		
		// Check what follows this 'a'
		if(ind+1==len)
				return true; // End of string - valid
		else if(str.charAt(ind+1)=='a') 
			return helper(str, ind+1);  // Followed by 'a' - move to next character
		
		else if(ind+2 <= len 
				&& str.charAt(ind+1)=='b'
				&& str.charAt(ind+2)=='b')
			return helper(str, ind+3);  // Followed by "bb" - skip 3 characters
		else
			return false;  // Invalid pattern
	}

	private static boolean checkABMachineCode(String str) {
		
		if(str==null || str.isEmpty()) return true;
		
		int len = str.length();
		if(str.charAt(0)!='a') return false;
		
		// State machine approach
	    // State 0: Just saw 'a'
	    // State 1: Saw 'a' followed by 'b' (waiting for second 'b')
		int state =  0;
		for(int i=1; i < len; i++) {
			char c = str.charAt(i);
			
			switch(state) {
			case 0: // Last was 'a'
					if(c=='a')
						state = 0; // Still expecting 'a' or "bb"
					else if(c=='b')
						state = 1; // Saw first 'b', need another
					else
						return false;
					break;
			case 1:         // Last was 'b' (first of "bb")
					if(c=='b')
						state = 0;  // Complete "bb", now expect 'a'
					else
						return false; // "b" not followed by "b"
					break;
			}
		}
		// Final state must be 0 (ended with 'a' or "bb")
		return state==0;
	}

}
