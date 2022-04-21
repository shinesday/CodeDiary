import java.util.HashSet;
import java.util.Set;

public class DivideSubString {
  public static int divideSubString(String s, int k) {
    int res = 0;
    int total = Integer.parseInt(s);
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < s.length() - k + 1; i++) {
      String temp = s.substring(i, i + k);
      int num = Integer.parseInt(temp);
      if(!set.contains(num) && num != 0) {
        if(total % num == 0) {
          res++;
        }
      }
      set.add(num);
    }
    return res;
  }

  public static void main(String[] args) {
    String a = "120";
    System.out.println(divideSubString(a, 2));
  }

}
