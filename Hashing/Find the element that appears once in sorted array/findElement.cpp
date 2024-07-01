#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  int findOnce(int arr[], int n) {
    unordered_map<int, int> mp;
    for (int i = 0; i < n; i++) {
      mp[arr[i]]++;
    }
    for (auto pair : mp) {
      if (pair.second == 1) {
        return pair.first;
      }
    }
    return -1;
  }
};

int main() {
  int t;
  cin >> t;

  while (t--) {
    int n;
    cin >> n;
    int A[n];
    for (int i = 0; i < n; i++) {
      cin >> A[i];
    }
    Solution ob;
    int res = ob.findOnce(A, n);
    cout << res << endl;
  }
  return 0;
}