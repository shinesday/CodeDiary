package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//451
public class FrequencySort {
  public static String frequencySort(String s) {
    Map<Character, Integer> counts = new HashMap<>();
    for (char c : s.toCharArray()) {
      counts.put(c, counts.getOrDefault(c, 0) + 1);
    }
    List<Character> characters = new ArrayList<>(counts.keySet());
    Collections.sort(characters, (a, b) -> counts.get(b) - counts.get(a));
    StringBuilder sb = new StringBuilder();
    for (char c : characters) {
      int copies = counts.get(c);
      for (int i = 0; i < copies; i++) {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String s = "tree";
    System.out.println(frequencySort(s));
  }

}
