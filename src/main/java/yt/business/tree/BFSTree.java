package yt.business.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSTree {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public ArrayList<Integer> PrintFromTopToBottomBFS(TreeNode root) {
		ArrayList<Integer> lists=new ArrayList<Integer>();
		if(root==null){
			return lists;
		}

		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode tree=queue.poll();
			if(tree.left!=null) {
				queue.offer(tree.left);
			}
			if(tree.right!=null) {
				queue.offer(tree.right);
			}
			lists.add(tree.val);
		}
		return lists;
	}

	public ArrayList<Integer> PrintFromTopToBottomDFS(TreeNode root) {
		ArrayList<Integer> lists=new ArrayList<Integer>();
		if(root==null) {
			return lists;
		}
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tree=stack.pop();
			if(tree.right!=null) {
				stack.push(tree.right);
			}
			if(tree.left!=null) {
				stack.push(tree.left);
			}
			lists.add(tree.val);
		}
		return lists;
	}
}
