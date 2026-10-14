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
    public boolean pathSum(TreeNode curr, int target , int sum ) {
        if( curr == null ) return false ;
        if( sum + curr.val == target && curr.left == null && curr.right == null ) return true ;
        boolean left = pathSum( curr.left , target , sum + curr.val ) ;
        boolean right = pathSum( curr.right , target , sum + curr.val ) ;
        return left || right ;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return pathSum(root, targetSum , 0 );
    }
}