import java.util.Scanner;

class Atoi {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t > 0) {
      String str = sc.nextLine();
      Solution obj = new Solution();
      int num = obj.atoi(str);
      System.out.println(num);
      t--;
    }
    sc.close();
  }
}

class Solution {
  int atoi(String s) {
    int neg = 1;
    int i = 0;
    if (s.charAt(0) == '-') {
      i++;
      neg = -1;
    }
    int ans = 0;
    for (; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        ans = ans * 10 + (c - '0');
      } else {
        return -1;
      }
    }
    return ans * neg;
  }
}
