import java.util.Scanner;

public class CircularTour {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t > 0) {
      int n = sc.nextInt();
      sc.nextLine();
      String str = sc.nextLine();
      String arr[] = str.split(" ");
      int p[] = new int[n];
      int d[] = new int[n];
      int j = 0;
      int k = 0;
      for (int i = 0; i < 2 * n; i++) {
        if (i % 2 == 0) {
          p[j] = Integer.parseInt(arr[i]);
          j++;
        } else {
          d[k] = Integer.parseInt(arr[i]);
          k++;
        }
      }
      sc.close();
      System.out.println(new Solution().tour(p, d));
      t--;
    }
  }
}

class Solution {
  int tour(int petrol[], int distance[]) {
    int n = petrol.length;
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) arr[i] = petrol[i] - distance[i];
    int left = 0, right = 0;
    int sum = 0, size = 0;
    while (size < n && left < n) {
      right = right % n;
      sum += arr[right++];
      size++;
      while (sum < 0 && size > 0 && left < n) {
        sum -= arr[left++];
        size--;
      }
    }
    if (size == n) return left;
    return -1;
  }
}
