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
    public boolean symmetric( TreeNode left , TreeNode right ) {
        if( left == null && right == null ) return true ;
        if( left == null || right == null ) return false ;
        if( left.val != right.val ) return false ;
        boolean leftToRight = symmetric( left.right , right.left ) ;
        boolean rightToLeft = symmetric( left.left , right.right ) ;
        return leftToRight && rightToLeft ;
    }
    public boolean isSymmetric(TreeNode root) {
        return symmetric( root.left , root.right ) ;
    }
}