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
    TreeNode ans = null ;
    public void traverse( TreeNode curr , int val ) {
        if( curr == null ) return  ;
        if( curr.val == val ) {
            ans = curr ;
            return ;
        }  
        if( curr.left !=  null && curr.val > val ) {
            traverse( curr.left , val ) ;
        }
        if( curr.right != null && curr.val < val ) {
            traverse( curr.right , val ) ;
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        traverse( root , val ) ;
        return ans ;
    }
}