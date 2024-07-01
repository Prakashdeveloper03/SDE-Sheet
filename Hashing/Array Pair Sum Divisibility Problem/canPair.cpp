#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  bool canPair(vector<int> nums, int k) {
    vector<int> rems(k, 0);
    for (int i : nums) rems[i % k]++;
    for (int i = 0; i < k; i++) {
      if ((i == 0) && ((rems[0] & 0x1U) != 0)) return false;
      if ((i == (k - i)) && ((rems[i] & 0x1U) != 0)) return false;
      if ((i != 0) && (rems[i] != rems[k - i])) return false;
    }
    return true;
  }
};

int main() {
  int tc;
  cin >> tc;
  while (tc--) {
    int n, k;
    cin >> n >> k;
    vector<int> nums(n);
    for (int i = 0; i < nums.size(); i++) cin >> nums[i];
    Solution ob;
    bool ans = ob.canPair(nums, k);
    if (ans)
      cout << "True\n";
    else
      cout << "False\n";
  }
  return 0;
}