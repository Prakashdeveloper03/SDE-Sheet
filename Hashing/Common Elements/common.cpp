#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    vector<int> common_element(vector<int> v1, vector<int> v2)
    {
        vector<int> ans;
        unordered_map<int, int> st;
        for (auto it : v1) {
            st[it]++;
        }
        for (auto xt : v2) {
            if (st[xt]) {
                st[xt]--;
                ans.push_back(xt);
            }
        }
        sort(ans.begin(), ans.end());
        return ans;
    }
};

int main()
{
    int t;
    cin >> t;
    while (t--) {

        int n;
        cin >> n;
        vector<int> v1(n, 0);
        for (int i = 0; i < n; i++) {
            cin >> v1[i];
        }
        int m;
        cin >> m;
        vector<int> v2(m, 0);
        for (int i = 0; i < m; i++) {
            cin >> v2[i];
        }
        Solution ob;
        vector<int> result;
        result = ob.common_element(v1, v2);
        for (auto i : result) {
            cout << i << " ";
        }
        cout << endl;
    }
}