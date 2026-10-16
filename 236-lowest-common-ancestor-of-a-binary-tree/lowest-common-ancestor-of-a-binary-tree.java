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
        int leftSub = traverse( curr.left , p , q ) ;
        int rightSub = traverse( curr.right , p , q ) ;
        if( curr.val == p.val || curr.val == q.val ) count++ ;
        count = count + leftSub + rightSub ;
        if( count == 2 && ans == null ) {
            ans = curr ;
            return ans.val ;
        }   
        return count ;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse( root , p , q ) ;
        return ans ;
    }
}