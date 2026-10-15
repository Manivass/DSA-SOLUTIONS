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
    boolean ans = true ;
    public int balance( TreeNode curr ) {
        if( curr == null ) return 0 ;
        int left = 1 +  balance( curr.left ) ;
        int right = 1 + balance( curr.right ) ;
        int diff = Math.abs( left - right ) ;
        if( diff > 1 ) ans = false ;
        return Math.max( left , right ) ;
    }
    public boolean isBalanced(TreeNode root) {
        balance( root ) ;
        return ans ;
    }
}