public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] t = new boolean[s.length()+1];
        t[0] = true; 
        
        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i]) continue;
 
            for(String word: dict){
                int len = word.length();
                int end = i + len;

                if(end > s.length()) continue;
                if(t[end]) continue;
                if(s.substring(i, end).equals(word)) t[end] = true;
            }
        }
 
        return t[s.length()];
    }
}