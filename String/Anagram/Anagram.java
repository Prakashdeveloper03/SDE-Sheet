import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Anagram {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      String str = br.readLine();
      String s1 = str.split(" ")[0];
      String s2 = str.split(" ")[1];
      Solution obj = new Solution();
      if (obj.isAnagram(s1, s2)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }
}

class Solution {
  public boolean isAnagram(String a, String b) {
    if (a.length() != b.length()) {
      return false;
    }
    char str1[] = a.toCharArray();
    char str2[] = b.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
  }
}
