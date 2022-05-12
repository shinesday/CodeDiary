package cs;

import java.util.HashSet;
import java.util.Set;

public class GoodTuples {
  public static int goodTuples(int[] a) {
    Set<Integer> set = new HashSet<>();
    int res = 0;
    for (int i = 1; i < a.length - 1; i++) {
      set.add(a[i - 1]);
      set.add(a[i]);
      set.add(a[i + 1]);
      if (set.size() == 2) {
        res++;
      } else {
        set.clear();
        continue;
      }
    }
    return res;
  }

  public static int goodTuples2(int[] a) {
    int res = 0;
    for(int i = 1; i < a.length - 1; i++) {
      res += check(a[i-1], a[i], a[i+1]);
    }
    return res;
  }

  public static int check(int a, int b, int c) {
    if(a == b && a != c) {
      return 1;
    } else if (a == c && a != b) {
      return 1;
    } else if (b == c && a != b) {
      return 1;
    } else {
      return 0;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 2, 1, 5, 3, 2, 3};
    System.out.println(goodTuples(a));
  }
}