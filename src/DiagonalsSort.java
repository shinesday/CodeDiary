import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalsSort {
  public static void diagonalsSort(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    for(int d = 0; d < n; d++) {
      List<Integer> temp = new ArrayList();
      for(int i = 0; i < n - d; i++) {
        temp.add(matrix[i][i+d]);
      }
      Collections.sort(temp);
      for(int i = 0; i < n - d; i++) {
        matrix[i][i+d] = temp.get(i);
      }
      temp.clear();
      if(d != 0) {
        for(int i = 0; i < n - d; i++) {
          temp.add(matrix[i+d][i]);
        }
        Collections.sort(temp);
        for(int i = 0; i < n - d; i++) {
          matrix[i+d][i] = temp.get(i);
        }
      }
    }
  }


}
