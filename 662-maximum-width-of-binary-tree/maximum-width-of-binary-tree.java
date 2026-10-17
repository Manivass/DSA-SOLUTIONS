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
    public class Node {
        TreeNode node;
        int index;

        Node(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    int ans = 0;

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(root, 0));
        while (!q.isEmpty()) {
            int first = 0 ;
            int last = 0 ;
            int minIndex = q.peek().index;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node pair = q.poll();
                TreeNode curr = pair.node;
                int index = pair.index - minIndex ;
                if( i == 0 ) first = index ;
                if( i == size - 1 ) last = index ;
                if( curr.left != null ) {
                    q.offer( new Node( curr.left , 2 * index + 1 )) ;
                }
                if( curr.right != null ) q.offer( new Node( curr.right , 2 * index + 2 ) ) ;
            }
            ans = Math.max( ans , last - first + 1 ) ;
        }
        return ans ;
    }

}