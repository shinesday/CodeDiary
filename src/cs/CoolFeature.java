package cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoolFeature {
  public static int[] coolFeature(int[] a, int[] b, int[][] querys) {
    List<Integer> ans = new ArrayList<>();

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }

    for(int[] query : querys) {
      if(query.length == 2) {
        int temp = findSum(map, b, query[1]);
        ans.add(temp);
      } else if (query.length == 3) {
        changeArray(a, b, query[1], query[2]);
      }
    }
    int[] ansArray = new int[ans.size()];
    for(int i = 0; i < ans.size(); i++) {
      ansArray[i] = ans.get(i);
    }
    return ansArray;
  }

  public static int findSum(Map<Integer, Integer> map, int[] b, int target) {
    int res = 0;
    for (int i = 0; i < b.length; i++) {
      if(map.containsKey(target - b[i])) {
        res += map.get(target - b[i]);
      }
    }
    return res;
  }

  public static void changeArray(int[] a, int[] b, int loc, int num) {
    b[loc] = num;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    int[] b = {3, 4};
    int[][] q = {{1, 5}, {1, 1, 1}, {1, 5}};
    System.out.println(coolFeature(a, b, q));
  }

}
