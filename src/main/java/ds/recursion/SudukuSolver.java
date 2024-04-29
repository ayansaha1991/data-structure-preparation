package ds.recursion;


public class SudukuSolver {
    public static void main(String[] args) {
        int[][] board = {
                { 1, 2, 3},
                { 3, 0, 9},
                { 3, 0, 9}
        };
        sudokuSolver(board);
    }

    public static boolean sudokuSolver(int board[][]){
        
        // try all numbers 1-9 on all empty cells
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k <= 9 ; k++) {
                        if (isValid(i, j, k, board)) {
                            board[i][j] = k;
                            if (sudokuSolver(board)) {
                                return true;
                            } else {
                                board[i][j] = 0;
                            }
                        }
                    }
                    // return false if we can't place any number 1-9 in current setup
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean isValid(int row, int col, int item, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            // check same row if contains same number
            if (board[row][i] == item) {
                return false;
            }
            // check same column if contains same number
            if (board[i][col] == item) {
                return false;
            }
            // check same 3*3 board if it has same number
            if (board[ 3 * (row / 3)  + i / 3][ 3 * (col / 3)  + i % 3] == item) {
                return false;
            }
        }
        return true;
    }
}
