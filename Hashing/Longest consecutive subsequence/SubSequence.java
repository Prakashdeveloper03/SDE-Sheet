import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class SubSequence {
  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    String nextLine() {
      String str = "";
      try {
        str = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }

    Integer nextInt() {
      return Integer.parseInt(next());
    }
  }

  public static void main(String args[]) {
    FastReader sc = new FastReader();
    PrintWriter out = new PrintWriter(System.out);
    int t = sc.nextInt();

    while (t > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];

      for (int i = 0; i < n; i++) a[i] = sc.nextInt();
      out.println(findLongestConseqSubseq(a, n));
      t--;
    }
    out.close();
  }
}

class Solution {
  static int findLongestConseqSubseq(int arr[], int N) {
    int cnt = 0;
    int ans = 0;
    Arrays.sort(arr);
    int i = 0;
    int curr = arr[i];
    while (i < N) {
      if (curr == arr[i]) {
        curr++;
        cnt++;
        i++;
      } else {
        if (arr[i] == curr - 1) {
          while (i < N && arr[i] == curr - 1) {
            i++;
          }
        } else {
          curr = arr[i] + 1;
          cnt = 1;
          i++;
        }
      }
      ans = Math.max(ans, cnt);
    }
    return ans;
  }
}
