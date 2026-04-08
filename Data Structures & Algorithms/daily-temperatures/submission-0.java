class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            int currentTemp = temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] < currentTemp){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
