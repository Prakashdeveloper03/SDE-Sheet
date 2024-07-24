import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CommonElements {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int v1[] = new int[n];
      for (int i = 0; i < n; i++) {
        v1[i] = sc.nextInt();
      }
      int m = sc.nextInt();
      int v2[] = new int[m];
      for (int i = 0; i < m; i++) {
        v2[i] = sc.nextInt();
      }
      Solution ob = new Solution();
      ArrayList<Integer> ans = common_element(v1, v2);
      for (int i : ans) System.out.print(i + " ");

      System.out.println();
    }
  }
}

class Solution {
  public static ArrayList<Integer> common_element(int v1[], int v2[]) {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : v1) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for (int num : v2) {
      if (map.containsKey(num) && map.get(num) > 0) {
        map.put(num, map.get(num) - 1);
        ans.add(num);
      }
    }

    Collections.sort(ans);
    return ans;
  }
}
