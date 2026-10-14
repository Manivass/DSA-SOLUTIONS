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
        Deque<Integer> s1 = new ArrayDeque<>() ;
        Deque<TreeNode> s2 = new ArrayDeque<>() ;
        List<Integer> list = new ArrayList<>() ;
        if( root == null ) return list ;
        s2.push( root ) ;
        while( !s2.isEmpty() ) {
            TreeNode curr = s2.pop() ;
            s1.push(curr.val) ;
            if( curr.left != null ) s2.push( curr.left ) ;
            if( curr.right != null ) s2.push( curr.right ) ;
        }
        int k = s1.size() ;
        for( int i = 0 ; i < k ; i++ ) {
            list.add(s1.pop()) ;
        }
        return list ;
    }
}