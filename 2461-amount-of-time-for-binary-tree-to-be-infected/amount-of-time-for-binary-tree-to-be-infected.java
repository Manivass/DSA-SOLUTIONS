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
    HashMap<TreeNode, TreeNode> parent = new HashMap<>();

    public void dfs(TreeNode curr) {
        if (curr.left != null) {
            parent.put(curr.left, curr);
            dfs(curr.left);
        }
        if (curr.right != null) {
            parent.put(curr.right, curr);
            dfs(curr.right);
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        dfs(root);
        Queue<TreeNode> q = new ArrayDeque<>();
        HashSet<TreeNode> visited = new HashSet<>();
        TreeNode st = null;
        TreeNode temp = root;
        q.offer(temp);
        boolean isFound = false;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == start) {
                    st = curr;
                    isFound = true;
                    break;
                }
                if( curr.left != null ) {
                    q.offer(curr.left) ;
                }
                if( curr.right != null ) q.offer(curr.right) ;
            }
            if (isFound)
                break;
        }
        q.clear();
        q.offer(st);
        visited.add(st) ;
        int dist = 0 ;
        while( !q.isEmpty() ) {
            int size = q.size() ;
            dist++ ;
            for( int i = 0 ; i < size ; i++ ) {
                TreeNode curr = q.poll() ;
                if( curr.left != null && !visited.contains( curr.left ) ) {
                    visited.add(curr.left) ;
                    q.offer( curr.left ) ;
                }
                if( curr.right != null && !visited.contains(curr.right) ) {
                    visited.add( curr.right ) ;
                    q.offer( curr.right ) ;
                }
                if( parent.containsKey(curr) && !visited.contains( parent.get(curr) ) ) {
                    visited.add(parent.get(curr)) ;
                    q.offer( parent.get(curr) ) ;
                }
            }
        }
        return dist - 1 ;
    }
}