#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  static bool compare(int x, int y) {
    double board[5] = {0, INT_MAX, 2, 3 / (log(3) / log(2)), 2};
    return (x < 5 ? board[x] : x) > (y < 5 ? board[y] : y);
  }
  long long countPairs(int X[], int Y[], int M, int N) {
    sort(Y, Y + N, compare);

    long long ans = 0;
    for (int i = 0; i < M; i++) {
      ans += (lower_bound(Y, Y + N, X[i], compare) - Y);
    }
    return ans;
  }
};

int main() {
  int T;
  cin >> T;
  while (T--) {
    int M, N;
    cin >> M >> N;
    int i, a[M], b[N];
    for (i = 0; i < M; i++) {
      cin >> a[i];
    }
    for (i = 0; i < N; i++) {
      cin >> b[i];
    }
    Solution ob;
    cout << ob.countPairs(a, b, M, N) << endl;
  }
}