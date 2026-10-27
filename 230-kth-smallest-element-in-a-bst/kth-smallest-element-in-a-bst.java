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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>() ;
        Queue<TreeNode> queue = new ArrayDeque<>() ;
        queue.offer(root) ;
        while( !queue.isEmpty() ) {
            int size = queue.size() ;
            for( int i = 0 ; i < size ; i++ ) {
                TreeNode curr = queue.poll() ;
                pq.offer(curr.val) ;
                if( curr.left != null ) queue.offer( curr.left ) ;
                if( curr.right != null ) queue.offer( curr.right ) ;
            }
        } 
        for( int i = 0 ; i < k - 1 ; i++ ) pq.poll() ;
        return pq.peek() ;
    }
}