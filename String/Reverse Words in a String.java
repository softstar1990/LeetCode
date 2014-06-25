public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] words = s.split("\\s+"); //use regex, otherwise we need to trim() each element int words[]
        if(words.length == 0) return "";
        
        StringBuffer sb = new StringBuffer();
        
        for(int i = words.length-1; i >= 0; i--){
            sb.append(words[i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }
}