import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class KMP {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String s = read.readLine();
      Solution ob = new Solution();
      System.out.println(ob.lps(s));
    }
  }
}

class Solution {
  int lps(String s) {
    int n = s.length();
    int[] lps = new int[n];
    int pre = 0, suf = 1;
    while (suf < n) {
      if (s.charAt(pre) == s.charAt(suf)) {
        lps[suf] = pre + 1;
        pre++;
        suf++;
      } else {
        if (pre == 0) {
          lps[suf] = 0;
          suf++;
        } else {
          pre = lps[pre - 1];
        }
      }
    }
    return lps[n - 1];
  }
}
