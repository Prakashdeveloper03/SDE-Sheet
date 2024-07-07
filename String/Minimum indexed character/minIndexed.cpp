#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  int minIndexChar(string str, string patt) {
    int n = patt.length();
    int res = INT_MAX;
    int count[n] = {0};

    for (int i = 0; i < n; i++) {
      count[i] = str.find(patt[i]);
      if (count[i] >= 0) res = min(res, count[i]);
    }

    for (int i = 0; i < n; i++) {
      if (count[i] == -1) {
        if (res == INT_MAX)
          res = min(res, count[i]);
        else
          res = max(res, count[i]);
      }
    }
    return res;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string str;
    string patt;
    cin >> str;
    cin >> patt;
    Solution obj;
    cout << obj.minIndexChar(str, patt) << endl;
  }
  return 0;
}