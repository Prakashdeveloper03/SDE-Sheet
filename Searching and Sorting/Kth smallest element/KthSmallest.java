import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

class KthSmallest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
      int k = sc.nextInt();
      Solution ob = new Solution();
      out.println(kthSmallest(arr, 0, n - 1, k));
    }
    sc.close();
    out.flush();
  }
}

class Solution {
  public static int kthSmallest(int[] arr, int l, int r, int k) {
    int n = r - l + 1;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
    for (int i = 0; i < k; i++) {
      pq.add(arr[i]);
    }
    for (int i = k; i < n; i++) {
      int ele = arr[i];
      if (pq.peek() > ele) {
        pq.add(ele);
        pq.poll();
      }
    }
    return pq.peek();
  }
}
