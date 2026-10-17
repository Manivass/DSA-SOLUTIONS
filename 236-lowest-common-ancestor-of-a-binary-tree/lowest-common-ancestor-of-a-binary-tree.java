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
    public int traverse( TreeNode curr , TreeNode p , TreeNode q ) {
        if( curr == null ) return 0 ;
        int count = 0 ;
        int left = traverse( curr.left , p , q ) ;
        int right = traverse( curr.right , p , q ) ;
        if( curr.val == p.val || curr.val == q.val ) count++ ;
        count = count + left + right ;
        if( count == 2 && ans == null ) {
            ans = curr ;
        }
        return count ;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse( root , p , q ) ;
        return ans ;
    }
}