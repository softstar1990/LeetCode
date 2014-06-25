// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	//for each row
        for(int i = 0; i < 9; i++){
            HashSet<Character> test = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !test.add(board[i][j])) return false;
            }
        }
        //for each column
        for(int i = 0; i < 9; i++){
            HashSet<Character> test = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.' && !test.add(board[j][i])) return false;
            }
        }
        //for each sub-box
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                HashSet<Character> test = new HashSet();
                for(int k = 0; k < 9; k++){
                    int row = i*3 + k/3;
                    int col = j*3 + k%3;
                    if(board[row][col] != '.' && !test.add(board[row][col])) return false;
                }
            }
        }
        return true;
    }
}