public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<0)
            return null;
        int[][] res = new int[n][n];
        int levelNum = n/2;
        int num = 1;
        for(int l=0;l<levelNum;l++)
        {
            for(int i=l;i<n-l;i++)
            {
                res[l][i] = num++;
            }
            for(int i=l+1;i<n-l;i++)
            {
                res[i][n-1-l] = num++;
            }
            for(int i=n-2-l;i>=l;i--)
            {
                res[n-1-l][i] = num++;
            }
            for(int i=n-2-l;i>l;i--)
            {
                res[i][l] = num++;
            }
        }
        if(n%2==1)
        {
            res[levelNum][levelNum] = num;
        }
        return res;
    }
}