import java.util.Scanner;

class SubString {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int test = scan.nextInt();
    while (test > 0) {
      String s = scan.next();
      String t = scan.next();
      System.out.println(smallestWindow(s, t));
      test--;
    }
    scan.close();
  }
}

class Solution {
  public static String smallestWindow(String s, String p) {
    int[] pat = new int[26];
    int[] str = new int[26];
    for (char c : p.toCharArray()) {
      pat[c - 'a']++;
    }
    int j = 0, match = 0;
    StringBuilder ans = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      str[c - 'a']++;
      temp.append(c);
      if (pat[c - 'a'] > 0 && str[c - 'a'] <= pat[c - 'a']) {
        match++;
      }
      while (match == p.length()) {
        if (ans.length() == 0 || temp.length() < ans.length()) {
          ans = new StringBuilder(temp);
        }
        temp.deleteCharAt(0);
        str[s.charAt(j) - 'a']--;

        if (str[s.charAt(j) - 'a'] < pat[s.charAt(j) - 'a']) {
          match--;
        }
        j++;
      }
    }
    return ans.length() == 0 ? "-1" : ans.toString();
  }
}
