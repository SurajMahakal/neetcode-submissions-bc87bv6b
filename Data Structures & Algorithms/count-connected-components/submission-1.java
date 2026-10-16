class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge: edges) {
            int rootA = find(edge[0], parent);
            int rootB = find(edge[1], parent);

            if (rootA != rootB) {
                parent[rootA] = rootB;
                components--;
            }
        }

        return components;
    }

    private int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }
}
