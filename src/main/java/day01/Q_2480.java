package day01;

import java.util.Scanner;

public class Q_2480 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int a = in.nextInt();
    int b = in.nextInt();
    int c = in.nextInt();

    in.close();

    // 모두 같을 경우
    if (a == b && a == c) {
      System.out.println(10000 + a * 1000);
      // a == b or a == c
    } else if (a == b && a != c || a == c && a != b) {
      System.out.println(1000 + a * 100);
      // b == c
    } else if (b == c && b != a) {
      System.out.println(1000 + b * 100);
      // 모두 다를 경우
    } else {
      int max = a;
      if (max < b) {
        max = b;
      }
      if (max < c) {
        max = c;
      }
      System.out.println(max * 100);
    }
  }
}
