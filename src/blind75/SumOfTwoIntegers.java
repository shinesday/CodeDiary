package blind75;

public class SumOfTwoIntegers {
  public static int sumOfTwoIntegers(int a, int b) {
    while(b != 0) {
      int answer = a ^ b;
      int carry = (a & b) << 1;
      a = answer;
      b = carry;
    }
    return a;
  }

  public static void main(String[] args) {
    int a = 15;
    int b = 3;
    System.out.println(sumOfTwoIntegers(a, b));
  }
}
