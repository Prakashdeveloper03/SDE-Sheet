import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public int sumOfMiddleElements(int[] arr1, int[] arr2) {
    int[] arr = Arrays.copyOf(arr1, arr1.length + arr2.length);
    System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
    Arrays.parallelSort(arr);
    int n = arr.length / 2;
    if (arr.length % 2 == 0) {
      return arr[n - 1] + arr[n];
    } else {
      return arr[n] * 2;
    }
  }
}

public class SumMiddleElements {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- > 0) {
      String[] input1 = sc.nextLine().split(" ");
      int[] arr = new int[input1.length];
      for (int i = 0; i < input1.length; i++) {
        arr[i] = Integer.parseInt(input1[i]);
      }

      String[] input2 = sc.nextLine().split(" ");
      int[] brr = new int[input2.length];
      for (int i = 0; i < input2.length; i++) {
        brr[i] = Integer.parseInt(input2[i]);
      }

      Solution ob = new Solution();
      int res = ob.sumOfMiddleElements(arr, brr);
      System.out.println(res);
    }
    sc.close();
  }
}
