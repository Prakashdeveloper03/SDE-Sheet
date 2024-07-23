import java.util.Scanner;

class CountInversions {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long t = sc.nextLong();
    while (t-- > 0) {
      long n = sc.nextLong();
      long arr[] = new long[(int) n];
      for (long i = 0; i < n; i++) arr[(int) i] = sc.nextLong();
      System.out.println(inversionCount(arr, (int) n));
    }
    sc.close();
  }
}

class Solution {
  static long inversionCount(long arr[], int n) {
    long count = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (arr[i] > arr[j]) {
          count++;
        }
      }
    }
    return count;
  }
}
