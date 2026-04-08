class Solution {
    public boolean isPalindrome(String s) {
        int startPointer = 0;
        int endPointer = s.length() - 1;

        while(startPointer < endPointer){
            while(startPointer < endPointer && !Character.isLetterOrDigit(s.charAt(startPointer))) startPointer++;
            while(startPointer < endPointer && !Character.isLetterOrDigit(s.charAt(endPointer))) endPointer--;

            if(Character.toLowerCase(s.charAt(startPointer)) != Character.toLowerCase(s.charAt(endPointer))) return false;
            startPointer++;
            endPointer--;
        }

        return true;
    }
}
