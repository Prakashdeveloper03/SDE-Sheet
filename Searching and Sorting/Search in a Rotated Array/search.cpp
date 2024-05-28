#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int search(int a[], int l, int h, int k)
    {
        if (l > h)
            return -1;

        int m = (l + h) / 2;

        if (a[m] == k)
            return m;

        if (a[l] <= a[m]) {
            if (a[l] <= k && k <= a[m])
                return search(a, l, m - 1, k);

            return search(a, m + 1, h, k);
        }
        else {
            if (a[m] <= k && k <= a[h])
                return search(a, m + 1, h, k);

            return search(a, l, m - 1, k);
        }
    }
};

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int A[n];
        for (int i = 0; i < n; i++)
            cin >> A[i];
        int key;
        cin >> key;
        Solution ob;
        cout << ob.search(A, 0, n - 1, key) << endl;
    }
    return 0;
}