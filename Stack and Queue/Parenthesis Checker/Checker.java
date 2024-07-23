import java.util.Scanner;
import java.util.Stack;

class Checker {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      String st = sc.next();
      if (new Solution().ispar(st) == true) System.out.println("balanced");
      else System.out.println("not balanced");
    }
    sc.close();
  }
}

class Solution {
  boolean ispar(String x) {
    Stack<Character> paren = new Stack<>();
    boolean flag = true;
    int n = x.length();
    paren.push(x.charAt(0));
    for (int i = 1; i < n; ++i) {
      if (x.charAt(i) == ')' || x.charAt(i) == '}' || x.charAt(i) == ']') {
        if (paren.isEmpty()) {
          flag = false;
          break;
        } else if ((x.charAt(i) == ')' && paren.peek() != '(')
            || (x.charAt(i) == '}' && paren.peek() != '{')
            || (x.charAt(i) == ']' && paren.peek() != '[')) {
          flag = false;
          break;
        } else {
          paren.pop();
        }
      } else {
        paren.push(x.charAt(i));
      }
    }
    return flag && paren.isEmpty();
  }
}
