class Solution {
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> numFreq = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            numFreq.put(nums[i], numFreq.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a,b) -> numFreq.get(a) - numFreq.get(b)
        );

        for(int num: numFreq.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }

        return result;
    }
}
