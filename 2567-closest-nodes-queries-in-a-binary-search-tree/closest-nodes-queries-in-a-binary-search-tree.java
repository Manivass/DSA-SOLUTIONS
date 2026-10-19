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
    public int findSmaller( List<Integer> num , int t) {
        int l = 0 ;
        int r = num.size() - 1 ;
        int ans = -1 ;
        while( l <= r ) {
            int m = l + ( r - l ) / 2 ;
            if( num.get(m) <= t ) {
                ans = num.get(m) ;
                l = m + 1 ;
            }
            else r = m -1 ;
        }
        return ans ;
    }
    public int findGreater( List<Integer> num , int t ) {
        int l = 0 ;
        int r = num.size() - 1 ;
        int ans = -1 ;
        while( l <= r ) {
            int m = l + ( r - l ) / 2 ;
            if( num.get(m) >= t ) {
                ans = num.get(m) ;
                r = m - 1 ;
            }
            else l = m + 1 ;
        }
        return ans ;
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> num = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                num.add(curr.val);
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
        num.sort(null);
        System.out.println(num) ;
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> list = new ArrayList<>() ;
            list.add(findSmaller(num, queries.get(i) )) ;
            list.add(findGreater(num, queries.get(i))) ;
            ans.add( new ArrayList<>(list)) ;
        }
        return ans;
    }
}