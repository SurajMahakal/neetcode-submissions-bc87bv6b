class Solution {
    public int trap(int[] height) {
        int left = 0;
        int leftMax = 0;
        int right = height.length - 1;
        int rightMax = 0;
        int totalWater = 0;

        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax < rightMax) {
                totalWater += leftMax - height[left];
                left++;
            } else {
                totalWater += rightMax - height[right];
                right--;
            }
        }

        return totalWater;
    }
}
