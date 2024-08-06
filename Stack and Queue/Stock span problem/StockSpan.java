import java.util.Scanner;
import java.util.Stack;

class Solution {
  public int[] calculateSpan(int price[], int n) {
    Stack<Integer> stack = new Stack<>();
    int ans[] = new int[n];
    ans[0] = 1;
    stack.push(0);
    for (int x = 1; x < n; x++) {
      while (!stack.isEmpty() && price[stack.peek()] <= price[x]) stack.pop();

      if (stack.isEmpty()) ans[x] = x + 1;
      else ans[x] = x - stack.peek();
      stack.push(x);
    }
    return ans;
  }
}

class StockSpan {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      int i = 0;
      for (i = 0; i < n; i++) a[i] = sc.nextInt();
      int[] s = new Solution().calculateSpan(a, n);
      for (i = 0; i < n; i++) {
        System.out.print(s[i] + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}
