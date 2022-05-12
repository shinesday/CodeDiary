package cs;

public class LongestEqualSubArray {
  public static int longestEqualSubArray(int[] a) {
    for(int i = 0; i < a.length; i++) {
      if(a[i] == 0) a[i] = -1;
    }
    int[] prefixSum = new int[a.length + 1];
    for(int i = 0; i < a.length; i++) {
      prefixSum[i+1] = prefixSum[i] + a[i];
    }

    int res = 0;
    for(int i = 1; i <= a.length; i++) {
      for(int j = 0; j < i; j++) {
        if(prefixSum[i] == prefixSum[j]) {
          res = Math.max(res, i - j);
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] a = {1, 1, 1, 0, 0, 0, 0};
    System.out.println(longestEqualSubArray(a));
  }

}
