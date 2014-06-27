//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
//(each operation is counted as 1 step.)
//You have the following 3 operations permitted on a word:
//a) Insert a character
//b) Delete a character
//c) Replace a character
public class Solution {
    public int minDistance(String word1, String word2) {
    	int len1 = word1.length();
    	int len2 = word2.length();
     
    	// len1+1, len2+1, because finally return dp[len1][len2]
    	int[][] dp = new int[len1 + 1][len2 + 1];
     
    	for (int i = 0; i <= len1; i++) {
    		dp[i][0] = i;
    	}
     
    	for (int j = 0; j <= len2; j++) {
    		dp[0][j] = j;
    	}
     
    	//iterate though, and check last char
    	for (int i = 0; i < len1; i++) {
    		for (int j = 0; j < len2; j++) {
    			char c1 = word1.charAt(i);
    			char c2 = word2.charAt(j);
     
    			//if last two chars equal
    			if (c1 == c2) {
    				//update dp value for +1 length
    				dp[i + 1][j + 1] = dp[i][j];
    			} else {
    				int replace = dp[i][j] + 1;
    				int delete = dp[i][j + 1] + 1;
    				int insert = dp[i + 1][j] + 1;
     
    				int min = Math.min(replace, Math.min(insert, delete));
    				dp[i + 1][j + 1] = min;
    			}
    		}
    	}
     
    	return dp[len1][len2];
    }
}