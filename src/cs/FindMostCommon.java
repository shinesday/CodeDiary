package cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMostCommon {
  public static List<Integer> mostCommon(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
      max = Math.max(max, map.get(num));
    }

    List<Integer> res = new ArrayList<>();
    for (int num: map.keySet()) {
      if(map.get(num) == max) {
        res.add(num);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] num = {2, 2, 3, 3, 5};
    System.out.println(mostCommon(num));
  }

}
