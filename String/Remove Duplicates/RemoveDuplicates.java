import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class RemoveDuplicates {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String s = read.readLine();
      Solution ob = new Solution();
      String result = ob.removeDups(s);
      System.out.println(result);
    }
  }
}

class Solution {
  String removeDups(String s) {
    Map<Character, Integer> st = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      st.put(c, st.getOrDefault(c, 0) + 1);
      if (st.get(c) == 1) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
