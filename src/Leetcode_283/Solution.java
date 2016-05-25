package Leetcode_283;
/**
 * 
 * @author Naafi
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class Solution {
	 public void moveZeroes(int[] nums) {
		 int count = 0;
		 int i=0;
		 while(i<nums.length-count){
			 if(nums[i]==0){
				 count++;
				 for(int j=i;j<nums.length-1;j++){
					 nums[j] = nums[j+1];
				 }
				 i--;
			 }
			 i++;
		 }
		 if(count!=0){
			 for(int k=0;k<count;k++){
				 nums[nums.length-1-k] = 0;
			 }
		 } 
	 }
}
