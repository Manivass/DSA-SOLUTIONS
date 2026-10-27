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
    public int getMin(TreeNode curr) {
        while (curr.left != null)
            curr = curr.left;
        return curr.val;
    }

    public TreeNode traverse(TreeNode curr, int val) {
        if (curr == null)
            return null;
        if (curr.val < val) {
            curr.right = traverse(curr.right, val);
        } else if (curr.val > val) {
            curr.left = traverse(curr.left, val);
        } else {
            if (curr.left == null)
                return curr.right;
            if (curr.right == null)
                return curr.left;
            int min = getMin(curr.right);
            curr.val = min;
            curr.right = traverse(curr.right, min);
        }
        return curr ;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return traverse(root, key);
    }
}