import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class ZeroSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- > 0) {
      int n;
      n = sc.nextInt();

      long arr[] = new long[n];

      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextLong();
      }
      Solution ob = new Solution();
      System.out.println(findSubarray(arr, n));
    }
  }
}

class Solution {
  public static long findSubarray(long[] arr, int n) {
    long result = 0;
    Map<Long, Integer> freq = new HashMap<>();
    long sum = 0;
    freq.put(0L, 1);
    for (int i = 0; i < n; i++) {
      sum += arr[i];
      freq.put(sum, freq.getOrDefault(sum, 0) + 1);
      result += freq.get(sum) - 1;
    }
    return result;
  }
}
