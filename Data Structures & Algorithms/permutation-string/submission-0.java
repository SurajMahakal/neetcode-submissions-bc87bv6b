class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Map = new int[26];
        for(char c: s1.toCharArray()){
            int charIndex = c - 'a';
            s1Map[charIndex]++;
        }

        int[] s2Map = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s2Map[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Map,s2Map)) return true;

        for(int j = s1.length(); j < s2.length(); j++){
            s2Map[s2.charAt(j) - 'a']++;
            s2Map[s2.charAt(j - s1.length()) - 'a']--;
            if(Arrays.equals(s1Map,s2Map)) return true;
        }

        return false;
    }
}
