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
    int index = 0 ;
    public TreeNode traverse( int[] arr , int max ) {
        if( arr.length == index ) return null ;
        if( arr[index] > max ) return null ;
        TreeNode root = new TreeNode( arr[index] ) ;
        index++ ;
        root.left = traverse( arr , root.val ) ;
        root.right = traverse( arr, max ) ;
        return root ;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return traverse( preorder , Integer.MAX_VALUE ) ;
    }
}