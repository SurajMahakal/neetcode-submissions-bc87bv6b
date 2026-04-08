class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> groupMap = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];

            for(char c: str.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i: count){
                sb.append(i);
                sb.append("#");
            }
            String key = sb.toString();

            groupMap.computeIfAbsent(key, k -> new ArrayList<>());
            groupMap.get(key).add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
}
