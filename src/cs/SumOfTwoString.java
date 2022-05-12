package cs;

public class SumOfTwoString {
  public String combineString(String str1, String str2) {
    StringBuilder sb = new StringBuilder();
    int i = str1.length() - 1, j = str2.length() - 1;
    for (; i >= 0 && j >= 0; i--, j--) {
      int sum = str1.charAt(i) - '0' + str2.charAt(j) - '0';
      sb.insert(0, sum);
    }
    for (; i >= 0; i--) {
      sb.insert(0, str1.charAt(i) - '0');
    }
    for (; j >= 0; j--) {
      sb.insert(0, str2.charAt(j) - '0');
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String s2 = "12345";
    String s1 = "1234";
    SumOfTwoString sumOfTwoString = new SumOfTwoString();
    System.out.println(sumOfTwoString.combineString(s1, s2));
  }

}
