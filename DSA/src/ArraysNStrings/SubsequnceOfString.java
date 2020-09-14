package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class SubsequnceOfString {
	public static void main(String[] args) {
		SubsequnceOfString ofString = new SubsequnceOfString(); 
		ofString.getSubseq("abcd", "");
		System.out.println(ofString.strings);
		ofString.strings.clear();
		ofString.getSubseq1("abcd", "");
		System.out.println(ofString.strings);
	}

	public List<String> strings = new ArrayList<String>();
 
	public void getSubseq(String s, String ans) {
		if (s.length() == 0) {
			strings.add(ans);
			return;
		}
		getSubseq(s.substring(1), ans + s.charAt(0));
		getSubseq(s.substring(1), ans); 
	}

	public void getSubseq1(String s, String ans) {
		if (s.length() == 0) { 
			strings.add(ans);
			return;
		}
		String s1 = s.substring(0, s.length() - 1);
		getSubseq1(s1, ans + s.charAt(s.length() - 1));
		getSubseq1(s1, ans);
	}
}
