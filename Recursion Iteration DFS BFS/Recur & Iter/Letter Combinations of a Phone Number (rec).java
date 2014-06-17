// Given a digit string, return all possible letter combinations that the number could represent.
// A mapping of digit to letters (just like on the telephone buttons) is given below.

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.
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