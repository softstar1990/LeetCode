// Follow up for N-Queens problem.
// Now, instead outputting board configurations, return the total number of distinct solutions.
public class Solution {
    public int totalNQueens(int n) {
        int[] result = {0};
        if(n<=0) return result[0];
        int[] item = new int[n];
        dfs(item,0,n,result);
        return result[0];
    }
    
    public void dfs(int[] item, int pos, int n, int[] result){
        if (pos==n) {
            result[0]+=1;
            return;
        }
        for(int i=0;i<n;i++){
            item[pos] = i;
            if(isValid(item,pos)){
                dfs(item,pos+1,n,result);
            }
        }
    }
    
    public boolean isValid(int[] item, int pos){
        for(int i=0;i<pos;i++){
            if(item[i]==item[pos]||Math.abs(item[i]-item[pos])==(pos-i)) return false;
        }
        return true;
    }
}