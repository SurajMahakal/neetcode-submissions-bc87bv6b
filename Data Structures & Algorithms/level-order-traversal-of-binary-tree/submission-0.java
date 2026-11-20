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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int len = que.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                TreeNode temp = que.poll();

                list.add(temp.val);

                if (temp.left != null) que.offer(temp.left);
                if (temp.right != null) que.offer(temp.right);
            }

            ans.add(list);
        }

        return ans;
    }
}
