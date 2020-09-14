package ArraysNStrings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {

	public static void main(String[] args) {
		PalindromePairs pairs = new PalindromePairs();
		System.out.println(pairs.palindromePairs(new String[] { "bat","tab","cat" }));

	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			for (int j = i+1; j < words.length; j++) {
				if (isPalindrome(words[i] + words[j])) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(i);
					l.add(j);
					lists.add(l);
				}
				if (words[i]!=words[j]&& isPalindrome(words[j] + words[i])) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(j);
					l.add(i);
					lists.add(l);
				}
			}
		}
		return lists;
	}

	private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		return i >= j;
	}
}
