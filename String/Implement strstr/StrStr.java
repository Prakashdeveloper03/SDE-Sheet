import java.util.Scanner;

class StrStr {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t > 0) {
      String line = sc.nextLine();
      String a = line.split(" ")[0];
      String b = line.split(" ")[1];
      GfG g = new GfG();
      System.out.println(g.strstr(a, b));
      t--;
    }
    sc.close();
  }
}

class GfG {
  int strstr(String s, String x) {
    int n = s.length();
    int m = x.length();
    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++) {
        if (s.charAt(i + j) != x.charAt(j)) {
          break;
        }
      }
      if (j == m) {
        return i;
      }
    }
    return -1;
  }
}
