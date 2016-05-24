package Leetcode_226;

import java.util.ArrayList;

/**
 * 
 * @author Naafi
 *Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
	 to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */

public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	if(root==null){
            return null;
        }
		ArrayList<TreeNode> list = new ArrayList<>();
		list.add(root);
		while(!list.isEmpty()){
			TreeNode temp = list.get(list.size()-1);
			invertChildren(temp);
			list.remove(list.size()-1);
			if(temp.right!=null){
				list.add(temp.right);
			}
			if(temp.left!=null){
				list.add(temp.left);
			}		
		}
        return root;
    }
    
    private void invertChildren(TreeNode node){
    	if(node.left!=null||node.right!=null){
    		TreeNode temp = node.left;
    		node.left = node.right;
    		node.right = temp;
    	}
    }
}