package blind75;

public class NumberOf1Bits {
  public static int numberOf1Bits(int a) {
    int mask = 1;
    int bits = 0;
    for (int i = 0; i < 32; i++) {
      if ((a & mask) != 0) {
        bits++;
      }
      mask <<= 1;
    }
    return bits;
  }

  public static int numberOf1Bits2(int a) {
    int bits = 0;
    while (a != 0) {
      bits++;
      a = a & (a - 1);
    }
    return bits;
  }

  public static void main(String[] args) {
    int a = 00000000000000000000000000001011;
    System.out.println(numberOf1Bits(a));
    System.out.println(numberOf1Bits2(a));
  }

}
