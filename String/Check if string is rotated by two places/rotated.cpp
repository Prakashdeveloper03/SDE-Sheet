#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  bool isRotated(string str1, string str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    if (str1.length() < 2) {
      return str1 == str2;
    }

    int n = str1.length();
    string clockwiseRotation = str1.substr(n - 2, 2) + str1.substr(0, n - 2);
    string counterclockwiseRotation = str1.substr(2, n - 2) + str1.substr(0, 2);
    return (str2 == clockwiseRotation) || (str2 == counterclockwiseRotation);
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    string s;
    string b;
    cin >> s >> b;
    Solution obj;
    cout << obj.isRotated(s, b) << endl;
  }
  return 0;
}