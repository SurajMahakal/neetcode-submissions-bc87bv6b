class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. Build the Frequency Map (You already mastered this!)
        Map<Integer, Integer> numFreq = new HashMap<>();
        for (int num : nums) {
            numFreq.put(num, numFreq.getOrDefault(num, 0) + 1);
        }

        // 2. Create the Buckets Array
        // It's an array where each index holds a List of numbers.
        // Size is nums.length + 1 because the 0th index is for 0 frequency.
        List<Integer>[] buckets = new List[nums.length + 1];

        // 3. Fill the Buckets
        // Loop through your map's keys.
        for (int key : numFreq.keySet()) {
            int freq = numFreq.get(key);
            
            // NOTE: If the bucket at this frequency is null, initialize it first!
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            
            buckets[freq].add(key);
            // Add the 'key' (the number) to the correct frequency bucket
            // TODO: Write the one line of code here
        }

        // 4. Gather the Top K elements
        int[] result = new int[k];
        int counter = 0;
        
        // Loop backwards through the buckets (highest frequency to lowest)
        for (int i = buckets.length - 1; i >= 0 && counter < k; i--) {
            if (buckets[i] != null) {
                // Loop through the list of numbers inside this bucket
                for (int num : buckets[i]) {
                    result[counter] = num;
                    counter++;
                    // Optional SDE2 safety check: if (counter == k) return result;
                }
            }
        }
        
        return result;
    }
}