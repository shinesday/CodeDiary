package cs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindMinInArray {
  public static List<Integer> findMin(int m, int n, int[][] queries) {
    TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    int[][] matrix = new int[m][n];
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        matrix[i][j] = (i + 1) * (j + 1);
        map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
      }
    }

    List<Integer> res = new ArrayList<>();
    for(int[] query : queries) {
      if(query.length == 1) {
        for(int key : map.keySet()) {
          if(map.get(key) != 0) {
            res.add(key);
            break;
          }
        }
      } else if (query.length == 2) {
        // consider the row
        if(query[0] == 1) {
          int row = query[1];
          for(int j = 0; j < n; j++) {
            if(matrix[row][j] != -1 && map.containsKey(matrix[row][j])) {
              map.put(matrix[row][j], map.get(matrix[row][j]) - 1);
              matrix[row][j] = -1;
            }
          }
        } else {
          int col = query[1];
          for(int i = 0; i < m; i++) {
            if(matrix[i][col] != -1 && map.containsKey(matrix[i][col])) {
              map.put(matrix[i][col], map.get(matrix[i][col]) - 1);
              matrix[i][col] = -1;
            }
          }
        }
      }
    }
    return res;
  }

  public static void print2D(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(matrix[i][j]);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    System.out.println();
  }

}
