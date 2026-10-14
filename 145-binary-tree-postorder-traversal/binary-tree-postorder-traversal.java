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
    List<Integer> ans = new ArrayList<>() ;
    public void postOrder( TreeNode curr ) {
        if( curr == null ) return ;
        if( curr.left != null ) postOrder( curr.left ) ;
        if( curr.right != null ) postOrder( curr.right ) ;
        ans.add(curr.val) ;
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder( root ) ;
        return ans ;
    }
}