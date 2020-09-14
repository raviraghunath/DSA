package TreesAndGraphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapSumPairs {

	class MapSum {

		class TrieNode {
			char c;
			int value;
			Map<Character, TrieNode> nodes = new HashMap<Character, MapSumPairs.MapSum.TrieNode>();
		}

		TrieNode root;

		public MapSum() {
			root = new TrieNode();
			root.c = '*';
		}

		public void insert(String key, int val) {
			TrieNode lRoot = root;
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				if (lRoot.nodes.containsKey(c)) {
					lRoot = lRoot.nodes.get(c);
				} else {
					TrieNode node = new TrieNode();
					node.c = c;
					lRoot.nodes.put(c, node);
					lRoot = node;
				}
			}
			lRoot.value = val;
		}

		public int sum(String prefix) {
			TrieNode lRoot = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (lRoot.nodes.containsKey(c)) {
					lRoot = lRoot.nodes.get(c);
				} else {
					return 0;
				}
			}
			return getVal(lRoot);
		}

		private int getVal(TrieNode node) {
			if (node == null) {
				return 0;
			}
			int res = node.value;
			for (Entry<Character, TrieNode> entry : node.nodes.entrySet()) {
				res += getVal(entry.getValue());
			}
			return res;
		}
	}

	public static void main(String[] args) {
		MapSumPairs mapSumPairs = new MapSumPairs();
		MapSum mapSum =  mapSumPairs.new MapSum();
		mapSum.insert("apple", 3);
		System.out.println(mapSum.sum("ap"));
		mapSum.insert("app", 2);
		System.out.println(mapSum.sum("ap"));
		mapSum.insert("ap", 1);
		System.out.println(mapSum.sum("ap"));

	}

}
