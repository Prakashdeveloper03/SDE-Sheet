#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  string reverseWords(string S) {
    int i = S.length() - 1;
    string ans;
    string temp = "";
    while (i >= 0) {
      if (S[i] == '.') {
        reverse(temp.begin(), temp.end());
        ans += (temp);
        ans += (".");
        temp = "";
      } else {
        temp += S[i];
      }
      i--;
    }
    reverse(temp.begin(), temp.end());
    ans += temp;
    return ans;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string s;
    cin >> s;
    Solution obj;
    cout << obj.reverseWords(s) << endl;
  }
}