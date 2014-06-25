//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//For example, given n = 3, a solution set is:
//"((()))", "(()())", "(())()", "()(())", "()()()"
public class Solution {
    public static ArrayList<String> generateParenthesis(int n) {  
        ArrayList<String> result = new ArrayList<String>();  
        dfs(n, 0, 0, "", result);  
        return result;  
    }  
      
    public static void dfs(int n, int left, int right, String s, ArrayList<String> result){  
        if(left < right){  
            return;  
        }  
          
        if(left==n && right==n){  
            result.add(s);  
            return;  
        }  
          
        if(left == n){  
            dfs(n, left, right+1, s+")", result);  
            return;  
        }  
          
        dfs(n, left+1, right, s+"(", result);   
        dfs(n, left, right+1, s+")", result);   
    }  
}