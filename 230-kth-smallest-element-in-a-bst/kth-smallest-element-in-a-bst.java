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
    int count;
    int ans = 0;

    public void traverse(TreeNode curr) {
        if (curr.left != null)
            traverse(curr.left);
        count--;
        if (count == 0) {
            ans = curr.val;
            return;
        }
        if( curr.right != null ) traverse( curr.right ) ;
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k ;
        traverse(root);
        return ans ;
    }
}