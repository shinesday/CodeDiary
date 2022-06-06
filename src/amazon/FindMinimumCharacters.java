package amazon;

//给一个searchWord和一个resultWord，问最少给searchWord末尾添加几个字符，可以让resultWord成为它的一个subsequence。举个栗子：searchWord=“armaze”，resultWord=”amazon”，则应该返回2（添加on）。
//思路是两个指针p1，p2分别遍历两个字符串，如果指向的字符相同，则将双指针同时向后移动一位，反之只移动指向searchWord的指针，直到任意指针到达末尾。返回resultString的长度与resultString指针位置的差
public class FindMinimumCharacters {
  public static int findMinimumCharacters(String searchWord, String resultWord) {
    int p1 = 0, p2 = 0;
    int len1 = searchWord.length();
    int len2 = resultWord.length();
    while (p1 < len1 && p2 < len2) {
      if (searchWord.charAt(p1) == resultWord.charAt(p2)) {
        p2++;
      }
      p1++;
    }
    return len2 - p2;
  }

  public static void main(String[] args) {
    String searchWord = "armaze";
    String resultWord = "amazono";
    System.out.println(findMinimumCharacters(searchWord, resultWord));
  }

}
