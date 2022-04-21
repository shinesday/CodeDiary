public class RotateDiagonal {
  public static void rotateDiagonal(int[][] matrix, int k) {
    int n = matrix.length;

    for(int s = 0; s < k; s++) {
      // rotate
      for(int i = 0; i < n; i++) {
        for(int j = i + 1; j < n; j++) {
          if(i != j && i + j != n - 1) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
          }
        }
      }

      // fanzhuan
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n/2; j++) {
          if(i != j && i + j != n - 1) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[i][n - 1 -j];
            matrix[i][n - 1 -j] = temp;
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    System.out.println(matrix);
  }
}
