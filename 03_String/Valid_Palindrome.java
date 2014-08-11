//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//For example,
//"A man, a plan, a canal: Panama" is a palindrome.
//"race a car" is not a palindrome.
//Note:
//Have you consider that the string might be empty? This is a good question to ask during an interview.
//For the purpose of this problem, we define empty string as valid palindrome.
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() <= 1) return true;
        int start = 0, end = s.length()-1;
        s = s.toLowerCase();
        
        while(start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))){
                start++;
            }
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))){
                end--;
            }
            
            char c1 = s.charAt(start);
            char c2 = s.charAt(end);
            if(c1 != c2) return false;
            start++;
            end--;
        }
        
        return true;
    }
}