package ds.recursion;

import java.util.ArrayList;
import java.util.List;


public class NQueen {
    public static void main(String[] args) {
        nQueens(14);
    }

    public static List<List<List<String>>> nQueens(int n)   {
        String[][] board = createEmptyChessBoard(n);
        List<List<List<String>>> answer = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2*n-1];
        int[] upperDiagonal = new int[2*n-1];
        placeQueen(board, n, 0, answer, leftRow, lowerDiagonal, upperDiagonal);
        print(answer);
        return answer;
    }


    private static void placeQueen(String[][] board, int n, int col, List<List<List<String>>> ans, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        if (col == n) {
            addToAnswer(board, ans);
            return;
        }

        for (int row = 0; row < n; row++) {
            //safeToPlace(row, col, board)
            if (isSafeToPlaceOptimized(n, col, leftRow, lowerDiagonal, upperDiagonal, row)) {

                board[row][col] = "Q";
                // hash placement
                leftRow[row]= 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n-1+col-row] = 1;

                placeQueen(board, n, col + 1, ans, leftRow, lowerDiagonal, upperDiagonal);

                // hash removal of queen while backtracking
                board[row][col] = "_";
                leftRow[row]= 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n-1+col-row] = 0;
            }
        }
        
    }

    private static boolean isSafeToPlaceOptimized(int n, int col, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int row) {
        return leftRow[row] == 0 &&
                lowerDiagonal[row + col] == 0 &&
                upperDiagonal[n - 1 + col - row] == 0;
    }

    private static void addToAnswer(String[][] board, List<List<List<String>>> ans) {
        int ind = 0;
        List<List<String>> anserBoard = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < board.length; j++) {
                row.add(board[i][j])  ;
            }
            anserBoard.add(row);
        }
        ans.add(anserBoard);
    }

    private static void print(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean safeToPlace(int row, int col, String[][] board) {

        int tempRow = row;
        int tempCol = col;

        // upper diagonal check if any Queen available
        while (row >= 0 && col >= 0) {
            if (board[row][col] == "Q") {
                return false;
            }
            row--;
            col--;
        }
        row = tempRow;
        col = tempCol;
        // left straight line check if any Queen available
        while (col >= 0) {
            if (board[row][col] == "Q") {
                return false;
            }
            col--;
        }
        row = tempRow;
        col = tempCol;
        // lower diagonal check if any queen available
        while (row < board.length && col >= 0) {
            if (board[row][col] == "Q") {
                return false;
            }
            col--;
            row++;
        }

        return true;
    }

    private static String[][] createEmptyChessBoard(int n) {
        String[][] result = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = "_";
            }
        }
        return result;
    }

    private static void print(List<List<List<String>>> answer) {

        for (List<List<String>> board : answer) {
            for (List<String> row: board ) {
                System.out.println(row);
            }
            System.out.println("----------------");
        }

    }
}
