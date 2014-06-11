public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] ss = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ArrayList<String> result = new ArrayList<String>();
        
        rec(result, digits.length(), ss, digits, new StringBuffer());
        return result;
    }
    
    public void rec(ArrayList<String> result, int remain, String[] ss, String digits, StringBuffer sb ){
        if(remain == 0){
            result.add(sb.toString());
            return;
        }
        
        String s = ss[digits.charAt(0)-'0'];        

        for(int i=0; i<s.length(); i++){  
            sb = sb.append(s.charAt(i));  
            rec(result, remain-1, ss, digits.substring(1), sb);  
            sb.deleteCharAt(sb.length()-1); 
        }
    }
}