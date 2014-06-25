public class Solution {
    private Queue<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        if (board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        // up row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
        }

        // bottom row
        for (int j = 0; j < col; j++) {
            if (board[row - 1][j] == 'O') {
                bfs(board, row - 1, j);
            }
        }

        // left column
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }

        // right column
        for (int i = 0; i < row; i++) {
            if (board[i][col - 1] == 'O') {
                bfs(board, i, col - 1);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    private void fill(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != 'O')
            return;

        queue.offer(i * col + j);
        board[i][j] = 'P';
    }

    private void bfs(char[][] board, int i, int j) {
        int col = board[0].length;

        fill(board, i, j);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / col;
            int y = cur % col;

            fill(board, x - 1, y);
            fill(board, x + 1, y);
            fill(board, x, y - 1);
            fill(board, x, y + 1);
        }
    }
}