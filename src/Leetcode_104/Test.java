package Leetcode_104;

public class Test {
	public static void main(String[] args) {
		TreeNode a = new TreeNode(0);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(2);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(4);
		TreeNode f = new TreeNode(5);
		TreeNode g = new TreeNode(6);
		a.left = b;
		a.right = c;
		b.left = d;
		c.left = e;
		c.right = f;
		e.right = g;
		
		Solution sol = new Solution();
		System.out.println(sol.maxDepth(a));
	}
}
