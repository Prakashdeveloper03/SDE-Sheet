#include <bits/stdc++.h>
using namespace std;
class Solution {
  int minEle;
  stack<int> st;

 public:
  int getMin() {
    if (st.empty()) return -1;
    return minEle;
  }

  int pop() {
    if (st.empty()) return -1;
    int curr = st.top();
    st.pop();

    if (curr >= minEle) {
      return curr;
    } else {
      int preMini = minEle;
      int val = 2 * minEle - curr;
      minEle = val;
      return preMini;
    }
  }

  void push(int data) {
    if (st.empty()) {
      st.push(data);
      minEle = data;
    } else if (data >= minEle) {
      st.push(data);
    } else if (data < minEle) {
      int val = 2 * data - minEle;
      st.push(val);
      minEle = data;
    }
  }
};

int main() {
  long long t;
  cin >> t;
  while (t--) {
    int q;
    cin >> q;
    Solution ob;
    while (q--) {
      int qt;
      cin >> qt;
      if (qt == 1) {
        int att;
        cin >> att;
        ob.push(att);
      } else if (qt == 2) {
        cout << ob.pop() << " ";
      } else if (qt == 3) {
        cout << ob.getMin() << " ";
      }
    }
    cout << endl;
  }
  return 0;
}