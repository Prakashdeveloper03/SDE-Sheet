import java.util.Scanner;
import java.util.Stack;

class GfG {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      StackQueue g = new StackQueue();
      int q = sc.nextInt();
      while (q > 0) {
        int QueryType = sc.nextInt();
        if (QueryType == 1) {
          int a = sc.nextInt();
          g.push(a);
        } else if (QueryType == 2) System.out.print(g.pop() + " ");
        q--;
      }
      System.out.println();
      t--;
    }
    sc.close();
  }
}

class StackQueue {
  Stack<Integer> s1 = new Stack<Integer>();
  Stack<Integer> s2 = new Stack<Integer>();

  void push(int x) {
    s1.push(x);
  }

  int pop() {
    if (s1.isEmpty()) return -1;

    while (!s1.isEmpty()) {
      s2.push(s1.pop());
    }
    int ans = s2.pop();
    while (!s2.isEmpty()) {
      s1.push(s2.pop());
    }
    return ans;
  }
}
