import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueues {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      Queues g = new Queues();
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

class Queues {
  Queue<Integer> q1 = new LinkedList<Integer>();
  Queue<Integer> q2 = new LinkedList<Integer>();

  void push(int a) {
    if (q1.isEmpty()) {
      q1.add(a);
    } else {
      while (!q1.isEmpty()) {
        q2.add(q1.poll());
      }
      q1.add(a);
      while (!q2.isEmpty()) {
        q1.add(q2.poll());
      }
    }
  }

  int pop() {
    if (q1.isEmpty()) {
      return -1;
    }
    return q1.poll();
  }
}
