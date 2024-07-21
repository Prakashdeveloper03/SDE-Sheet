import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FindElement {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }
      Solution sol = new Solution();
      System.out.println(sol.findOnce(arr, n));
    }
    sc.close();
  }
}

class Solution {
  int findOnce(int arr[], int n) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        return entry.getKey();
      }
    }
    return -1;
  }
}
