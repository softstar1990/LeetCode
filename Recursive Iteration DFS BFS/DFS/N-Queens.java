public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] loc = new int[n];
        dfs(result,loc,0,n);
        return result;
    }
    
    public void dfs(ArrayList<String[]> result, int[] loc, int cur, int n){
        if(cur==n) 
            printboard(result,loc,n);
        else{
            for(int i=0;i<n;i++){
                loc[cur] = i;
                if(isValid(loc,cur)){
                    dfs(result,loc,cur+1,n);
                }
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
    
    public void printboard(ArrayList<String[]> result, int[] loc, int n){
        String[] ans = new String[n];
        for(int i=0;i<n;i++){
            String row = new String();
            for(int j=0;j<n;j++){
                if(j==loc[i]) row += "Q";
                else row += ".";
            }
            ans[i] = row;
        }
        result.add(ans);
    }
}