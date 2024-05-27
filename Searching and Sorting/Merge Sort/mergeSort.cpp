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
    void merge(int arr[], int l, int mid, int r)
    {
        vector<int> result;
        int left = l;
        int right = mid + 1;
        while (left <= mid and right <= r) {
            if (arr[left] < arr[right]) {
                result.push_back(arr[left]);
                left++;
            }
            else {
                result.push_back(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            result.push_back(arr[left]);
            left++;
        }
        while (right <= r) {
            result.push_back(arr[right]);
            right++;
        }
        for (int i = l; i <= r; i++) {
            arr[i] = result[i - l];
        }
        return;
    }

public:
    void mergeSort(int arr[], int l, int r)
    {
        int mid = (l + r) / 2;
        if (l >= r) {
            return;
        }
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }
};

int main()
{
    int n, T, i;
    scanf("%d", &T);
    while (T--) {
        scanf("%d", &n);
        int arr[n + 1];
        for (i = 0; i < n; i++)
            scanf("%d", &arr[i]);
        Solution ob;
        ob.mergeSort(arr, 0, n - 1);
        printArray(arr, n);
    }
    return 0;
}