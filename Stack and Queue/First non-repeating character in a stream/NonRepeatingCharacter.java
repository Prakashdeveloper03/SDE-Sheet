import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String A = br.readLine().trim();
      Solution ob = new Solution();
      String ans = ob.FirstNonRepeating(A);
      out.println(ans);
    }
    out.close();
  }
}

class Solution {
  public String FirstNonRepeating(String A) {
    HashMap<Character, Integer> c = new HashMap<>();
    HashMap<Character, Integer> h = new HashMap<>();
    char a[] = A.toCharArray();
    StringBuilder ans = new StringBuilder("");
    int n = A.length();
    for (int i = 0; i < n; i++) {
      c.put(a[i], c.getOrDefault(a[i], 0) + 1);
      h.put(a[i], i);
      char k = '#';
      int min = i;
      for (Map.Entry<Character, Integer> j : c.entrySet()) {
        if (j.getValue() == 1) {
          if (h.get(j.getKey()) <= min) {
            min = h.get(j.getKey());
            k = j.getKey();
          }
        }
      }
      ans.append(k + "");
    }
    return ans.toString();
  }
}
