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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>() ;
        Deque<TreeNode> stack = new ArrayDeque<>() ;
        TreeNode lastVisited = null ;
        TreeNode curr = root ;
        while( curr != null || !stack.isEmpty() ) {
            while( curr != null ) {
                stack.push(curr);
                curr = curr.left ;
            }
            TreeNode top = stack.peek() ;
            if( top.right != null && lastVisited != top.right ) {
                curr = top.right ;
            }
            else {
                list.add(top.val) ;
                lastVisited = stack.pop() ;
            }
        }
        return list ;
    }
}