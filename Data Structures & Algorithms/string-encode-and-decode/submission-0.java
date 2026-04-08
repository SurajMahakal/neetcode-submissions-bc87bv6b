class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            int len = str.length();
            sb.append(len);
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();

        int pointer = 0;
        while(pointer < str.length()){
            int j = pointer;
            while(str.charAt(j)!= '#') j++;
            int length = Integer.parseInt(str.substring(pointer, j));
            pointer = j + 1;
            ans.add(str.substring(pointer, pointer + length));
            pointer = pointer + length;
        }

        return ans;
    }
}
