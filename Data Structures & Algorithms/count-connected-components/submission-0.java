class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int a = edge[0];
            int b = edge[1];

            adjList[a].add(b);
            adjList[b].add(a);
        }

        boolean[] visited = new boolean[n];
        Deque<Integer> que = new ArrayDeque<>();
        int componentCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                que.offer(i);
                visited[i] = true;
                componentCount++;

                while ( !que.isEmpty() ) {
                    int curr = que.poll();

                    for (int neighbor: adjList[curr]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            que.offer(neighbor);
                        }
                    }
                }
            }
        }
        return componentCount;
    }
}
