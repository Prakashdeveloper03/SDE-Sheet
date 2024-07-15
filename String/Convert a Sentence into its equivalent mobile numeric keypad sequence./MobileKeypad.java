import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MobileKeypad {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String S = read.readLine();
      Solution obj = new Solution();
      System.out.println(obj.printSequence(S));
    }
  }
}

class Solution {
  public String printSequence(String S) {
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == ' ') {
        ans.append('0');
      } else if (c >= 'A' && c <= 'C') {
        for (int j = 1; j <= c - 'A' + 1; j++) ans.append('2');
      } else if (c >= 'D' && c <= 'F') {
        for (int j = 1; j <= c - 'D' + 1; j++) ans.append('3');
      } else if (c >= 'G' && c <= 'I') {
        for (int j = 1; j <= c - 'G' + 1; j++) ans.append('4');
      } else if (c >= 'J' && c <= 'L') {
        for (int j = 1; j <= c - 'J' + 1; j++) ans.append('5');
      } else if (c >= 'M' && c <= 'O') {
        for (int j = 1; j <= c - 'M' + 1; j++) ans.append('6');
      } else if (c >= 'P' && c <= 'S') {
        for (int j = 1; j <= c - 'P' + 1; j++) ans.append('7');
      } else if (c >= 'T' && c <= 'V') {
        for (int j = 1; j <= c - 'T' + 1; j++) ans.append('8');
      } else if (c >= 'W' && c <= 'Z') {
        for (int j = 1; j <= c - 'W' + 1; j++) ans.append('9');
      }
    }
    return ans.toString();
  }
}
