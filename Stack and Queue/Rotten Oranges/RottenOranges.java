import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int n = Integer.parseInt(s[0]);
      int m = Integer.parseInt(s[1]);
      int[][] grid = new int[n][m];
      for (int i = 0; i < n; i++) {
        String[] S = br.readLine().trim().split(" ");
        for (int j = 0; j < m; j++) {
          grid[i][j] = Integer.parseInt(S[j]);
        }
      }
      Solution obj = new Solution();
      int ans = obj.orangesRotting(grid);
      System.out.println(ans);
    }
  }
}

class Solution {
  int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int orangesRotting(int[][] grid) {
    Queue<int[]> queue = new LinkedList<>();
    int freshOrange = 0;
    int rows = grid.length;
    int cols = grid[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          freshOrange++;
        } else if (grid[i][j] == 2) {
          queue.offer(new int[] {i, j, 0});
        }
      }
    }

    int minutes = 0;
    while (!queue.isEmpty()) {
      int curr[] = queue.poll();
      int row = curr[0];
      int col = curr[1];
      minutes = curr[2];
      for (int[] dir : direction) {
        int newRows = dir[0] + row;
        int newCols = dir[1] + col;
        if (newRows >= 0
            && newRows < rows
            && newCols >= 0
            && newCols < cols
            && grid[newRows][newCols] == 1) {
          grid[newRows][newCols] = 2;
          freshOrange--;
          queue.offer(new int[] {newRows, newCols, minutes + 1});
        }
      }
    }

    if (freshOrange > 0) {
      return -1;
    } else {
      return minutes;
    }
  }
}
