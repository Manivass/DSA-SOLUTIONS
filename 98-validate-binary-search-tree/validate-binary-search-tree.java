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
    public boolean traverse( TreeNode curr , long low , long high ) {
        if( curr == null ) return true ;
        if( curr.val <= low || curr.val >= high ) return false ;
        return traverse( curr.left , low , curr.val  ) && traverse( curr.right , curr.val , high ) ;
    }
    public boolean isValidBST(TreeNode root) {
        return traverse( root , Long.MIN_VALUE , Long.MAX_VALUE  ) ;
    }
}