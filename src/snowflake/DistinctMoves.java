package snowflake;

public class DistinctMoves {
  public static int distinctMoves(String s, int n, int x, int y) {
    int sum = 0;
    for (char c : s.toCharArray()) {
      if (c == 'r') sum++;
      if (c == 'l') sum--;
    }
    return 0;
  }

}
