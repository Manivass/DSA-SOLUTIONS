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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        String rootval = seralization(root) ;
        String subval = seralization(subRoot) ;
        return rootval.contains(subval) ;
    }
    public String seralization( TreeNode curr ) {
        if( curr == null ) return "_#" ;
        return "_" +curr.val+ seralization( curr.left ) + seralization(curr.right) ;
    }
}