//Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//If the last word does not exist, return 0.
//Note: A word is defined as a character sequence consists of non-space characters only.
//For example, 
//Given s = "Hello World",
//return 5.
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) return 0;
        
        int end;
        for(end = s.length()-1; end >= 0; end--){
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
