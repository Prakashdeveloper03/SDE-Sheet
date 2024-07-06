#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  string UncommonChars(string A, string B) {
    map<char, bool> mp;

    for (int i = 0; i < A.size(); i++) {
      mp[A[i]] = true;
    }

    string ans = "";

    for (int i = 0; i < B.size(); i++) {
      if (mp.find(B[i]) == mp.end()) {
        ans += B[i];
        mp[B[i]] = false;
      } else {
        mp[B[i]] = false;
      }
    }
    for (auto it : mp) {
      if (it.second == true) {
        ans += it.first;
        it.second = false;
      }
    }

    sort(ans.begin(), ans.end());
    if (ans.empty()) {
      return "-1";
    }
    return ans;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string A, B;
    cin >> A;
    cin >> B;
    Solution ob;
    cout << ob.UncommonChars(A, B);
    cout << endl;
  }
  return 0;
}