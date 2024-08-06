import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KthSmallestElement {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.next());
    while (t > 0) {
      int n = Integer.parseInt(sc.next());
      int[][] a = new int[n][n];
      for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) a[i][j] = Integer.parseInt(sc.next());

      int k = Integer.parseInt(sc.next());
      Solution ob = new Solution();
      System.out.println(ob.kthSmallest(a, n, k));
      t--;
    }
    sc.close();
  }
}

class Solution {
  public int kthSmallest(int[][] mat, int n, int k) {
    ArrayList<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr.add(mat[i][j]);
      }
    }
    Collections.sort(arr);
    return arr.get(k - 1);
  }
}
