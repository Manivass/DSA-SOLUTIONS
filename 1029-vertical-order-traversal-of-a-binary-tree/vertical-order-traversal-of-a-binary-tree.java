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
        int val ;
        int row ;
        int col ;
        Node( int val , int row , int col ) {
            this.val = val ;
            this.row = row ;
            this.col = col ;
        }
    }
    List<Node> nodes = new ArrayList<>() ;
    public void dfs( TreeNode curr , int row , int col ) {
        if( curr == null ) return ;
        nodes.add( new Node( curr.val , row , col ) ) ;
        if( curr.left != null ) dfs( curr.left , row + 1 , col - 1 ) ;
        if( curr.right != null ) dfs( curr.right , row + 1 , col + 1 ) ;
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs( root , 0 , 0 ) ;
        List<List<Integer>> ans = new ArrayList<>() ;
        Collections.sort( nodes , ( a , b ) -> {
            if( a.col != b.col ) return a.col - b.col ;
            if( a.row != b.row ) return a.row - b.row ;
            return a.val - b.val ;
        } ) ;
        int prevCol = Integer.MIN_VALUE ;
        for( Node node : nodes ) {
            if( node.col != prevCol ) {
                ans.add( new ArrayList<>() ) ;
                prevCol = node.col ;
            }
            ans.get(ans.size() - 1).add(node.val) ;
        }
        return ans ;
    }
}