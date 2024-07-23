import java.util.Scanner;

class QuickSort {
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T > 0) {
      int n = sc.nextInt();
      int arr[] = new int[n];
      for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

      new Solution().quickSort(arr, 0, n - 1);
      printArray(arr);
      T--;
    }
    sc.close();
  }
}

class Solution {
  public void quickSort(int[] arr, int low, int high) {
    if (low >= high) {
      return;
    }
    int i = low - 1;
    int j = low;
    int pivot = high;

    while (j < pivot) {
      if (arr[j] < arr[pivot]) {
        i++;
        swap(arr, i, j);
      }
      j++;
    }
    i++;
    swap(arr, i, pivot);
    quickSort(arr, low, i - 1);
    quickSort(arr, i + 1, high);
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
}
