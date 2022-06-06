package blind75;
public class CountingBits {
  public static int[] countingBits(int n) {
    int[] ans = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      ans[i] = ans[i & (i - 1)] + 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 2;
    for (int i = 0; i <= n; i++) {
      System.out.println(countingBits(n)[i]);
    }
  }
}
