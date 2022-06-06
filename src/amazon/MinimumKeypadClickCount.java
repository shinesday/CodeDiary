package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumKeypadClickCount {
  public static int minimumKeypadClickCount(String text) {
    Map<Character, Integer> counts = new HashMap<>();
    for (char c : text.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }
    List<Character> characters = new ArrayList<>(counts.keySet());
    Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));

    int ans = 0;
    for (char c : characters) {
      int copies = counts.get(c);
      int index = characters.indexOf(c);
      if (index < 9) ans += copies;
      if (index >= 9 && index < 18) ans += copies * 2;
      if (index >= 18) ans += copies * 3;
    }
    return ans;
  }

  public static void main(String[] args) {
    String text = "abacadefghibj";
    System.out.println(minimumKeypadClickCount(text));
  }

}
