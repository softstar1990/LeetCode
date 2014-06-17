// Given a 2D board and a word, find if the word exists in the grid.
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
// For example,
// Given board =
// [
//   ["ABCE"],
//   ["SFCS"],
//   ["ADEE"]
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        if(row == 0 || col == 0) return false;
        if(word.length() == 0) return true;
        
        boolean[][] selected = new boolean[row][col];
        
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(dfs(board, selected, word.length(), word, i, j)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean[][] selected, int remain, String word, int row, int col){
        if(remain == 0) return true;    
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;      
        if(selected[row][col]) return false;
        
        int index = word.length() - remain;
        if(board[row][col] != word.charAt(index)) return false;
        
        selected[row][col] = true;
        boolean result = dfs(board, selected, remain-1, word, row-1, col) ||
                        dfs(board, selected, remain-1, word, row+1, col) ||
                        dfs(board, selected, remain-1, word, row, col-1) ||
                        dfs(board, selected, remain-1, word, row, col+1);
        selected[row][col] = false;
        
        return result;
    }
}