package ds.arrays;

import java.util.Random;

/**
 * This problem can be divided into two sub problems.
 * First tranpose the array and then reverse each rows.
 * And we have our result.
 * @author Ayan
 *
 */
public class MatrixRotation {

	public static void main(String[] args) {
		
		int[][] mat = generateMatrix(4);
		print(mat);
		traspose(mat);
		invertRows(mat);
	    System.out.println("------");
	    print(mat);
	}

	private static void invertRows(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			int start = 0;
			int end = row.length -1;
			
			while (start < end) {
				int temp = row[start];
				row[start] = row[end];
				row[end] = temp;
				
				start++;
				end--;
			}
		}
	}

	private static void traspose(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				swap(matrix, i, j);
			}
		}
	}


	private static void swap(int[][] mat, int i, int j) {
		int temp = mat[i][j];
		mat[i][j] = mat[j][i];
		mat[j][i] = temp;

	}

	private static void print(int[][] mat) {

		for (int[] is : mat) {
			for (int is2 : is) {
				System.out.print(is2 + ", ");
			}
			System.out.println();
		}
	}

	private static int[][] generateMatrix(int N) {
		int[][] result = new int[N][N];
		for (int i = 0; i < N; i++) {

			for (int j = 0; j < N; j++) {

				result[i][j] = new Random().nextInt(10);
			}
		}
		return result;
	}
}
