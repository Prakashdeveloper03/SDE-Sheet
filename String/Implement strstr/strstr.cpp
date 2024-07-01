#include <bits/stdc++.h>
using namespace std;
int strstr(string s, string x) {
  int t = 0, ans = 0;
  for (int i = 0; i < s.length(); i++) {
    if (s[i] == x[0]) {
      ans = i, t = 1;
      if (t == x.length()) return ans;
      while (t < x.length()) {
        if (s[i + t] == x[t++]) {
          if (t == x.length()) return ans;
        } else
          break;
      }
    }
  }
  return -1;
}

int main() {
  int t;
  cin >> t;
  while (t--) {
    string a;
    string b;

    cin >> a;
    cin >> b;

    cout << strstr(a, b) << endl;
  }
}