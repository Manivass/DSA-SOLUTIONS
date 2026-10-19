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
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(a,b)) ;
        Queue<TreeNode> q = new   ArrayDeque<>() ;
        q.offer(root) ;
        while( !q.isEmpty() ) {
            int size = q.size() ;
            for( int i = 0 ; i < size ; i++ ) {
                TreeNode curr = q.poll() ;
                pq.offer(curr.val) ;
                if( curr.left != null ) q.offer(curr.left) ;
                if( curr.right != null ) q.offer(curr.right) ;
            }
        }
        for( int i = 0 ; i < k - 1 ; i++ ) pq.poll() ;
        return pq.peek() ;
    }
}