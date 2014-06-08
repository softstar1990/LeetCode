public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m == 0 || n == 0) return 0;

        int[] paths = new int[m];
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 1) break;
            paths[i] = 1;
        }
        
        for(int i = 1; i < n; i++){
            int[] temp = new int[m];
            if(obstacleGrid[0][i] == 0 && paths[0] == 1) temp[0] = 1;
            
            for(int j = 1; j < m; j++){
                if(obstacleGrid[j][i] == 0) temp[j] = temp[j-1] + paths[j];
            }
            
            for(int j = 0; j<m; j++){
                paths[j] = temp[j];
            }
        }
        return paths[m-1];
    }
}
