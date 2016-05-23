package Leetcode_104;

/*
Given a binary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Solution {
    public int maxDepth(TreeNode root) {	
    	if(root!=null)
    		return dfs(root, 1);
		return 0;
    }
    
    private int dfs(TreeNode node,int depth) {
    	int original = depth;
    	if(node.left!=null){
    		depth = dfs(node.left, depth+1);
    	}
    	if(node.right!=null){
    		int temp = dfs(node.right,original+1);
    		depth = temp>depth?temp:depth;
    	}
		return depth;		
	}
}