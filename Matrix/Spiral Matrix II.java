// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
// For example,
// Given n = 3,
// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<0) return null;
        int[][] result = new int[n][n];
        int circle = n/2;
        int num = 1;
        
        for(int c=0;c<circle;c++){
            for(int i=c;i<n-1-c;i++){
                result[c][i] = num++;//go to right
            }
            //
            for(int i=c;i<n-1-c;i++){
                result[i][n-1-c] = num++;//go to bottom
            }
            for(int i=c;i<n-1-c;i++){
                result[n-1-c][n-1-i] = num++;//go to left
            }
            for(int i=c;i<n-1-c;i++){
                result[n-1-i][c] = num++;//go to top
            }
        }

        if(n%2==1) result[circle][circle] = num;
        
        return result;
    }
}