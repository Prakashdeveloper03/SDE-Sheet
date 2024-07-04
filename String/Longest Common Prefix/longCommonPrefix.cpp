#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  string longestCommonPrefix(int n, string arr[]) {
    sort(arr, arr + n);
    string st = arr[0];
    string en = arr[n - 1];
    string str = "";
    for (int i = 0; i < min(st.size(), en.size()); i++) {
      if (st[i] != en[i]) break;
      str += st[i];
    }
    if (str == "") return "-1";
    return str;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    string arr[n];
    for (int i = 0; i < n; ++i) cin >> arr[i];
    Solution ob;
    cout << ob.longestCommonPrefix(n, arr) << endl;
  }
}