#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  vector<int> search(string pattern, string text) {
    int n = text.size();
    int k = pattern.size();
    vector<int> res;
    for (int i = 0; i < n; i++) {
      if (pattern == text.substr(i, k)) {
        res.push_back(i + 1);
      }
    }
    return res;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string S, pat;
    cin >> S >> pat;
    Solution ob;
    vector<int> res = ob.search(pat, S);
    for (int i : res) cout << i << " ";
    cout << endl;
  }
  return 0;
}