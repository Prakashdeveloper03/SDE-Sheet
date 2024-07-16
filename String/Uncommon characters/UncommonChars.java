import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class UncommonChars {
  public static void main(String args[]) throws IOException {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String A = sc.next();
      String B = sc.next();
      Solution ob = new Solution();
      System.out.println(ob.UncommonChars(A, B));
    }
    sc.close();
  }
}

class Solution {
  String UncommonChars(String A, String B) {
    Map<Character, Boolean> mp = new HashMap<>();
    for (char c : A.toCharArray()) {
      mp.put(c, true);
    }
    StringBuilder ans = new StringBuilder();
    for (char c : B.toCharArray()) {
      if (!mp.containsKey(c)) {
        ans.append(c);
        mp.put(c, false);
      } else {
        mp.put(c, false);
      }
    }
    for (Map.Entry<Character, Boolean> entry : mp.entrySet()) {
      if (entry.getValue()) {
        ans.append(entry.getKey());
        entry.setValue(false);
      }
    }
    char[] resultArray = ans.toString().toCharArray();
    Arrays.sort(resultArray);
    String result = new String(resultArray);
    return result.isEmpty() ? "-1" : result;
  }
}
