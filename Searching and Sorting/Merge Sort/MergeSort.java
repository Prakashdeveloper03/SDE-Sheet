import java.util.ArrayList;
import java.util.Scanner;

class MergeSort {
  static void printArray(int arr[]) {
    StringBuffer sb = new StringBuffer("");
    int n = arr.length;
    for (int i = 0; i < n; ++i) sb.append(arr[i] + " ");
    System.out.println(sb.toString());
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
      Solution g = new Solution();
      g.mergeSort(arr, 0, arr.length - 1);
      printArray(arr);
      T--;
    }
    sc.close();
  }
}

class Solution {
  public void merge(int[] arr, int l, int mid, int r) {
    ArrayList<Integer> result = new ArrayList<>();
    int left = l;
    int right = mid + 1;

    while (left <= mid && right <= r) {
      if (arr[left] < arr[right]) {
        result.add(arr[left]);
        left++;
      } else {
        result.add(arr[right]);
        right++;
      }
    }

    while (left <= mid) {
      result.add(arr[left]);
      left++;
    }

    while (right <= r) {
      result.add(arr[right]);
      right++;
    }

    for (int i = l; i <= r; i++) {
      arr[i] = result.get(i - l);
    }
  }

  public void mergeSort(int[] arr, int l, int r) {
    if (l >= r) {
      return;
    }
    int mid = (l + r) / 2;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid + 1, r);
    merge(arr, l, mid, r);
  }
}
