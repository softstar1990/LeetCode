// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() <= 1) return true;
        
        int start = 0;
        int end = s.length() - 1;
        
        while(start < end){
            while(start < s.length() && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(end >= 0 && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            if(start >= end) break;
            
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if(Character.isLowerCase(c1)) c1 = Character.toUpperCase(c1);
            if(Character.isLowerCase(c2)) c2 = Character.toUpperCase(c2);
            if(c1 != c2) return false;
            start++;
            end--;
        }
        
        return true;
    }
}