import java.util.ArrayList;
import java.util.Scanner;

class Solution {
  public static int minIndexChar(String str, String patt) {
    int l1 = str.length(), l2 = patt.length();
    ArrayList<Character> s = new ArrayList<Character>();
    for (int x = 0; x < l2; x++) {
      if (!s.contains(patt.charAt(x))) s.add(patt.charAt(x));
    }
    for (int x = 0; x < l1; x++) {
      if (s.contains(str.charAt(x))) return x;
    }
    return -1;
  }
}

class MinIndexed {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      t--;
      String s1 = sc.next();
      String s2 = sc.next();
      int res = minIndexChar(s1, s2);
      System.out.println(res);
    }
  }
}
