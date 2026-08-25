class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxFreq = 0;

        for (int runner = 0; runner < s.length(); runner++) {
            count[s.charAt(runner) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(runner) - 'A']);
            
            if ((runner - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return s.length() - left;
    }
}
