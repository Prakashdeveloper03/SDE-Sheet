#include <bits/stdc++.h>
using namespace std;
class Solution {
 public:
  vector<vector<int>> fourSum(vector<int> &nums, int target) {
    sort(nums.begin(), nums.end());
    int n = nums.size();

    vector<vector<int>> result;
    set<vector<int>> resultSet;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        int left = j + 1, right = n - 1;
        int remainingTarget = target - nums[i] - nums[j];

        while (left < right) {
          int sum = nums[left] + nums[right];
          if (sum < remainingTarget)
            left++;
          else if (sum > remainingTarget)
            right--;
          else {
            vector<int> quad;
            quad.push_back(nums[i]);
            quad.push_back(nums[j]);
            quad.push_back(nums[left]);
            quad.push_back(nums[right]);
            resultSet.insert(quad);
            left++;
            right--;
          }
        }
      }
    }

    for (auto it : resultSet) result.push_back(it);

    return result;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, k, i;
    cin >> n >> k;
    vector<int> a(n);
    for (i = 0; i < n; i++) {
      cin >> a[i];
    }
    Solution ob;
    vector<vector<int>> ans = ob.fourSum(a, k);
    for (auto &v : ans) {
      for (int &u : v) {
        cout << u << " ";
      }
      cout << "$";
    }
    if (ans.empty()) {
      cout << -1;
    }
    cout << "\n";
  }
  return 0;
}