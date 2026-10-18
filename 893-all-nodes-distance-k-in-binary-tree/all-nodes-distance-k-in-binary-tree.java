/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode  , TreeNode> parent = new HashMap<>() ;
    public void dfs( TreeNode curr ) {
        if( curr.left != null ) {
            parent.put(curr.left , curr) ;
            dfs( curr.left ) ;
        }
        if( curr.right != null ) {
            parent.put( curr.right , curr ) ;
            dfs( curr.right ) ;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs( root ) ;
        Queue<TreeNode> q = new ArrayDeque<>() ;
        q.offer(target) ;
        HashSet<TreeNode> visited = new HashSet<>() ;
        visited.add(target) ;
        int dist = 0 ;
        while( !q.isEmpty() ) {
            int size = q.size() ;
            if( dist == k ) break ;
            for( int i = 0 ; i < size ; i++ ) {
                TreeNode curr = q.poll() ;
                if( curr.left != null && !visited.contains(curr.left) ) {
                    q.offer(curr.left) ;
                    visited.add(curr.left) ;
                }
                if( curr.right != null && !visited.contains(curr.right) ) {
                    q.offer(curr.right) ;
                    visited.add(curr.right) ;
                }
                if( parent.containsKey(curr) && !visited.contains(parent.get(curr)) ) {
                    visited.add(parent.get(curr)) ;
                    q.offer(parent.get(curr)) ;
                }
            }
            dist++ ;
        }
        List<Integer> ans = new ArrayList<>() ;
        while( !q.isEmpty() ) {
            ans.add(q.poll().val) ;
        }
        return ans ;
    }
}