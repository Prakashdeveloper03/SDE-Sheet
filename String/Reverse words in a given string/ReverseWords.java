import java.util.Scanner;

class ReverseWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      String s = sc.next();
      Solution obj = new Solution();
      System.out.println(obj.reverseWords(s));
      t--;
    }
    sc.close();
  }
}

class Solution {
  String reverseWords(String S) {
    int i = S.length() - 1;
    StringBuilder ans = new StringBuilder();
    StringBuilder temp = new StringBuilder();
    while (i >= 0) {
      if (S.charAt(i) == '.') {
        ans.append(temp.reverse().toString());
        ans.append('.');
        temp.setLength(0);
      } else {
        temp.append(S.charAt(i));
      }
      i--;
    }
    ans.append(temp.reverse().toString());
    return ans.toString();
  }
}
