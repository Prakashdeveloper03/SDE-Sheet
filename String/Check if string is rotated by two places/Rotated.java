import java.util.Scanner;

class Rotated {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    for (int i = 0; i < t; i++) {
      String s1 = sc.nextLine();
      String s2 = sc.nextLine();
      Solution obj = new Solution();
      boolean flag = obj.isRotated(s1, s2);
      if (flag == true) System.out.println("1");
      else System.out.println("0");
    }
    sc.close();
  }
}

class Solution {
  public boolean isRotated(String str1, String str2) {
    if (str1.length() != str2.length()) {
      return false;
    }

    if (str1.length() < 2) {
      return str1.equals(str2);
    }

    int n = str1.length();
    String clockwiseRotation = str1.substring(n - 2) + str1.substring(0, n - 2);
    String counterclockwiseRotation = str1.substring(2) + str1.substring(0, 2);
    return str2.equals(clockwiseRotation) || str2.equals(counterclockwiseRotation);
  }
}
