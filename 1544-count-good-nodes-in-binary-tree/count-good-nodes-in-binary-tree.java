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
    int cnt = 1 ;
    public void traverse( TreeNode curr , int max ) {
        if( curr == null ) return ;
        if( curr.val >= max ) {
            max = curr.val ;
            cnt++ ;
        }
        if( curr.left != null ) traverse( curr.left , max ) ;
        if( curr.right != null ) traverse( curr.right , max ) ;
    }
    public int goodNodes(TreeNode root) {
        traverse( root.left , root.val ) ;
        traverse( root.right , root.val ) ;
        return cnt ;
    }
}