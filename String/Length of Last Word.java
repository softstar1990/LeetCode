public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if(len == 0) return 0;
        
        int end;
        for(end = len-1; end >= 0; end--){
            if(s.charAt(end) != ' ') break;
        }
        if(end < 0) return 0;
        
        int start;
        for(start = end-1; start>= 0; start--){
            if(s.charAt(start) == ' ') break;
        }
        
        return end-start;
    }
}
