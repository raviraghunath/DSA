//https://leetcode.com/problems/restore-ip-addresses/
package NumbersNOthers;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddress {

	public static void main(String[] args) {
		RestoreIpAddress restoreIpAddress = new RestoreIpAddress();
		System.out.println(restoreIpAddress.restoreIpAddresses("010010"));
	}

	public List<String> restoreIpAddresses(String s) {
		return restoreIpAddresses(s, 0, 0, "");
	}

	public List<String> restoreIpAddresses(String s, int pos, int compStage, String currString) {
		if (pos == s.length()) {
			if (compStage == 4) {
				List<String> res = new ArrayList<String>();
				res.add(currString);
				return res;
			} else {
				return new ArrayList<String>();
			}
		}
		if (compStage == 4) {
			return new ArrayList<String>();
		}
		List<String> res = new ArrayList<String>();
		String t = "";
		for (int i = pos; i < pos + 3 && i < s.length(); i++) {
			t += s.charAt(i);
			int val = Integer.parseInt(t);
			if (val >= 0 && val <= 255) {
				List<String> res1 = restoreIpAddresses(s, i + 1, compStage + 1,
						currString + t + (compStage == 3 ? "" : "."));
				if (res1 != null) {
					res.addAll(res1);
				}
			}
			if (val == 0) {
				break;
			}
		}
		return res;
	}

}
