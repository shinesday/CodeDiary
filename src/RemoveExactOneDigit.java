//move exact one digit char from string s or t, so that s < t; input: String s1,s2 (lower case letters and digits)
//output: number of ways to remove the digit char.
public class RemoveExactOneDigit {
  public static int removeExactOneDigit(String s, String t) {
    if(s == null && t == null || s.length() == 0 && t.length() == 0) {
      return 0;
    }
    if(s == null || s.length() == 0) {
      return t.length();
    }
    if(t == null || t.length() == 0) {
      return 0;
    }
    int len1 = s.length();
    int len2 = t.length();
    int s1Arrow = 0;
    int s2Arrow = 0;
    int res = 0;
    if(s.charAt(0) < t.charAt(0)) {
      res = (s.length() - 1) + (t.length() - 1);
      //consider the first two
      if(compareStringVal(s.substring(1), t) > 0) {
        res++;
      }
      if(compareStringVal(s, t.substring(1)) > 0){
        res++;
      }

    } else if (s.charAt(s1Arrow) == t.charAt(s2Arrow)) {
      res = removeExactOneDigit(s.substring(1), t.substring(1));
      if(compareStringVal(s.substring(1), t) > 0) {
        res++;
      }
      if(compareStringVal(s, t.substring(1)) > 0){
        res++;
      }
    } else {
      if(compareStringVal(s.substring(1), t) > 0) {
        res = 1;
      } else {
        res = 0;
      }
    }
    return res;
  }

  public static int compareStringVal(String s, String t) {
    int len1 = s.length();
    int len2 = t.length();
    int s1Arrow = 0;
    int s2Arrow = 0;
    while (s1Arrow < len1 && s2Arrow < len2) {
      if(s.charAt(s1Arrow) < t.charAt(s2Arrow)) {
        return 1;
      } else if (s.charAt(s1Arrow) == t.charAt(s2Arrow)) {
        s1Arrow++;
        s2Arrow++;
      } else {
        return -1;
      }
    }
    if(s1Arrow < len1)
      return -1;
    else
      return 1;
  }

}
