//maybe not the best solution
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            if(!validRow(i, board)) return false;
        }
        
        for(int i = 0; i < 9; i++){
            if(!validCol(i, board)) return false;
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(!validSqr(i*3,j*3,board)) return false;
            }
        }
        
        return true;
    }
    
    public boolean validRow(int row, char[][] board){
        boolean[] check = new boolean[9];
        for(int i = 0; i < 9; i++){
            int num;
            if(board[row][i] != '.'){
                num = board[row][i]-'0';
                if(check[num-1]){
                    return false;
                }else{
                    check[num-1] = true;
                }
            }
        }
        return true;
    }
    
    public boolean validCol(int col, char[][] board){
        boolean[] check = new boolean[9];
        for(int i = 0; i < 9; i++){
            int num;
            if(board[i][col] != '.'){
                num = board[i][col] - '0';
                if(check[num-1]){
                    return false;
                }else{
                    check[num-1] = true;
                }
            }
        }
        return true;
    }
    
    public boolean validSqr(int row, int col, char[][] board){
        boolean[] check = new boolean[9];
        
        for(int i = row; i<row+3; i++){
            for(int j = col; j < col+3; j++){
                int num;
                if(board[i][j] != '.'){
                    num = board[i][j] - '0';
                    if(check[num-1]){
                        return false;
                    }else{
                        check[num-1] = true;
                    }
                }
            }
        }
        return true;
    }
}