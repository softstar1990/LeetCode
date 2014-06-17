// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rule1, column
        for(int i=0; i<board[0].length; i++){
            HashSet<Character> test = new HashSet<Character>();
            for(int j=0; j<board.length; j++){
                if(board[j][i]!='.' && !test.add(board[j][i])) return false;
            }
        }
        
        // rule2, row
        for(int i=0; i<board.length; i++){
            HashSet<Character> test = new HashSet<Character>();
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]!='.' && !test.add(board[i][j])) return false;
            }
        }   
        
        // rule3, sub-box
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){// for each sub-box
                HashSet<Character> test = new HashSet<Character>();
                for(int m=i*3; m<i*3+3; m++){//row
                    for(int n=j*3; n<j*3+3; n++){//column
                        if(board[m][n]!='.' && !test.add(board[m][n])) return false;
                    }
                }
            }
        }
        
        return true;
    }
}