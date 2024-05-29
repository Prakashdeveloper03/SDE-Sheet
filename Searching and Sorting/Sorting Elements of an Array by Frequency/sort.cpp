#include <iostream>
#include <queue>
#include <map>
#include <algorithm>
using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int nums[n];
        map<int, int> mp;
        for (int i = 0; i < n; i++) {
            cin >> nums[i];
        }
        sort(nums, nums + n);
        for (int i = 0; i < n; i++) {
            mp[nums[i]]++;
        }

        priority_queue<pair<int, int> > pq;

        for (auto x : mp) {
            pq.push({ x.second, -1 * x.first });
        }

        while (pq.size()) {
            for (int i = 0; i < pq.top().first; i++) {
                cout << pq.top().second * -1 << " ";
            }
            pq.pop();
        }
        cout << endl;
    }

    return 0;
}