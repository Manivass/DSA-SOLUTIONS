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
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>() ;
        TreeNode curr = root ;
        List<Integer> list = new ArrayList<>() ;
        if( curr == null ) return list ;
        while( !stack.isEmpty() || curr != null ) {
            while( curr!= null ) {
                stack.push(curr);
                curr = curr.left ;
            }
            curr = stack.pop() ;
            list.add(curr.val) ;
            curr = curr.right ; 
        }
        return list ;
    }
}