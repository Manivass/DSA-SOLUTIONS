/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null ;
    public void traverse( TreeNode curr , int p , int q ) {
        if( curr == null ) return ;
        if( curr.val > p && curr.val > q ) {
            traverse( curr.left , p , q ) ;
        }
        else if( curr.val < p && curr.val < q ) {
            traverse( curr.right , p , q ) ;
        }
        else {
            ans = curr ;
            return ;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse( root , p.val , q .val) ;
        return ans ;
    }
}