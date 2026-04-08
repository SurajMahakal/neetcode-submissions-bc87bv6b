class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for(int num: nums){
            if(!hashSet.add(num)) return true;
        }

        return false;
    }
}