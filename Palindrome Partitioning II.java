public class Solution {
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s.length()==0) return 0; 
        int [] dp=new int [s.length()+1];
        for(int i=s.length(); i>=0; i--)
        {
            dp[i]=s.length()-i;
        }
        boolean [][]palindrome=new boolean [s.length()][s.length()];
        for(int i=s.length()-1; i>=0 ; i--)
        {
            for(int j=i; j<s.length(); j++)
            {
                if(s.charAt(i)==s.charAt(j) && (j-i<2|| palindrome[i+1][j-1]))
                {
                    palindrome[i][j]=true;
                    dp[i]=Math.min(dp[i], 1+dp[j+1]);
                }
            }
        }
        return dp[0]-1;
    }
}
