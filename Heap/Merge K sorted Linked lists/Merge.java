import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class Merge {
  static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t-- > 0) {
      List<Node> arr = new ArrayList<>();
      List<Integer> nums = new ArrayList<>();
      String input = sc.nextLine();

      Scanner ss = new Scanner(input);
      while (ss.hasNextInt()) {
        nums.add(ss.nextInt());
      }
      ss.close();
      int ind = 0;
      int N = nums.size();
      while (ind < N) {
        int n = nums.get(ind++);
        int x = nums.get(ind++);
        Node head = new Node(x);
        Node curr = head;
        n--;

        for (int i = 0; i < n; i++) {
          x = nums.get(ind++);
          Node temp = new Node(x);
          curr.next = temp;
          curr = temp;
        }
        arr.add(head);
      }

      Solution obj = new Solution();
      Node res = obj.mergeKLists(arr);
      printList(res);
    }
    sc.close();
  }
}

class Solution {
  public Node mergeKLists(List<Node> arr) {
    if (arr == null || arr.size() == 0) return null;
    Node[] nodeArray = arr.toArray(new Node[arr.size()]);
    int K = nodeArray.length;
    return mergeKList(nodeArray, 0, K - 1);
  }

  public Node mergeKList(Node[] arr, int start, int end) {
    if (start == end) return arr[start];
    int mid = (start + end) / 2;
    Node left = mergeKList(arr, start, mid);
    Node right = mergeKList(arr, mid + 1, end);
    return merge(left, right);
  }

  public Node merge(Node l1, Node l2) {
    Node result = new Node(-1);
    Node curr = result;
    while (l1 != null || l2 != null) {
      if (l1 == null) {
        curr.next = l2;
        l2 = l2.next;
      } else if (l2 == null) {
        curr.next = l1;
        l1 = l1.next;
      } else if (l1.data < l2.data) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    return result.next;
  }
}
