import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class SortElements {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int[] nums = new int[n];
      Map<Integer, Integer> mp = new HashMap<>();
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      Arrays.sort(nums);
      for (int num : nums) {
        mp.put(num, mp.getOrDefault(num, 0) + 1);
      }
      PriorityQueue<Map.Entry<Integer, Integer>> pq =
          new PriorityQueue<>(
              (a, b) -> {
                int freqCompare = Integer.compare(b.getValue(), a.getValue());
                if (freqCompare == 0) {
                  return Integer.compare(a.getKey(), b.getKey());
                }
                return freqCompare;
              });

      pq.addAll(mp.entrySet());
      while (!pq.isEmpty()) {
        Map.Entry<Integer, Integer> entry = pq.poll();
        int freq = entry.getValue();
        int value = entry.getKey();
        for (int i = 0; i < freq; i++) {
          System.out.print(value + " ");
        }
      }
      System.out.println();
    }

    sc.close();
  }
}
