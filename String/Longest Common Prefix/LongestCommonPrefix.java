import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class LongestCommonPrefix {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String arr[] = read.readLine().trim().split(" ");

      Solution ob = new Solution();
      System.out.println(ob.longestCommonPrefix(arr));
    }
  }
}

class Solution {
  public String longestCommonPrefix(String arr[]) {
    Arrays.sort(arr);
    String st = arr[0];
    String en = arr[arr.length - 1];
    StringBuilder str = new StringBuilder();

    for (int i = 0; i < Math.min(st.length(), en.length()); i++) {
      if (st.charAt(i) != en.charAt(i)) {
        break;
      }
      str.append(st.charAt(i));
    }
    return str.length() == 0 ? "-1" : str.toString();
  }
}
