import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CountDistinct {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for (int i = 0; i < n; i++) a[i] = sc.nextInt();
      Solution g = new Solution();

      ArrayList<Integer> ans = g.countDistinct(a, n, k);

      for (Integer val : ans) System.out.print(val + " ");
      System.out.println();
      t--;
    }
    sc.close();
  }
}

class Solution {
  ArrayList<Integer> countDistinct(int A[], int n, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }

    for (int i = k; i < n; i++) {
      result.add(map.size());
      if (map.get(A[i - k]) > 1) {
        map.put(A[i - k], map.get(A[i - k]) - 1);
      } else {
        map.remove(A[i - k]);
      }
      map.put(A[i], map.getOrDefault(A[i], 0) + 1);
    }

    result.add(map.size());
    return result;
  }
}
