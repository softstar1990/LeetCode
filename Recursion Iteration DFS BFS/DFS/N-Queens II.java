public class Solution {
    int result; //notice result is global
    public int totalNQueens(int n) {
        result = 0;
        if(n<=0) return result;
        int[] loc = new int[n];
        dfs(loc,0,n);
        return result;
    }
    
    public void dfs(int[] loc, int cur, int n){
        if (cur==n) {
            result+=1;
            return;
        }
        for(int i=0;i<n;i++){
            loc[cur] = i;
            if(isValid(loc,cur)){
                dfs(loc,cur+1,n);
            }
        }
    }
    
    public boolean isValid(int[] loc, int cur){
        for(int i=0;i<cur;i++){
            if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==(cur-i))
                return false;
        }
        return true;
    }
}