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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>() ;
        List<List<Integer>> ans = new ArrayList<>() ;
        if( root == null ) return ans ;
        deque.addLast(root) ;
        int cnt = 0 ;
        while( !deque.isEmpty() ) {
            int size = deque.size() ;
            LinkedList<Integer> list = new LinkedList<>() ;
            for( int i = 0 ; i < size ; i++ ) {
                TreeNode curr = deque.removeFirst() ;
                if( cnt % 2 == 0 )  list.addLast(curr.val) ;
                else list.addFirst(curr.val) ;
                if( curr.left != null ) deque.addLast(curr.left) ;
                if( curr.right != null ) deque.addLast(curr.right) ;
            }
            cnt++ ;
            ans.add(list) ;
        }
        return ans ;
    }
}