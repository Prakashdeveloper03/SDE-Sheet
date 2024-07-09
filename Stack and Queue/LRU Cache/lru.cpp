#include <bits/stdc++.h>
using namespace std;
class LRUCache {
 private:
 public:
  class node {
   public:
    int key;
    int val;
    node *next;
    node *prev;
    node(int _key, int _val) {
      key = _key;
      val = _val;
    }
  };
  int capacity;
  unordered_map<int, node *> mp;
  node *head = new node(-1, -1);
  node *tail = new node(-1, -1);
  LRUCache(int cap) {
    capacity = cap;
    head->next = tail;
    tail->prev = head;
  }

  void addNode(node *newNode) {
    node *temp = head->next;
    newNode->next = temp;
    newNode->prev = head;
    head->next = newNode;
    temp->prev = newNode;
  }

  void deleteNode(node *delNode) {
    node *delPrev = delNode->prev;
    node *delNext = delNode->next;
    delPrev->next = delNext;
    delNext->prev = delPrev;
  }

  int GET(int key) {
    if (mp.find(key) != mp.end()) {
      node *res = mp[key];
      int ans = res->val;
      mp.erase(key);
      deleteNode(res);
      addNode(res);
      mp[key] = head->next;
      return ans;
    }
    return -1;
  }

  void SET(int key, int value) {
    if (mp.find(key) != mp.end()) {
      node *exist = mp[key];
      mp.erase(key);
      deleteNode(exist);
    }
    if (mp.size() == capacity) {
      mp.erase(tail->prev->key);
      deleteNode(tail->prev);
    }
    addNode(new node(key, value));
    mp[key] = head->next;
  }
};

int main() {
  int t;
  cin >> t;
  while (t--) {
    int capacity;
    cin >> capacity;
    LRUCache *cache = new LRUCache(capacity);
    int queries;
    cin >> queries;
    while (queries--) {
      string q;
      cin >> q;
      if (q == "SET") {
        int key;
        cin >> key;
        int value;
        cin >> value;
        cache->SET(key, value);
      } else {
        int key;
        cin >> key;
        cout << cache->GET(key) << " ";
      }
    }
    cout << endl;
  }
  return 0;
}