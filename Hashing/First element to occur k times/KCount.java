import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class KCount {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      String inputLine[] = br.readLine().trim().split(" ");
      int n = Integer.parseInt(inputLine[0]);
      int k = Integer.parseInt(inputLine[1]);
      int[] arr = new int[n];
      inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(inputLine[i]);

      Solution obj = new Solution();
      System.out.println(obj.firstElementKTime(n, k, arr));
    }
  }
}

class Solution {
  public int firstElementKTime(int n, int k, int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
      if (map.get(arr[i]) == k) {
        return arr[i];
      }
    }
    return -1;
  }
}
