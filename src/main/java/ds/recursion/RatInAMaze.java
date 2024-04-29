package ds.recursion;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0},
                {1, 1, 0},
                {1, 1, 1}
        };
        ratMaze(mat);
    }

    public static List<String> ratMaze(int [][]mat) {
        String moves = "";
        List<String> answer = new ArrayList<>();
        boolean[][] visited = new boolean[mat.length][mat.length];
        if (mat[0][0] == 1) {
            solve(mat, 0, 0, mat.length, mat.length, moves, answer, visited);
        }
        System.out.println(answer);
        return answer;
    }

    private static void solve(int[][] mat, int row, int col, int m, int n, String moves, List<String> answer, boolean[][] visited) {
        if (row == m-1 && col == n-1) {
            answer.add(moves);
            return;
        }
        // try all possible path which are possible - DLRU
        //Downward move check if possible
        if (row + 1 < m && mat[row + 1][col] != 0 && !visited[row + 1][col]) {
            visited[row ][col] = true;
            solve(mat, row+1, col, m, n, moves+ "D", answer, visited);
            visited[row ][col] = false;
        }
        //Left move check if possible
        if (col - 1 >= 0 && mat[row][col-1] != 0 && !visited[row ][col-1]) {
            visited[row][col] = true;
            solve(mat, row, col-1, m, n, moves + "L", answer, visited);
            visited[row][col] =  false;
        }
        //Right move check if possible
        if (col + 1 < n && mat[row][col+1] != 0 && !visited[row ][col+1]) {
            visited[row][col] = true;
            solve(mat, row, col+1, m, n, moves+"R", answer, visited);
            visited[row][col] =  false;
        }

        //Up move check if possible
        if (row - 1 >= 0 && mat[row-1][col] != 0 && !visited[row-1 ][col]) {
            visited[row][col] = true;
            solve(mat, row-1, col, m, n, moves+"U", answer, visited);
            visited[row][col] =  false;
        }

    }

}
