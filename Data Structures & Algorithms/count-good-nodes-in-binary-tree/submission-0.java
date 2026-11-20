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
    public int goodNodes(TreeNode root) {
       return getCount(root, Integer.MIN_VALUE);
    }

    private int getCount(TreeNode root, int maxVal) {
        if (root == null) return 0;
        
        int isGood = (root.val >= maxVal) ? 1 : 0;
        int nextMax = Math.max(maxVal, root.val);

        int left = getCount(root.left, nextMax);
        int right = getCount(root.right, nextMax);

        return isGood + left + right;
    }
}
