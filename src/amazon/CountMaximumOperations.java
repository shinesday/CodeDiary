package amazon;

import java.util.HashMap;
import java.util.Map;

public class CountMaximumOperations {
  public static int countMaximumOperations(String s, String t) {
    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();

    Map<Character,Integer> sMap = new HashMap<>();
    Map<Character, Integer> tMap = new HashMap<>();

    for(char sChar : sArray) {
      sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
    }

    for(char tChar : tArray) {
      tMap.put(tChar, tMap.getOrDefault(tChar, 0) + 1);
    }

    int ans = Integer.MAX_VALUE;
    //遍历t的所有字母，找到s中出现次数/t中出现次数的最小值（向下取整）
    for(char tChar : tArray) {
      ans = Math.min(ans, sMap.getOrDefault(tChar, 0)/tMap.get(tChar));
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "mononom";
    String t = "mon";
    System.out.println(countMaximumOperations(s, t));
  }

}
