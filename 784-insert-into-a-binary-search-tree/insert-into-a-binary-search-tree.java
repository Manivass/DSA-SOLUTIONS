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
    public TreeNode traverse( TreeNode curr , int val ) {
        if( curr == null ) return new TreeNode(val) ;
        if( curr.val < val ) {
            curr.right = traverse( curr.right , val ) ;
        }
        if( curr.val > val ) {
            curr.left = traverse( curr.left , val ) ;
        }
        return curr ;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return traverse( root , val ) ;
    }
}