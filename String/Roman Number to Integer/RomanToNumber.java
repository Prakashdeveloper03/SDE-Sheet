import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class RomanToNumber {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine().trim());
    while (tc-- > 0) {
      String roman = br.readLine().trim();
      Solution ob = new Solution();
      System.out.println(ob.romanToDecimal(roman));
    }
  }
}

class Solution {
  public int romanToDecimal(String str) {
    Map<Character, Integer> num = new HashMap<>();
    num.put('I', 1);
    num.put('V', 5);
    num.put('X', 10);
    num.put('L', 50);
    num.put('C', 100);
    num.put('D', 500);
    num.put('M', 1000);
    int n = str.length();
    int ans = num.get(str.charAt(n - 1));
    for (int i = n - 2; i >= 0; i--) {
      if (num.get(str.charAt(i)) < num.get(str.charAt(i + 1))) {
        ans -= num.get(str.charAt(i));
      } else {
        ans += num.get(str.charAt(i));
      }
    }
    return ans;
  }
}
