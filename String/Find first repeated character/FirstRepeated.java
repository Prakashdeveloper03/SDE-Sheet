import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class FirstRepeated {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine().trim());
    while (t-- > 0) {
      String s = read.readLine().trim();
      Solution ob = new Solution();
      System.out.println(ob.firstRepChar(s));
    }
  }
}

class Solution {
  String firstRepChar(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.get(c) == 2) {
        return Character.toString(c);
      }
    }
    return "-1";
  }
}
