package Leetcode_283;

public class Test {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] test = {0,1,0,3,12};
		int[] test2 = {0,0,1};
		int[] test3 = {0,1,0};
		sol.moveZeroes(test);
		sol.moveZeroes(test2);
		sol.moveZeroes(test3);
		for(int i=0;i<test.length;i++){
			System.out.println(test[i]);
		}
		System.out.println();
		for(int i=0;i<test2.length;i++){
			System.out.println(test2[i]);
		}
		System.out.println();
		for(int i=0;i<test3.length;i++){
			System.out.println(test3[i]);
		}
	}
}
