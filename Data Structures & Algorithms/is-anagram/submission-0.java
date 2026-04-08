class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freqMap = new int[26];
        for(int i = 0; i < s.length(); i++){
            freqMap[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            freqMap[t.charAt(i) - 'a']--;
        }

        for(int i: freqMap){
            if(i != 0) return false;
        }

        return true;
    }
}
