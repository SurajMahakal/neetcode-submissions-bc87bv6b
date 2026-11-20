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
    public boolean isValidBST(TreeNode root) {

        return isValid(root.left, Integer.MIN_VALUE, root.val) && isValid(root.right, root.val, Integer.MAX_VALUE);

    }

    private boolean isValid(TreeNode root, int leftBound, int rightBound) {
        if (root == null) return true;

        if (root.val <= leftBound || root.val >= rightBound) {
            return false;
        }

        return isValid(root.left, leftBound, root.val) && isValid(root.right, root.val, rightBound);
    }
}
