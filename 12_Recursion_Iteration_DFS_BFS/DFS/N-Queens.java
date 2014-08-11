//The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
//such that no two queens attack each other.
//Given an integer n, return all distinct solutions to the n-queens puzzle.
//Each solution contains a distinct board configuration of the n-queens' placement, 
//where 'Q' and '.' both indicate a queen and an empty space respectively.
//For example,
//There exist two distinct solutions to the 4-queens puzzle:
//[
// [".Q..",  // Solution 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // Solution 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] item = new int[n];
        dfs(result,item,0,n);
        return result;
    }
    
    public void dfs(ArrayList<String[]> result, int[] item, int pos, int n){
        if(pos==n){ 
            printboard(result,item,n);
        }else{
            for(int i=0;i<n;i++){
                item[pos] = i;
                if(isValid(item,pos)) dfs(result,item,pos+1,n);
            }
        }
    }
    
    public boolean isValid(int[] item, int pos){
        for(int i=0;i<pos;i++){
            if(item[i]==item[pos]||Math.abs(item[i]-item[pos])==(pos-i)) return false;
        }
        return true;
    }
    
    public void printboard(ArrayList<String[]> result, int[] item, int n){
        String[] ans = new String[n];
        for(int i=0;i<n;i++){
            String row = new String();
            for(int j=0;j<n;j++){
                if(j==item[i]) row += "Q";
                else row += ".";
            }
            ans[i] = row;
        }
        result.add(ans);
    }
}