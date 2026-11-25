class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        setSubsets(nums, ans, temp, 0);

        return ans;
    }

    private void setSubsets(int[] nums, List<List<Integer>> ans, List<Integer> temp, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        setSubsets(nums, ans, temp, index + 1);

        temp.remove(temp.size() - 1);
        setSubsets(nums, ans, temp, index + 1);
    }
}
