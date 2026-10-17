/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;

    public int traverse(TreeNode curr) {
        if (curr == null)
            return 0;
        int left = Math.max(0, traverse(curr.left));
        int right = Math.max(0, traverse(curr.right));
        max = Math.max(max, curr.val + left + right);
        return curr.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return max;
    }
}