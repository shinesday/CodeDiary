import java.util.HashMap;
import java.util.Map;

public class CompareString {
  public static boolean compareString(String s1, String s2) {
    if(s1.length() != s2.length()) {
      return false;
    }

    Map<Character, Integer> map1 = new HashMap<Character, Integer>();
    for(int i = 0; i < s1.length(); i++) {
      map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
    }

    Map<Character, Integer> map2 = new HashMap<Character, Integer>();
    for(int i = 0; i < s2.length(); i++) {
      map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
    }
    for(char ch : map1.keySet()) {
      if(!map2.containsKey(ch)) {
        return false;
      }
    }
    for(char ch : map2.keySet()) {
      if(!map1.containsKey(ch)) {
        return false;
      }
    }
    Map<Integer, Integer> countS1 = new HashMap<Integer, Integer>();
    for(char ch : map1.keySet()) {
      int freq = map1.get(ch);
      countS1.put(freq, countS1.getOrDefault(freq, 0) + 1);
    }

    Map<Integer, Integer> countS2 = new HashMap<Integer, Integer>();
    for(char ch : map2.keySet()) {
      int freq = map2.get(ch);
      countS2.put(freq, countS2.getOrDefault(freq, 0) + 1);
    }

    for(int freq : countS1.keySet()) {
      if(countS1.get(freq) != countS2.get(freq)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String a = "babzccc";
    String b = "abbzczz";
    System.out.println(compareString(a, b));
  }


}
