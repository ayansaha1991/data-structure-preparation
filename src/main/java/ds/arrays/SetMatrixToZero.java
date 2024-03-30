package ds.arrays;

public class SetMatrixToZero {

	public static void main(String[] args) {

		int[][] arr = {
				{1,1,1,1} ,
				{1,0,1,1 } ,
				{1,1, 0, 1} ,
				{0,0, 0, 1} ,
		};
		
		
		setZeroes(arr, 4, 4);
		print(arr, 4, 4);
	}

	public static int[][] setZeroes(int[][] matrix, int m, int n) {

		// row matrix matrix[0][] , col0 = 1
		// col matrix matrix[][0]
		
		int col0 = 1;

		// mark the matrix indicators with 0
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					if (j==0 ) {
						col0 = 0;
					} else {
						matrix[0][j] = 0;
					}

				}
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		
		
		if (matrix[0][0] == 0 ) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		
		if (col0 == 0) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
		
		return matrix;
	}
	
	public static void print(int[][] arr, int m, int n) {
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] +", ");
			}
			System.out.println();
		}
			
	}
}
