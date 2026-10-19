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
    public TreeNode traverse( List<Integer> list , int left , int right ) {
        if( left > right ) return null ;
        if( right - left == 0 ) return new TreeNode(list.get(left)) ;
        int mid = (int)Math.floor( ( left + right ) / 2 ) ;
        TreeNode curr = new TreeNode(list.get(mid)) ;
        curr.left = traverse( list , left , mid - 1 ) ;
        curr.right = traverse( list , mid + 1 , right ) ;
        return curr ;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>() ;
        Queue<TreeNode> q = new ArrayDeque<>() ;
        q.offer( root ) ;
        while( !q.isEmpty() ) {
            int size = q.size() ;
            for( int i = 0 ; i < size ; i++ ) {
                TreeNode curr = q.poll() ;
                list.add( curr.val ) ;
                if( curr.left != null ) q.offer(curr.left) ;
                if( curr.right != null ) q.offer(curr.right) ;
            }
        }
        list.sort(null) ;
        TreeNode ans = traverse( list , 0 , list.size() - 1) ;
        return ans ;
    }
}