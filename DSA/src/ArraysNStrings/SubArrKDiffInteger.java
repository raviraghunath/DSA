package ArraysNStrings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubArrKDiffInteger {

	public static void main(String args[]) throws Exception {
		SubArrKDiffInteger arrKDiffInteger = new SubArrKDiffInteger();
//		int cnt = arrKDiffInteger.subarraysWithKDistinct(new int[] { 1, 2, 1, 2, 3 }, 2);
//		int cnt = arrKDiffInteger.subarraysWithKDistinct(new int[] { 2, 1, 2, 1, 2 }, 2);
		// int cnt = arrKDiffInteger.subarraysWithKDistinct(new int[] { 2, 1, 1, 1, 2 },
		// 1);
//		int cnt = arrKDiffInteger.subarraysWithKDistinct(new int[] { 1, 2, 1, 3, 4 }, 3);
		int cnt = arrKDiffInteger.subarraysWithKDistinct(new int[] { 1, 1, 2, 1, 3 }, 2);
		System.out.println(cnt);

		File file = new File("./props/SubArrKDiffIntegerFile.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		int arr[] = null;
		while ((st = br.readLine()) != null) {
			String[] stArr = st.split(",");
			arr = new int[stArr.length];
			int i = 0;
			for (String str : stArr) {
				arr[i++] = Integer.parseInt(str);
			}
			break;
		}
		System.out.println("arr : " + arr.length);
		cnt = arrKDiffInteger.subarraysWithKDistinct(arr, 1000);
		System.out.println(cnt);

	}

	public int subarraysWithKDistinct(int[] A, int K) {
		// ex : 1 1 2 1 3 4 5
		int cnt = 0;
		int stPtr = 0;
		Set<Integer> set = new HashSet<Integer>(K);
		int kminus1 = K - 1;
		int ALenminus1 = A.length - 1;
		int i, ele;
		while (stPtr + kminus1 <= ALenminus1) {
			for (i = stPtr; i < A.length; i++) {
				ele = A[i];
				if (set.size() < K) {
					if (!set.contains(ele)) {
						set.add(ele);
						if (set.size() == K)
							cnt++;
					}
				} else if (set.contains(ele))
					cnt++;
				else
					break;

			}
			stPtr++;
			set = new HashSet<Integer>(K);
		}
		return cnt;
	}


}
