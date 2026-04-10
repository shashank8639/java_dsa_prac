package javadsa.recursionAssign;

//Given a string S, compute recursively a new string where identical chars that are adjacent in the 
//original string are separated from each other by a "*".
//Sample Input 1 :
//hello
//Sample Output 1:
//hel*lo

public class G_PairStar_MED {

	public static void main(String[] args) {

		String str = "hello";
		String ans = pairStar(str);
		System.out.println(ans);
	
		str = "aaaa";
		ans = pairStar(str);
		System.out.println(ans);
	}

	private static String pairStar(String str) {
		if(str==null || str.isEmpty()) return str;
		
		int len = str.length();
		if(len==1) return str;
		
		String ans = str.charAt(0)+pairStar(str.substring(1));
		int n = ans.length();
		if(n>1 && ans.charAt(0)==ans.charAt(1))
			return ans.charAt(0)+"*"+ans.substring(1);
		
		return ans;
	}

}
