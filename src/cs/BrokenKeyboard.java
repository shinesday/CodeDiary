package cs;

import java.util.HashSet;
import java.util.Set;

public class BrokenKeyboard {
  public static int brokenKeyboard(String a, char[] b) {
    Set<Character> set = new HashSet<>();
    for(char c : b) {
      set.add(c);
    }
    int res = 0;
    String[] temp = a.split(" ");
    for(String s : temp) {
      char[] sChar = s.toCharArray();
      boolean isIn = true;
      for(char ch : sChar) {
        ch = Character.toLowerCase(ch);
        if(!set.contains(ch) && Character.isLetter(ch)) {
          isIn = false;
          break;
        }
      }
      if(isIn) {
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    String a = "Hello, my dear friend!";
    char[] b = {'h','e','l','m','o'};
    System.out.println(brokenKeyboard(a, b));
  }

}

