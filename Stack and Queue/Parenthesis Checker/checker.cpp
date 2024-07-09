#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  bool ispar(string x) {
    stack<char> paren;
    bool flag = true;
    int n = x.length();
    paren.push(x[0]);
    for (int i = 1; i < n; ++i) {
      if (x[i] == ')' || x[i] == '}' || x[i] == ']') {
        if (paren.empty()) {
          flag = false;
          break;
        } else if ((x[i] == ')' && paren.top() != '(') ||
                   (x[i] == '}' && paren.top() != '{') ||
                   (x[i] == ']' && paren.top() != '[')) {
          flag = false;
          break;
        } else {
          paren.pop();
        }
      } else {
        paren.push(x[i]);
      }
    }

    return flag && paren.empty();
  }
};

int main() {
  int t;
  string a;
  cin >> t;
  while (t--) {
    cin >> a;
    Solution obj;
    if (obj.ispar(a))
      cout << "balanced" << endl;
    else
      cout << "not balanced" << endl;
  }
}