package Leetcode_345;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public String reverseVowels(String s) {
		final ArrayList<String> vowelList = new ArrayList<String>() {
			{
				add("a");
				add("e");
				add("i");
				add("o");
				add("u");
				add("A");
				add("E");
				add("I");
				add("O");
				add("U");
			}
		};
		ArrayList<String> vowels = new ArrayList<>();
		ArrayList<Integer> indexs = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (vowelList.contains(s.substring(i, i + 1))) {
				indexs.add(new Integer(i));
				vowels.add(s.substring(i, i + 1));
			}
		}

		Integer[] indexArray = (Integer[]) indexs.toArray(new Integer[indexs
				.size()]);
		int[] intArray = new int[indexArray.length];
		for (int i = 0; i < indexArray.length; i++) {
			intArray[i] = indexArray[i].intValue();
		}
		for (int i = 0; i < s.length(); i++) {
			boolean exist = false;
			if (Arrays.binarySearch(intArray, i) > -1) {
				exist = true;
			}
			if (!exist) {
				sb.append(s.substring(i, i + 1));
			} else {
				sb.append(vowels.get(vowels.size() - 1));
				vowels.remove(vowels.size() - 1);
			}
		}
		return sb.toString();
	}
}