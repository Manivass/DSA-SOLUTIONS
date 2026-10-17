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
    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(TreeNode curr, int t, List<Integer> list) {
        if (curr.left == null && curr.right == null && t == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if( curr.left == null && curr.right == null ) return ;
        if (curr.left != null) {
            list.add(curr.left.val);
            dfs(curr.left, t - curr.left.val, list);
            list.remove(list.size() - 1);
        }
        if (curr.right != null) {
            list.add(curr.right.val);
            dfs(curr.right, t - curr.right.val, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return ans;
        list.add(root.val);
        dfs(root, target - root.val, list);
        return ans ;
    }
}