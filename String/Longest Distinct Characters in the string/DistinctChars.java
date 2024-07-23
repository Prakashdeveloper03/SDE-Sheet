import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class DistinctChars {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String S = read.readLine();

      Solution ob = new Solution();
      System.out.println(ob.longestSubstrDistinctChars(S));
    }
  }
}

class Solution {
  int longestSubstrDistinctChars(String S) {
    int n = S.length();
    int r = 0;
    int l = 0;
    int len = 0;
    Map<Character, Integer> map = new HashMap<>();
    while (r < n) {
      map.put(S.charAt(r), map.getOrDefault(S.charAt(r), 0) + 1);
      if (map.get(S.charAt(r)) > 1) {
        while (map.get(S.charAt(r)) > 1) {
          map.put(S.charAt(l), map.get(S.charAt(l)) - 1);
          if (map.get(S.charAt(l)) == 0) {
            map.remove(S.charAt(l));
          }
          l++;
        }
      }
      if (map.get(S.charAt(r)) <= 1) {
        len = Math.max(len, r - l + 1);
      }
      r++;
    }
    return len;
  }
}
