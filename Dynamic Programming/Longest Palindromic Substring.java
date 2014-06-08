public class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty()) return "";
        int len = s.length();
        if(len == 1) return s;
        if(len == 2){
            if(s.charAt(0) == s.charAt(1)) return s;
            return s.substring(0,1);
        }
        
        //init the matrix for DP
        boolean[][] curr = new boolean[len][len];
        for(int i = 0; i < len; i++){
            curr[0][i] = true;
        }
        for(int i = 0; i < len-1; i++){
            curr[1][i] = (s.charAt(i) == s.charAt(i+1));
        }
        
        //main part of DP
        for(int i = 2; i < len; i++){
            for(int j = 0; j < len - i; j++){
                curr[i][j] = (s.charAt(j) == s.charAt(j+i) && curr[i-2][j+1]);
            }
        }
        
        int row = len - 1;
        int col = 0;
        for(row = len -1; row >= 0 ;row--){
            boolean flag = false;
            for(col = 0; col < len; col++){
                if(curr[row][col]){
                    flag = true;                
                    break;
                }
            }
            if(flag) break;
        }
        
        return s.substring(col,row+col+1);
    }
}
