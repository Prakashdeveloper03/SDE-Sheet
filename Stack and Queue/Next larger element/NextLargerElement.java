import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NextLargerElement {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      String inputLine[] = br.readLine().trim().split(" ");
      long[] arr = new long[n];
      for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
      long[] res = new Solution().nextLargerElement(arr, n);
      for (int i = 0; i < n; i++) System.out.print(res[i] + " ");
      System.out.println();
    }
  }
}

class Solution {
  public long[] nextLargerElement(long[] arr, int n) {
    Stack<Long> s = new Stack<>();
    long a[] = new long[n];
    s.push(arr[n - 1]);
    a[n - 1] = -1;
    for (int i = n - 2; i >= 0; i--) {
      while (!s.isEmpty() && s.peek() <= arr[i]) {
        s.pop();
      }
      if (s.isEmpty()) {
        a[i] = -1;
      } else {
        a[i] = s.peek();
      }
      s.push(arr[i]);
    }
    return a;
  }
}
