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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int len = que.size();

            for (int i = 0; i < len; i++) {
                TreeNode temp = que.poll();

                if (i == len - 1) ans.add(temp.val);

                if (temp.left != null) que.offer(temp.left);
                if (temp.right != null) que.offer(temp.right);
            }
        }

        return ans;
    }
}
