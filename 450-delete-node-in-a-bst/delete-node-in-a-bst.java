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
    public int getMin( TreeNode node ) {
        while( node.left != null )  node = node.left ;
        return node.val ;
    }
    public TreeNode traverse( TreeNode curr , int val ) {
        if( curr == null ) return null ;
        if( curr.val < val ) {
            curr.right = traverse( curr.right , val ) ;
        }
        else if( curr.val > val ) {
            curr.left = traverse( curr.left , val ) ;
        }
        else {
            if( curr.left == null ) return curr.right ;
            if( curr.right == null ) return curr.left ;
            int min = getMin( curr.right ) ;
            curr.val = min ;
            curr.right = traverse( curr.right , curr.val ) ;
        }
        return curr ;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return traverse( root , key ) ;
    }
}