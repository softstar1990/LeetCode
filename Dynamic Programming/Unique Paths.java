public class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0) return 0;
        if(m==1 || n==1) return 1;
        
        int[] paths = new int[m];
        for(int i = 0; i < m; i++){
            paths[i] = 1;
        }
        
        for(int i = 1; i < n; i++){
            int[] temp = new int[m];
            temp[0] = 1;
            
            for(int j = 1; j < m; j++){
                temp[j] = temp[j-1] + paths[j];
            }
            
            for(int j = 0; j<m; j++){
                paths[j] = temp[j];
            }
        }
        return paths[m-1];
    }
}

