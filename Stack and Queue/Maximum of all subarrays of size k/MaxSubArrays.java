import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class MaxSubArrays {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);
      for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
      System.out.println();
    }
    sc.close();
  }
}

class Solution {
  ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    ArrayList<Integer> ans = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      while (!queue.isEmpty() && arr[i] > arr[queue.getLast()]) {
        queue.removeLast();
      }
      queue.addLast(i);
      if (queue.getFirst() + k == i) {
        queue.removeFirst();
      }
      if (i >= k - 1) {
        ans.add(arr[queue.getFirst()]);
      }
    }
    return ans;
  }
}
