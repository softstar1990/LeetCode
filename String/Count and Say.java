//The count-and-say sequence is the sequence of integers beginning as follows:
//1, 11, 21, 1211, 111221, ...
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth sequence.
//Note: The sequence of integers will be represented as a string.
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