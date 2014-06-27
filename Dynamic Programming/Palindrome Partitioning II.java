//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return the minimum cuts needed for a palindrome partitioning of s.
//For example, given s = "aab",
//Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
public class Solution {
    public int minCut(String s) {
        if(s.length()==0) return 0; 
        //init for dp
        int [] dp = new int [s.length()+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = i;
        }

        boolean[][] palindrome = new boolean[s.length()][s.length()];

        for(int i=0; i<s.length() ; i++){
            for(int j=i; j>=0; j--){
                if(s.charAt(i)==s.charAt(j) && (i-j<2|| palindrome[j+1][i-1])){
                    palindrome[j][i]=true;
                    dp[i+1]=Math.min(dp[i+1], 1+dp[j]);
                }
            }
        }
        return dp[s.length()]-1;
    }
}
