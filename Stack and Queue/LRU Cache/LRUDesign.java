import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LRUDesign {
  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      int capacity = Integer.parseInt(read.readLine());
      int queries = Integer.parseInt(read.readLine());
      LRUCache cache = new LRUCache(capacity);
      String str[] = read.readLine().trim().split(" ");
      int len = str.length;
      int itr = 0;
      for (int i = 0; (i < queries) && (itr < len); i++) {
        String queryType = str[itr++];
        if (queryType.equals("SET")) {
          int key = Integer.parseInt(str[itr++]);
          int value = Integer.parseInt(str[itr++]);
          cache.set(key, value);
        }
        if (queryType.equals("GET")) {
          int key = Integer.parseInt(str[itr++]);
          System.out.print(cache.get(key) + " ");
        }
      }
      System.out.println();
    }
  }
}

class LRUCache {
  class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int _key, int _val) {
      key = _key;
      val = _val;
    }
  }

  private final int capacity;
  private final Map<Integer, Node> map;
  private final Node head;
  private final Node tail;

  public LRUCache(int cap) {
    capacity = cap;
    map = new HashMap<>();
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  private void addNode(Node newNode) {
    Node temp = head.next;
    newNode.next = temp;
    newNode.prev = head;
    head.next = newNode;
    temp.prev = newNode;
  }

  private void deleteNode(Node delNode) {
    Node delPrev = delNode.prev;
    Node delNext = delNode.next;
    delPrev.next = delNext;
    delNext.prev = delPrev;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node res = map.get(key);
      int ans = res.val;
      map.remove(key);
      deleteNode(res);
      addNode(res);
      map.put(key, head.next);
      return ans;
    }
    return -1;
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      Node exist = map.get(key);
      map.remove(key);
      deleteNode(exist);
    }
    if (map.size() == capacity) {
      map.remove(tail.prev.key);
      deleteNode(tail.prev);
    }
    Node newNode = new Node(key, value);
    addNode(newNode);
    map.put(key, head.next);
  }
}
