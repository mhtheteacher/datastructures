package com.datastructures;

public class LeetCodeSameBinTree {

	static class TreeNode {
	      int val;
	   TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }

	public static boolean isIdentical (TreeNode t1, TreeNode t2) {
		if (t1==null && t2==null)
			return true;
		if (t1==null || t2==null)
			return false;
		if (t1.val==t2.val)
			return isIdentical(t1.left,t2.left) && isIdentical(t1.right,t2.right);
		else
			return false;
	}
	  public static void main(String[] args) {
		  TreeNode tnLeft= new TreeNode(2);
		  TreeNode tnRight= new TreeNode (3);
		  TreeNode tn= new TreeNode(1,tnLeft,tnRight );
		  
		  TreeNode tn2Left= new TreeNode(2);
		  TreeNode tn2Right= new TreeNode (3);
		  TreeNode tn2= new TreeNode(1,tn2Left,tn2Right );
		  
		  boolean sameOrnot=isIdentical(tn,tn2);
		  System.out.println(sameOrnot);
	  }
	  
}
  
