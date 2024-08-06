import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class HistMax {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      long n = Long.parseLong(br.readLine().trim());
      String inputLine[] = br.readLine().trim().split(" ");
      long[] arr = new long[(int) n];
      for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
      System.out.println(new Solution().getMaxArea(arr, n));
    }
  }
}

class Solution {
  private static long[] nextSmall(long hist[], long n) {
    long[] next = new long[(int) n];
    Stack<Integer> stack = new Stack<>();
    for (int x = (int) n - 1; x >= 0; x--) {
      while (!stack.isEmpty() && hist[stack.peek()] >= hist[x]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        next[x] = n;
      } else {
        next[x] = stack.peek();
      }
      stack.push(x);
    }
    return next;
  }

  private static long[] prevSmall(long hist[], long n) {
    long[] prev = new long[(int) n];
    Stack<Integer> stack = new Stack<>();
    for (int x = 0; x < n; x++) {
      while (!stack.isEmpty() && hist[stack.peek()] >= hist[x]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        prev[x] = -1;
      } else {
        prev[x] = stack.peek();
      }
      stack.push(x);
    }
    return prev;
  }

  public long getMaxArea(long hist[], long n) {
    long[] prev = new long[(int) n];
    long[] next = new long[(int) n];
    prev = prevSmall(hist, n);
    next = nextSmall(hist, n);
    long area = -1;
    for (int x = 0; x < n; x++) {
      area = Math.max(area, (next[x] - prev[x] - 1) * hist[x]);
    }
    return area;
  }
}
