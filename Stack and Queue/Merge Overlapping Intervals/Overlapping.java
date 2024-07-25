import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Overlapping {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      String[] s = br.readLine().trim().split(" ");
      int[][] Intervals = new int[n][2];
      int j = 0;
      for (int i = 0; i < n; i++) {
        Intervals[i][0] = Integer.parseInt(s[j]);
        j++;
        Intervals[i][1] = Integer.parseInt(s[j]);
        j++;
      }
      Solution obj = new Solution();
      int[][] ans = obj.overlappedInterval(Intervals);
      for (int i = 0; i < ans.length; i++) {
        for (j = 0; j < ans[i].length; j++) {
          System.out.print(ans[i][j] + " ");
        }
      }
      System.out.println();
    }
  }
}

class Solution {
  public int[][] overlappedInterval(int[][] Intervals) {
    int n = Intervals.length;
    List<int[]> ans = new ArrayList<>();
    Arrays.sort(Intervals, (a, b) -> a[0] - b[0]);
    for (int i = 0; i < n; i++) {
      if (ans.isEmpty() || Intervals[i][0] > ans.get(ans.size() - 1)[1]) {
        ans.add(new int[] {Intervals[i][0], Intervals[i][1]});
      } else {
        ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], Intervals[i][1]);
      }
    }

    return ans.toArray(new int[ans.size()][]);
  }
}
