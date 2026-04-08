class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
    long distA = (long)a[0]*a[0] + (long)a[1]*a[1];
    long distB = (long)b[0]*b[0] + (long)b[1]*b[1];
    return Long.compare(distB, distA);
});

        for(int point[]: points){
            maxHeap.add(point);
             if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++){
            ans[i] = maxHeap.poll();
        }
    
        return ans;
    }
}
