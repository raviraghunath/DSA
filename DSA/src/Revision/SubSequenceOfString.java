package Revision;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfString {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		SubSequenceOfString subSequenceOfString = new SubSequenceOfString();
		subSequenceOfString.subSequence("abcd", "", strings);
		System.out.println(strings);
	}

	private void subSequence(String s, String ans, List<String> strings) {
		if (s.length() == 0) {
			strings.add(ans);
			return;
		}
		subSequence(s.substring(1), ans + s.charAt(0), strings);
		subSequence(s.substring(1), ans, strings);
	}

}
