#include <bits/stdc++.h>
using namespace std;

string printSequence(string S) {
  string ans = "";
  for (int i = 0; i < S.length(); i++) {
    char c = S[i];
    if (c == ' ')
      ans += '0';
    else if (c >= 'A' && c <= 'C')
      for (int i = 1; i <= c - 'A' + 1; i++) ans += "2";

    else if (c >= 'D' && c <= 'F')
      for (int i = 1; i <= c - 'D' + 1; i++) ans += "3";

    else if (c >= 'G' && c <= 'I')
      for (int i = 1; i <= c - 'G' + 1; i++) ans += "4";

    else if (c >= 'J' && c <= 'L')
      for (int i = 1; i <= c - 'J' + 1; i++) ans += "5";

    else if (c >= 'M' && c <= 'O')
      for (int i = 1; i <= c - 'M' + 1; i++) ans += "6";

    else if (c >= 'P' && c <= 'S')
      for (int i = 1; i <= c - 'P' + 1; i++) ans += "7";

    else if (c >= 'T' && c <= 'V')
      for (int i = 1; i <= c - 'T' + 1; i++) ans += "8";

    else if (c >= 'W' && c <= 'Z')
      for (int i = 1; i <= c - 'W' + 1; i++) ans += "9";
  }

  return ans;
}

int main() {
  int t;
  cin >> t;
  cin.ignore();
  while (t--) {
    string s;
    getline(cin, s);
    cout << printSequence(s) << endl;
  }
  return 0;
}