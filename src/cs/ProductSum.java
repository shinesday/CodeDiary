package cs;

public class ProductSum {
  public static int productSum(int num) {
    int product = 1;
    int sum = 0;
    while (num != 0) {
      int a = num % 10;
      num = num / 10;
      product = product * a;
      sum = sum + a;
    }
    int res = product - sum;
    return res;
  }

  public static void main(String[] args) {
    int num = 12345;
    System.out.println(productSum(num));
  }

}
