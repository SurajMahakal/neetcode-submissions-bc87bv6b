class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int leftProduct = 1;
        ans[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            leftProduct *= nums[i - 1];
            ans[i] = leftProduct;
        }

        int rightProduct = 1;
        for(int j = nums.length - 1; j >= 0; j--) {
            ans[j] = ans[j] * rightProduct;
            rightProduct *= nums[j];
        }

        return ans;
    }
}  
