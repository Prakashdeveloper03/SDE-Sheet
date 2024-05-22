#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    long long int findSubarray(vector<long long int>& arr, int n)
    {
        long long int result = 0;
        map<long long int, int> freq;
        long long int sum = 0;
        freq[0]++;
        for (int i = 1; i <= n; i++) {
            sum += arr[i - 1];
            freq[sum]++;
            result += freq[sum] - 1;
        }
        return result;
    }
};

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<long long int> arr(n, 0);

        for (int i = 0; i < n; i++)
            cin >> arr[i];
        Solution ob;
        cout << ob.findSubarray(arr, n) << "\n";
    }
    return 0;
}