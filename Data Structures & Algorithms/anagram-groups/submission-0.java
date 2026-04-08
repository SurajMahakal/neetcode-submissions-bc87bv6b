class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> groupMap = new HashMap<>();

        for(String str: strs){
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String key = String.valueOf(letters);

            groupMap.computeIfAbsent(key, k -> new ArrayList<>());
            groupMap.get(key).add(str);
        }
        return new ArrayList<>(groupMap.values());
    }
}
