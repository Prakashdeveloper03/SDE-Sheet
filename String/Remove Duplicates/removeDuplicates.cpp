#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  string removeDups(string S) {
    unordered_map<char, int> st;
    string s = "";
    for (int i = 0; i < S.size(); i++) {
      st[S[i]]++;
      if (st[S[i]] == 1)
        s += (S[i]);
    }
    return s;
  }
};

int main() {

  ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
  int t;
  cin >> t;
  while (t--) {
    string s;
    cin >> s;

    Solution ob;
    cout << ob.removeDups(s) << "\n";
  }
  return 0;
}