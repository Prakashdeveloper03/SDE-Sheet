#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  bool isAnagram(string a, string b) {
    int len1 = a.length();
    int len2 = b.length();
    if (len1 != len2) {
      return false;
    }
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    for (int i = 0; i < len1; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string c, d;
    cin >> c >> d;
    Solution obj;
    if (obj.isAnagram(c, d))
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}