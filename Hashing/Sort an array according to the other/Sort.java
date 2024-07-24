import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
  public static int[] sortA1ByA2(int A1[], int N, int A2[], int M) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : A1) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    int result[] = new int[N];
    int index = 0;
    for (int num : A2) {
      if (map.containsKey(num)) {
        int count = map.get(num);
        while (count-- > 0) {
          result[index++] = num;
        }
        map.remove(num);
      }
    }
    List<Integer> remainingElements = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      int count = entry.getValue();
      while (count-- > 0) {
        remainingElements.add(entry.getKey());
      }
    }
    Collections.sort(remainingElements);
    for (int num : remainingElements) {
      result[index++] = num;
    }
    return result;
  }
}

class Sort {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int a1[] = new int[n];
      int a2[] = new int[m];
      for (int i = 0; i < n; i++) a1[i] = sc.nextInt();
      for (int i = 0; i < m; i++) a2[i] = sc.nextInt();
      Solution ob = new Solution();
      a1 = sortA1ByA2(a1, n, a2, m);
      for (int x : a1) System.out.print(x + " ");
      System.out.println();
    }
  }
}
