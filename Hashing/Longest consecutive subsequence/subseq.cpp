#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int findLongestConseqSubseq(int arr[], int n)
    {
        int cnt = 0;
        int ans = 0;

        sort(arr, arr + n);

        int i = 0;
        int curr = arr[i];

        while (i < n) {

            if (curr == arr[i]) {

                curr++;
                cnt++;
                i++;
            }
            else {

                if (arr[i] == curr - 1) {

                    while (i < n && arr[i] == curr - 1) {

                        i++;
                    }
                }

                else {

                    curr = arr[i] + 1;
                    cnt = 1;
                    i++;
                }
            }

            ans = max(ans, cnt);
        }

        return ans;
    }
};

int main()
{
    int t, n, i, a[100001];
    cin >> t;
    while (t--) {
        cin >> n;
        for (i = 0; i < n; i++)
            cin >> a[i];
        Solution obj;
        cout << obj.findLongestConseqSubseq(a, n) << endl;
    }

    return 0;
}