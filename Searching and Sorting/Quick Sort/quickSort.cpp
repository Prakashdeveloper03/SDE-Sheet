#include <bits/stdc++.h>
using namespace std;
void printArray(int arr[], int size)
{
    int i;
    for (i = 0; i < size; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

class Solution {
public:
    void quickSort(int arr[], int low, int high)
    {
        if (low >= high) {
            return;
        }
        int i = low - 1;
        int j = low;
        int pivot = high;

        if (arr[j] >= arr[pivot]) {
            j++;
        }

        while (j < pivot) {
            if (arr[j] < arr[pivot]) {
                i++;
                swap(arr[i], arr[j]);
            }
            j++;
        }
        i++;
        swap(arr[i], arr[j]);
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
};

int main()
{
    int arr[1000], n, T, i;
    scanf("%d", &T);
    while (T--) {
        scanf("%d", &n);
        for (i = 0; i < n; i++)
            scanf("%d", &arr[i]);
        Solution ob;
        ob.quickSort(arr, 0, n - 1);
        printArray(arr, n);
    }
    return 0;
}