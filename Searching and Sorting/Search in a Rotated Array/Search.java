import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Search {
  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);

    int t = Integer.parseInt(in.readLine().trim());
    while (t-- > 0) {
      String line = in.readLine();
      String[] tokens = line.split(" ");
      ArrayList<Integer> array = new ArrayList<>();
      for (String token : tokens) {
        array.add(Integer.parseInt(token));
      }
      int[] arr = new int[array.size()];
      int idx = 0;
      for (int i : array) arr[idx++] = i;
      int key = Integer.parseInt(in.readLine().trim());
      out.println(new Solution().search(arr, key));
    }
    out.close();
  }
}

class Solution {
  int search(int[] arr, int key) {
    int low = 0;
    int high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == key) {
        return mid;
      }
      if (arr[low] <= arr[mid]) {
        if (arr[low] <= key && key < arr[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {
        if (arr[mid] < key && key <= arr[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }
    return -1;
  }
}
