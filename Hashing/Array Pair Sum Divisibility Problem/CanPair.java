import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CanPair {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String s1 = br.readLine().trim();
      String[] S1 = s1.split(" ");
      int n = Integer.parseInt(S1[0]);
      int k = Integer.parseInt(S1[1]);
      String s2 = br.readLine().trim();
      String[] S2 = s2.split(" ");
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = Integer.parseInt(S2[i]);
      }
      Solution ob = new Solution();
      boolean ans = ob.canPair(nums, k);
      if (ans) System.out.println("True");
      else System.out.println("False");
    }
  }
}

class Solution {
  public boolean canPair(int[] nums, int k) {
    int[] rems = new int[k];
    for (int num : nums) rems[num % k]++;
    for (int i = 0; i < k; i++) {
      if ((i == 0) && ((rems[0] & 1) != 0)) return false;
      if ((i == (k - i)) && ((rems[i] & 1) != 0)) return false;
      if ((i != 0) && (rems[i] != rems[k - i])) return false;
    }
    return true;
  }
}
