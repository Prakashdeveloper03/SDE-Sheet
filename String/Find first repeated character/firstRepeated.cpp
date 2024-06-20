#include <bits/stdc++.h>
using namespace std;
string firstRepChar(string s) {
  int n = s.size();
  string k = "";
  map<char, int> mp;
  for (int i = 0; i < n; i++) {
    mp[s[i]]++;
    if (mp[s[i]] == 2) {
      k = s[i];
      break;
    }
  }
  if (k == "") {
    k += "-1";
  }
  return k;
}

int main() {
  int t;
  cin >> t;
  while (t--) {
    string s;
    cin >> s;
    cout << firstRepChar(s) << endl;
  }
  return 0;
}