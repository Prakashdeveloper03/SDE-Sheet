#include <bits/stdc++.h>
using namespace std;
int longestSubstrDistinctChars(string S);
int main() {
  int t;
  cin >> t;
  while (t--) {
    string S;
    cin >> S;

    cout << longestSubstrDistinctChars(S) << endl;
  }
}

int longestSubstrDistinctChars(string S) {
  int n = S.size();
  int r = 0;
  int l = 0;
  int len = 0;
  unordered_map<char, int> mp;
  while (r < n) {
    mp[S[r]]++;
    if (mp[S[r]] > 1) {
      while (mp[S[r]] > 1) {
        mp[S[l]]--;
        if (mp[S[l]] == 0) {
          mp.erase(S[l]);
        }
        l++;
      }
    }
    if (mp[S[r]] <= 1) {
      len = max(len, r - l + 1);
    }
    r++;
  }
  return len;
}