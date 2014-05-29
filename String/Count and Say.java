public class Solution {
    public String countAndSay(int n) {
        if(n == 0) return "";
        String s = "1";
        if(n == 1) return s;
        while(n > 1){
            s = getNext(s);
            n--;
        }
        return s;
    }
    
    public String getNext(String s){
        StringBuffer ss = new StringBuffer();
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(i == 0 || s.charAt(i) == s.charAt(i-1)){
                count++;
            }else{
                ss.append(count);
                ss.append(s.charAt(i-1));
                count = 1;
            }
        }
        ss.append(count);
        ss.append(s.charAt(s.length()-1));

        return ss.toString();
    }
}