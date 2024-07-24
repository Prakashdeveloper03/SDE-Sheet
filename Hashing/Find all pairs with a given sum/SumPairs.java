import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class pair {
  long first, second;

  public pair(long first, long second) {
    this.first = first;
    this.second = second;
  }
}

class SumPairs {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      int x = Integer.parseInt(br.readLine().trim());
      String line = br.readLine();
      String[] tokens = line.split(" ");
      ArrayList<Long> array = new ArrayList<>();
      for (String token : tokens) {
        array.add(Long.parseLong(token));
      }
      int[] arr1 = new int[array.size()];
      int idx = 0;
      for (long i : array) arr1[idx++] = (int) i;

      String line2 = br.readLine();
      String[] tokens2 = line2.split(" ");
      ArrayList<Long> array2 = new ArrayList<>();
      for (String token2 : tokens2) {
        array2.add(Long.parseLong(token2));
      }
      int[] arr2 = new int[array2.size()];
      int idx2 = 0;
      for (long i : array2) arr2[idx2++] = (int) i;

      Solution obj = new Solution();
      pair[] answer = obj.allPairs(x, arr1, arr2);
      int sz = answer.length;
      if (sz == 0) System.out.println(-1);
      else {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < sz; i++) {
          if (i < sz - 1) output.append(answer[i].first + " " + answer[i].second + ", ");
          else output.append(answer[i].first + " " + answer[i].second);
        }
        System.out.println(output);
      }
    }
  }
}

class Solution {
  public pair[] allPairs(int x, int arr1[], int arr2[]) {
    int N = arr1.length;
    int M = arr2.length;
    Arrays.sort(arr1);
    Set<Integer> setB = new HashSet<>();
    for (int i = 0; i < M; i++) {
      setB.add(arr2[i]);
    }
    List<pair> result = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      int complement = x - arr1[i];
      if (setB.contains(complement)) {
        result.add(new pair(arr1[i], complement));
      }
    }
    return result.toArray(new pair[result.size()]);
  }
}
