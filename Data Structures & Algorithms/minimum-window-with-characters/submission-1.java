class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        int[] tCount = new int[128];
        int[] sCount = new int[128];
        int requiredFreq = 0;

        for (int ch : t.toCharArray()) {
            if (tCount[ch] == 0) {
                requiredFreq++;
            }
            tCount[ch]++;
        }

        int left = 0;
        int currFreq = 0;
        int minLen = Integer.MAX_VALUE;
        int shortLeft = 0;
        int shortRight = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            sCount[rightChar]++;

            if (tCount[rightChar] > 0 && sCount[rightChar] == tCount[rightChar]) {
                currFreq++;
            }

            while (currFreq == requiredFreq) {
                int currLen = right - left + 1;

                if (currLen < minLen) {
                    minLen = currLen;
                    shortLeft = left;
                    shortRight = right;
                }

                char leftChar = s.charAt(left);
                sCount[leftChar]--;

                if (tCount[leftChar] > 0 && sCount[leftChar] < tCount[leftChar]) {
                    currFreq--;
                }
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(shortLeft, shortRight + 1);
    }
}
