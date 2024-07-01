#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  int atoi(string str) {
    int neg = 1;
    int i = 0;
    if (str[0] == '-') {
      i++;
      neg = -1;
    }
    int ans = 0;
    for (i; i < str.size(); i++) {
      if (str[i] <= '9' and str[i] >= '0')
        ans = ans * 10 + str[i] - 48;
      else
        return -1;
    }
    return ans * neg;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string s;
    cin >> s;
    Solution ob;
    int ans = ob.atoi(s);
    cout << ans << endl;
  }
}