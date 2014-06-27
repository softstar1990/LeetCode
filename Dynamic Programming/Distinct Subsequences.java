//Given a string S and a string T, count the number of distinct subsequences of T in S.
//A subsequence of a string is a new string which is formed from the original string by 
//deleting some (can be none) of the characters without disturbing the relative positions 
//of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//Here is an example:
//S = "rabbbit", T = "rabbit"
//Return 3.
public class Solution {
    public int numDistinct(String S, String T) {
    	int[][] dp = new int[S.length() + 1][T.length() + 1];
     
    	for (int i = 0; i < S.length(); i++){
    		dp[i][0] = 1;
    	}
    	
    	for (int i = 1; i <= S.length(); i++) {
    		for (int j = 1; j <= T.length(); j++) {
    			if (S.charAt(i - 1) == T.charAt(j - 1)) {
    				dp[i][j] += dp[i - 1][j] + dp[i - 1][j - 1];
    			} else {
    				dp[i][j] += dp[i - 1][j];
    			}
    		}
    	}
     
    	return dp[S.length()][T.length()];
    }
}