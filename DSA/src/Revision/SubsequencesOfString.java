package Revision;

import java.util.ArrayList;
import java.util.List;

import ArraysNStrings.SubsequnceOfString;

public class SubsequencesOfString {
	public static void main(String[] args) {
		SubsequencesOfString subsequencesOfString = new SubsequencesOfString();
		SubsequnceOfString ofString = new SubsequnceOfString();
		System.out.println(subsequencesOfString.getSubsequences("abc", "", 0));
		System.out.println("--");
		ofString.getSubseq("abc", "");
		System.out.println(ofString.strings);
	}

	private List<String> getSubsequences(String s, String s1, int pos) {
		if (pos >= s.length()) {
			List<String> list = new ArrayList<String>();
			list.add(s1);
			return list;
		}
		List<String> list = new ArrayList<String>();
		list.addAll(getSubsequences(s, s1 + s.charAt(pos), pos + 1));
		list.addAll(getSubsequences(s, s1, pos + 1));
		return list;
	}
}
