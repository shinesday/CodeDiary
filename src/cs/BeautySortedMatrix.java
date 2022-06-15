package cs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class BeautySortedMatrix {
  public static int[][] beautySortedMatrix(int[][] input, int n) {
    int size = input.length;
    int[][] output = new int[size][size];

    TreeMap<Integer, LinkedList<int[]>> map = new TreeMap<>();
    ArrayList<int[]> iterationindex = new ArrayList<>();

    for(int i = 0; i<size;i+=n) {
      for(int j = 0; j<size;j+=n) {
        iterationindex.add(new int[] {i,j});
        int bn = computeBeauty(i,j,input,n);//bn: beauty number of each start point i,j
        if(!map.containsKey(bn)) {
          map.put(bn, new LinkedList<int[]>());
        }
        map.get(bn).addLast(new int[] {i,j});;
      }
    }

    LinkedList<int[]> index = new LinkedList<>();
    for(Map.Entry<Integer,LinkedList<int[]>> e: map.entrySet()) {
      LinkedList<int[]> temp = e.getValue();
      for(int[] x: temp) {
        index.add(x);
      }
    }

    for(int sz = 0;sz<index.size();sz++) {
      //index{<0,2>,<2,0>,<2,2>,<0,0>}
      int[] temp = index.get(sz);
      int r = temp[0];
      int c = temp[1];
      for(int i = iterationindex.get(sz)[0]; i<iterationindex.get(sz)[0]+n;i++,r++) {
        //iterationindex{<0,0>,<0,2>,<2,0>,<2,2>}  i [,]
        c = temp[1];
        for(int j = iterationindex.get(sz)[1]; j<iterationindex.get(sz)[1]+n;j++,c++) {
          output[i][j] = input[r][c];

        }
      }
    }
    return output;
  }

  private static int computeBeauty(int r, int c,int[][] input, int n) {
    int bn = 1;

    for(int i=r;i<r+n;i++) {
      for(int j = c; j<c+n;j++) {
        if(bn!=input[i][j]) {
          break;
        }
        bn++;
      }
    }
    return bn;
  }

}
