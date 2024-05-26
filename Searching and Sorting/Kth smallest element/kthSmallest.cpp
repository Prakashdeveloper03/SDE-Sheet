#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int kthSmallest(int arr[], int l, int r, int k)
    {
        int n = r - l + 1;
        priority_queue<int> pq;
        for (int i = 0; i < k; i++) {
            pq.push(arr[i]);
        }
        for (int i = k; i < n; i++) {
            int ele = arr[i];
            if (pq.top() > ele) {
                pq.push(ele);
                pq.pop();
            }
        }
        return pq.top();
    }
};

int main()
{
    int test_case;
    cin >> test_case;
    while (test_case--) {
        int number_of_elements;
        cin >> number_of_elements;
        int a[number_of_elements];

        for (int i = 0; i < number_of_elements; i++)
            cin >> a[i];

        int k;
        cin >> k;
        Solution ob;
        cout << ob.kthSmallest(a, 0, number_of_elements - 1, k) << endl;
    }
    return 0;
}