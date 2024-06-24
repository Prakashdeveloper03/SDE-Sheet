#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
  int romanToDecimal(string &str) {
    unordered_map<char, int> num;
    num['I'] = 1;
    num['V'] = 5;
    num['X'] = 10;
    num['L'] = 50;
    num['C'] = 100;
    num['D'] = 500;
    num['M'] = 1000;
    int n = str.length();
    int ans = num[str[n - 1]];
    for (int i = n - 1; i - 1 >= 0; i--) {
      if (num[str[i]] > num[str[i - 1]]) {
        ans -= num[str[i - 1]];
      } else {
        ans += num[str[i - 1]];
      }
    }
    return ans;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string s;
    cin >> s;
    Solution ob;
    cout << ob.romanToDecimal(s) << endl;
  }
}