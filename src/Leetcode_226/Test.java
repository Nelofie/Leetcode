package Leetcode_226;

import java.util.ArrayList;

import Leetcode_226.Solution;
import Leetcode_226.TreeNode;

public class Test {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);
		TreeNode i = new TreeNode(9);
		d.left = b;
		d.right = g;
		b.left = a;
		b.right = c;
		g.left = f;
		g.right = i;
		
		Solution sol = new Solution();
		sol.invertTree(d);
		
		ArrayList<TreeNode> list = new ArrayList<>();
		list.add(d);
		while(!list.isEmpty()){
			TreeNode temp = list.get(list.size()-1);
			System.out.println(temp.val);
			list.remove(list.size()-1);
			if(temp.right!=null){
				list.add(temp.right);
			}
			if(temp.left!=null){
				list.add(temp.left);
			}		
		}
	}
}
