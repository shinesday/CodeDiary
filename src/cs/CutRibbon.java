package cs;

public class CutRibbon {
  public static int cutRibbon(int[] ribbons, int k) {
    int left = 0;
    int right = Integer.MAX_VALUE;
    while (left < right) {
      int mid  = left + (right - left) / 2;
      if (!isCutPossible(ribbons, mid, k)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left - 1;
  }

  public static boolean isCutPossible(int[] ribbons, int length, int k) {
    int count = 0;
    for (int ribbon: ribbons) {
      count += ribbon / length;
    }
    return count >= k;
  }

  public static int greatestLength(int[] arr, int k) {
    if (k <= 0) return 0;
    int max = 0;
    for (int a : arr) {
      max = Math.max(max, a);
    }
    int lo = 1, hi = max;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int len = getLen(arr, mid);
      if (len >= k) { lo = mid + 1; }
      else { hi = mid - 1; }
    }
    return hi;
  }

  private static int getLen(int[] arr, int target) {
    int res = 0;
    for (int a : arr) {
      res += (a / target);
    }
    return res;
  }



  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 9};
    System.out.println(greatestLength(arr, 5));
    System.out.println(cutRibbon(arr, 5));

  }

}