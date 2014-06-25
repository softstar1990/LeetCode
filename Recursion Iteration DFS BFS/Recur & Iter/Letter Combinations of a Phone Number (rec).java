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
        
        rec(result, new StringBuffer(), 0, ss, digits);
        return result;
    }
    
    public void rec(ArrayList<String> result, StringBuffer item, int pos, String[] ss, String digits ){
        if(pos == digits.length()){
            result.add(item.toString());
            return;
        }        
        String s = ss[digits.charAt(pos)-'0'];        
        for(int i=0; i<s.length(); i++){  
            item = item.append(s.charAt(i));  
            rec(result, item, pos+1, ss, digits);  
            item.deleteCharAt(item.length()-1); 
        }
    }
}